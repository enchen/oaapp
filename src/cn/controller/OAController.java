package cn.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.beans.Project;
import cn.beans.ProjectToPerson;
import cn.beans.Task;
import cn.beans.User;
import cn.dao.TaskDao;
import cn.dao.UserDao;
import cn.dto.CreateProject;
import cn.dto.CreateTask;
import cn.dto.LoginKey;
import cn.dto.State;
import cn.services.NewsService;
import cn.services.ProjectService;
import cn.services.SecurityService;
import cn.services.TaskService;
import cn.services.UserService;

@RestController
public class OAController {
	
	 @Autowired
	 UserService userService;
	 @Autowired
	 ProjectService projectService;
	 @Autowired
	 NewsService newsService;
	 @Autowired
	 SecurityService securityService;
	 @Autowired
	 TaskService taskService;
	 //@RequestMapping(value="/login",method=RequestMethod.POST,produces = "text/plain; charset=utf-8")//指定produces，默认返回json格式，angular按照json格式解析纯字符串错误
	 @RequestMapping(value="/login",method=RequestMethod.POST)//默认返回json格式
	 public @ResponseBody LoginKey login(@RequestBody User user){
		 LoginKey re=userService.userLogin(user.getName(), user.getPass());
//		 User userv=new User();
//		 userv.setId(100);
		
		return re;
		 
	 }
	 
	 /**
	  * 获取用户列表
	  * @return
	  */
	 @RequestMapping(value="/getusers",method=RequestMethod.POST)//默认返回json格式
	 public @ResponseBody List<User> getUsers(){
		return userService.getUsers();
		 
	 }
	 
	 
	 /**
	  * 创建新项目
	  * @param user
	  * @return
	  */
	 @RequestMapping(value="/createproject",method=RequestMethod.POST,produces = "text/plain; charset=utf-8")//
	 public @ResponseBody String createProject(@RequestBody CreateProject cp){

		 //projectService.createNewProject(cp);	
		 User user=null;
		 if(cp!=null)
		 {
		 user=securityService.isAdmin(cp.getToken().substring(0,32));
		 }
		 if(user!=null)
		 {
		   return projectService.createNewProject(user,cp);
		 }
		 else
		 {
			
		 }
		 return "";
		 
	 }
	 
	 /**
	  * 获取项目列表
	  * @return
	  */
	 @RequestMapping(value="/getprojects",method=RequestMethod.POST)//默认返回json格式
	 public @ResponseBody List<Project> getProjects(State state){
		return projectService.getProjects(state.getState());
		 
	 }
	 
	 /**
	  * 获取责任项目列表
	  * @return
	  */
	 @RequestMapping(value="/getchargeprojects",method=RequestMethod.POST)//默认返回json格式
	 public @ResponseBody List<Project> getChangeProjects(@RequestBody State state){
		 User user=null;
		 if(state!=null||!state.getToken().equals("")||state.getToken()!=null)
		 {
		 user=securityService.isUser(state.getToken().substring(0,32));
		 }
		 if(user!=null)
		 {
			 return projectService.getChargeProjects(user.getId());
		 }
		 else
		 {
			
		 }
		 return null;
		
		 
	 }
	 
	 /**
	  * 获取项目人员
	  * @return
	  */
	 @RequestMapping(value="/getprojectpersons",method=RequestMethod.POST)//默认返回json格式
	 public @ResponseBody List<User> getProjectPersons(@RequestBody State state){
		 User user=null;
		 if(state!=null||!state.getToken().equals("")||state.getToken()!=null)
		 {
		 user=securityService.isKeyPerson(state.getToken().substring(0,32),state.getState());
		 }
		 if(user!=null)
		 {
			 return userService.getProjectUsers(state.getState());
		 }

		 return null;
		 
	 }

	
	@RequestMapping(value="/createtask",method=RequestMethod.POST)
	 public @ResponseBody State createTask(@RequestBody CreateTask ct){
		 State state=new State();
		 User user=null;
		 if(ct!=null||!ct.getToken().equals(""))
		 {
		 user=securityService.isKeyPerson(ct.getToken().substring(0,32),ct.getTask().getProjectId());
		 }
		 if(user!=null)
		 {
			Task task=ct.getTask();
         state.setState(taskService.createNewTask(task));
			
		 }
        return state;
	 }
	 
	 @RequestMapping(value="/getprojecttask",method=RequestMethod.POST)//默认返回json格式
	 public @ResponseBody List<Task> getProjectTask(@RequestBody State state){
		 User user=null;
		 if(state!=null||!state.getToken().equals(""))
		 {
		 user=securityService.isKeyPerson(state.getToken().substring(0,32),state.getState());
		 }
		 if(user!=null)
		 {
			
			return taskService.getProjectList(state.getState());
			
		 }
     return null;
	 }
}
