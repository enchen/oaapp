package cn.dao;

import java.util.List;

import cn.beans.User;

public interface UserDao {
	User login(String name,String pass);
	int updatePass(User user);
	List<User> getUsers();
	List<User> getProjectUsers(int projectId);
	int iskeyUser(int userId,int projectId);
	

}
