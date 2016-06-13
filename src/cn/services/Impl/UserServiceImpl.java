package cn.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.beans.User;
import cn.dao.UserDao;
import cn.dto.LoginKey;
import cn.services.UserService;
import cn.util.RedisTool;
import cn.util.Tools;
@Service("userService")
public class UserServiceImpl implements UserService  {
	@Autowired
    private  UserDao userDao;

	@Override
	public LoginKey userLogin(String name,String pass)
	{
		User loginUser=userDao.login(name, pass);
		LoginKey loginKey=new LoginKey();
		if(loginUser!=null)
		{
			String token=Tools.generateToken();
			RedisTool.getInstance().put(token, loginUser);
//			User user=RedisTool.getInstance().get(token);
//			RedisTool.getInstance().delete(token);
			loginKey.setIsadmin(loginUser.getIsAdmin());
			loginKey.setKey(token);
			loginKey.setLogin(1);
			return loginKey;  //登陆成功 0：普通用户 1：管理员
		}
		else
		{
			loginKey.setLogin(0);
			return loginKey;             //登陆失败
		}
	}
	@Override
	public boolean checkRight(String token, String placeToGo) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userDao.getUsers();
	}
	@Override
	public List<User> getProjectUsers(int projectId) {
		// TODO Auto-generated method stub
		return userDao.getProjectUsers(projectId);
	}

}
