package cn.services;

import java.util.List;

import cn.beans.Task;

public interface TaskService {
	public int createNewTask(Task task);
    List<Task> getProjectList(int projectId);
}
