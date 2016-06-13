package cn.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.beans.Task;
import cn.dao.TaskDao;
import cn.services.TaskService;

@Service("taskService")
public class TaskServiceImpl implements TaskService {
	@Autowired
	TaskDao taskDao;

	@Override
	public int createNewTask(Task task) {
		return	taskDao.createNewTask(task);

	}

	@Override
	public List<Task> getProjectList(int projectId) {
		return taskDao.getProjectList(projectId);
	}

}
