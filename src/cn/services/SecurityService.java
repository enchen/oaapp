package cn.services;

import cn.beans.User;

public interface SecurityService {
	User isAdmin(String token);
	User isKeyPerson(String token,int projectId);
	User isUser(String token);
	
}
