package com.itheima.dao;

import com.itheima.domain.User;

public interface UserDao extends BaseDao<User>{
	//根据登录名称查询User对象
	User getByUserCode(String usercode);

	
}
