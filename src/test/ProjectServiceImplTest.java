package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.beans.Project;
import cn.beans.ProjectToPerson;
import cn.beans.User;
import cn.dto.CreateProject;
import cn.services.ProjectService;
import cn.services.Impl.ProjectServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件位置
@ContextConfiguration({"classpath:spring.xml"})
public class ProjectServiceImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Autowired
	ProjectService projectService;
	
	@Test
	public void testCreateNewProject() {
		User user=new User();
		user.setId(0000);
		user.setName("wakaka");
		CreateProject cp=new CreateProject();
		List<ProjectToPerson> p2ps=new ArrayList<ProjectToPerson>();
		for(int i=0;i<5;i++)
		{
		ProjectToPerson p2p=new ProjectToPerson();
		p2p.setPosition(i);
		p2p.setUserId(i);
		p2ps.add(p2p);
		}
		Project p=new Project();
		p.setPlanEndTime(new Date());
		p.setProjectContent("测试content");
		p.setProjectName("Name");
		p.setStartTime(new Date());
	
		cp.setP2p(p2ps);
		cp.setProject(p);

		projectService.createNewProject(user, cp);
		
	}

}
