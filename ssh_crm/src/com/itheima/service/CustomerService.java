package com.itheima.service;

import org.hibernate.criterion.DetachedCriteria;

import com.itheima.domain.Customer;
import com.itheima.utils.PageBean;

public interface CustomerService {
	//分页业务方法
	

	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

	
	void save(Customer customer);


	Customer getById(Long cust_id);
	
}
