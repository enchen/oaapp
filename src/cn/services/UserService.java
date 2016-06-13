package cn.services;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.beans.User;
import cn.dto.LoginKey;


public interface UserService {
	/**
	 * 
	 * @param name 用户名
	 * @param pass 用户密码
	 * @return 登陆凭据
	 */
public LoginKey userLogin(String name,String pass);
public boolean checkRight(String token,String placeToGo);
public List<User> getUsers();
public List<User> getProjectUsers(int projectId);
}

