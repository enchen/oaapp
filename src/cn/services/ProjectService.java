package cn.services;

import java.util.List;

import cn.beans.Project;
import cn.beans.User;
import cn.dto.CreateProject;

public interface ProjectService {
	
	/**
	 * 创建项目
	 * @param cp
	 * @return 1为成功 0为失败
	 */
	public String createNewProject(User user,CreateProject cp);
	public List<Project> getProjects(int state);
	public List<Project> getChargeProjects(int userId);

}
