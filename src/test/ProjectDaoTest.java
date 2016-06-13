package test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.beans.Project;
import cn.dao.ProjectDao;

/**
 * 配置junit和spring整合，junit启动时加载springIOC容器
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件位置
@ContextConfiguration({"classpath:spring.xml"})
public class ProjectDaoTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Resource
	private ProjectDao pDao;
	@Test
	public void testCreateProject() {
	
	}

	@Test
	public void testUpdateProject() {
		SimpleDateFormat str2date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Project pj=new Project();
		try {
			pj.setEndTime(str2date.parse(""));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fail("Not yet implemented");
	}

	@Test
	public void testGetProjectSort() {
		try
		{
		List<HashMap<String,Object>> hms=pDao.getProjectSort();
		System.out.println(hms.size());
		for(HashMap hm:hms)
		{
		int state= (Integer)hm.get("state");
		int count=((Long)hm.get("count")).intValue();
		System.out.println(state);
		System.out.println(count);
		}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
