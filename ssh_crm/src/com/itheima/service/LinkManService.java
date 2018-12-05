package com.itheima.service;

import org.hibernate.criterion.DetachedCriteria;

import com.itheima.domain.LinkMan;
import com.itheima.utils.PageBean;

public interface LinkManService {
	//保存联系人
	void save(LinkMan linkMan);
	
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

	LinkMan getById(Long lkm_id);
}
