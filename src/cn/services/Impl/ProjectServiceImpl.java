package cn.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.beans.News;
import cn.beans.Project;
import cn.beans.ProjectToPerson;
import cn.beans.User;
import cn.dao.NewsDao;
import cn.dao.ProjectDao;
import cn.dto.CreateProject;
import cn.services.ProjectService;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private NewsDao newsDao;

	@Override
	@Transactional // 保证事务执行时间尽可能短，不要穿插其他的网络操作RPC/HTTP(剥离到事务方法外部)
	public String createNewProject(User user, CreateProject cp) {

		String re = "0";
		Project project = cp.getProject();
		project.setState(0);//
		projectDao.createProject(project);
		int pId = project.getProjectId();

		List<ProjectToPerson> p2p = cp.getP2p();
		for (int i = 0; i < p2p.size(); i++) {
			p2p.get(i).setProjectId(pId);
		}
		projectDao.batchInsertRelatedPerson(p2p);
		News news = new News();
		news.setNewsContent(user.getName() + "创建了新项目:" + project.getProjectName());
		news.setNewsId(pId);
		news.setFrom(user.getId());
		news.setOperate(0);
		news.setType(0);

		newsDao.insertNews(news);
		re = "1";

		return re;
	}

	@Override
	public List<Project> getProjects(int state) {
		// TODO Auto-generated method stub
		List<Project> pjs = projectDao.getProjects(state);
		return pjs;
	}

	@Override
	public List<Project> getChargeProjects(int userId) {
		// TODO Auto-generated method stub
		return projectDao.getChargedProjects(userId);
	}

}
