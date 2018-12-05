package com.itheima.service.impl;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.service.UserService;
@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
public class UserServiceImpl implements UserService {
	private UserDao ud;
	@Override
	public User getUserByCodePassword(User u) {
		//根据登录名称查询登录用户
		User existU = ud.getByUserCode(u.getUser_code());
		//判断用户是否存在，不存在跑出异常，提示用户名不存在
		if(existU==null) {
			throw new RuntimeException("用户名不存在");
		}
		
		//判断密码是否正确，不正确跑出异常，提示密码错误
		if(!existU.getUser_password().equals(u.getUser_password())) {
			throw new RuntimeException("密码错误");
		}
		
		//返回查询用户对象
		
		return existU;
	}

	@Override
	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
	public void saveUser(User u) {
		//调用dao根据注册登录名获得用户对象
		User exitU = ud.getByUserCode(u.getUser_code());
		//如果获得则抛异常用户名存在
		if(exitU!=null) {
			throw new RuntimeException("用户名已存在");
		}
		ud.save(u);
	}

	public void setUd(UserDao ud) {
		this.ud = ud;
	}
	
}
