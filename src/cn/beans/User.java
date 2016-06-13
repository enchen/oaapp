package cn.beans;

import java.io.Serializable;

public class User{

	/**
	 * 
	 */
//	private static final long serialVersionUID = 7243243005759334597L;
//	public static final String OBJECT_KEY = "User";//反序列化不失败
	private String name; //用户名
	private int id; //用户id 自增1000起步
	private int roleId; //权限角色，完善权限系统
	private String pass;//登陆密码
	private int isAdmin;//admin标志位 默认为0
//	public User() {  
//    }  
	public String getName() {
		return name;
	}
	  public String toString() {  
	        return "User [id=" + id + ", name=" + name + "]";  
	    } 
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}


	

}
