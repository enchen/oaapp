package cn.dto;

import cn.beans.Task;

public class CreateTask {
	private String token;
	private Task task;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}

}
