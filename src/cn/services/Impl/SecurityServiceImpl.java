package cn.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.beans.User;
import cn.dao.UserDao;
import cn.services.SecurityService;
import cn.util.RedisTool;
@Service("securityService")
public class SecurityServiceImpl implements SecurityService {

	@Autowired
	private UserDao userDao;
	@Override
	public User isAdmin(String token) {
		User user=null;
		if("".equals(token))
		{
			return null;
		}
		user=RedisTool.getInstance().get(token);
		if(user!=null&&user.getIsAdmin()==1)
		{
			return user;
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User isKeyPerson(String token, int projectId) {
		User user=null;
		if("".equals(token))
		{
			return null;
		}
		user=RedisTool.getInstance().get(token);
		if(user!=null)
		{
			int findKey=userDao.iskeyUser(user.getId(), projectId);
			if(findKey==1)
			{return user;}
			else
			{return null;}
			
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User isUser(String token) {
		User user=null;
		if("".equals(token))
		{
			return null;
		}
		user=RedisTool.getInstance().get(token);
		if(user!=null)
		{
			return user;
		}
		// TODO Auto-generated method stub
		return null;
	}

}
