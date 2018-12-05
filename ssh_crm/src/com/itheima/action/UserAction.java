package com.itheima.action;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private UserService userService;
	private User user = new User();
	
	public String login() throws Exception {
		//1.调用service执行登录逻辑
		User u = userService.getUserByCodePassword(user);
		//2将返回的user对象放入session
		ActionContext.getContext().getSession().put("user", u);
		//3重定向到项目首页
		return "toHome";
	}
	
	
	public String regist() throws Exception {
		//1.调用service执行注册逻辑
		try {
			userService.saveUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			ActionContext.getContext().put("error", e.getMessage());
			return "regist";
		}
		
		//2重定向到登录
		return "toLogin";
	}

	
	
	
	@Override
	public User getModel() {
		return user;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
