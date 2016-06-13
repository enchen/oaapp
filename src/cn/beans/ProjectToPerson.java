package cn.beans;

import java.util.Date;

public class ProjectToPerson {
private int projectId;
private int userId;
private Date createTime;
private int position;//0普通，1负责人
public int getProjectId() {
	return projectId;
}
public void setProjectId(int projectId) {
	this.projectId = projectId;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public Date getCreateTime() {
	return createTime;
}
public void setCreateTime(Date createTime) {
	this.createTime = createTime;
}
public int getPosition() {
	return position;
}
public void setPosition(int position) {
	this.position = position;
}
}
