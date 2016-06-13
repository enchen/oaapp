package cn.dto;

import java.util.List;

import cn.beans.Project;
import cn.beans.ProjectToPerson;

public class CreateProject {
	private String token;
	private Project project;;
	private List<ProjectToPerson> p2p;
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public List<ProjectToPerson> getP2p() {
		return p2p;
	}
	public void setP2p(List<ProjectToPerson> p2p) {
		this.p2p = p2p;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

}
