package com.itheima.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.itheima.dao.LinkManDao;
import com.itheima.domain.Customer;
import com.itheima.domain.LinkMan;
import com.itheima.service.LinkManService;
import com.itheima.utils.PageBean;

public class LinkManServiceImpl implements LinkManService{
	private LinkManDao lmd;
	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//1.调用dao查询总记录数
		Integer totalCount = lmd.getTotalCount(dc);
		//2.创建pagebean对象
		PageBean pageBean = new PageBean(currentPage, totalCount, pageSize);
		//3.调用到查询分页列表数据
		List<LinkMan> list = lmd.getPageList(dc,pageBean.getStart(),pageBean.getPageSize());
		//4.列表数据放入pagebean中，并返回
		pageBean.setList(list);
		
		
		return pageBean;
	}
	
	
	@Override
	public void save(LinkMan linkMan) {
		lmd.saveOrUpdate(linkMan);
		
	}
	


	@Override
	public LinkMan getById(Long lkm_id) {
		return lmd.getById(lkm_id);
		
	}
	
	public void setLmd(LinkManDao lmd) {
		this.lmd = lmd;
	}


	@Override
	public void delete(LinkMan linkMan) {
		lmd.delete(linkMan);
		
	}

}
