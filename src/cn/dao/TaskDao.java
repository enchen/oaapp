package cn.dao;

import java.util.List;

import cn.beans.Task;

public interface TaskDao {
	int createNewTask(Task task);
	List<Task> getProjectList(int projectId);

}
