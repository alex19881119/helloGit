package com.itheima.test;

import java.lang.annotation.Annotation;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.service.UserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class demo {
	@Resource
	private SessionFactory sf;
	@Test
	public void fun() {
		Configuration conf = new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();	
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		User u = new User();
		u.setUser_code("tom");
		u.setUser_password("123");
		session.save(u);
		tx.commit();
		session.close();
	}
	
	@Test
	public void fun2() {	
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		User u = new User();
		u.setUser_code("jack");
		u.setUser_password("123");
		session.save(u);
		tx.commit();
		session.close();
	}
	
	@Resource(name="userDao")
	private UserDao ud;
	@Test
	//测试dao Hibernate模板
	public void fun3() {	
		User u = ud.getByUserCode("tom");
		System.out.println(u);
	}
	
	
	@Resource(name="userService")
	private UserService us;
	@Test
	//测试aop事务
	public void fun4() {	
		User u = new User();
		u.setUser_code("hehe");
		us.saveUser(u);
		
	}
	
	
	
}
