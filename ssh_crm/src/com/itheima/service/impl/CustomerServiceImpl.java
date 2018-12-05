package com.itheima.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.dao.CustomerDao;
import com.itheima.domain.Customer;
import com.itheima.service.CustomerService;
import com.itheima.utils.PageBean;

public class CustomerServiceImpl implements CustomerService{
	private CustomerDao cd;
	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//1.调用dao查询总记录数
		Integer totalCount = cd.getTotalCount(dc);
		//2.创建pagebean对象
		PageBean pageBean = new PageBean(currentPage, totalCount, pageSize);
		//3.调用到查询分页列表数据
		List<Customer> list = cd.getPageList(dc,pageBean.getStart(),pageBean.getPageSize());
		//4.列表数据放入pagebean中，并返回
		pageBean.setList(list);
		
		
		return pageBean;
	}
	
	
	
	@Override
	
	public void save(Customer customer) {
		//1.维护customer与数据字典的对象关系由于struts2的参数封装，会将参数封装到数据字典id属性
		//那么我们无需手动维护关系
		//2.调用dao保存客户
		//System.out.println(customer);
	    
		cd.saveOrUpdate(customer);
		
	}
	
	@Override
	public Customer getById(Long cust_id) {
		
		return cd.getById(cust_id);
	}
	
	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}



	

}
