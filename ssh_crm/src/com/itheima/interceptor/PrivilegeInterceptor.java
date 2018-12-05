package com.itheima.interceptor;

import java.util.Map;

import com.itheima.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class PrivilegeInterceptor extends MethodFilterInterceptor{

	@Override
	//不校验登录和注册方法
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//获得session
		Map<String, Object> session = ActionContext.getContext().getSession();
		//获得登录标识
		User user = (User) session.get("user");
		if(user!=null) {
			return invocation.invoke();
		}else {
			return "toLogin";
		}
		
		
		
	}

}
