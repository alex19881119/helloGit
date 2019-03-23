package com.itheima.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.itheima.domain.Customer;
import com.itheima.utils.PageBean;

public interface CustomerService {
	//分页业务方法
	

	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

	//保存客户
	void save(Customer customer);

    //根据id获得客户对象
	Customer getById(Long cust_id);
	
	List<Object[]> getIndustryCount(String source);

	void delete(Customer customer);
}
