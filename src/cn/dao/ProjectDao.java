package cn.dao;

import java.util.HashMap;
import java.util.List;

import cn.beans.Project;
import cn.beans.ProjectToPerson;

public interface ProjectDao {
	int createProject(Project proj);
	int updateProject(Project proj);
	List<HashMap<String,Object>> getProjectSort();
	int batchInsertRelatedPerson(List<ProjectToPerson> p2p);
	List<Project> getProjects(int state);
	List<Project> getChargedProjects(int userId);
	

}
