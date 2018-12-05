package com.itheima.service;

import com.itheima.domain.User;

public interface UserService {
	 //登录
	 User getUserByCodePassword(User u);
	 
	 void saveUser(User u);

	
}
