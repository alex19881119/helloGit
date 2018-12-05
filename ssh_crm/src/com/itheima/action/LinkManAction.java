package com.itheima.action;

import java.io.File;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.itheima.domain.Customer;
import com.itheima.domain.LinkMan;
import com.itheima.domain.User;
import com.itheima.service.CustomerService;
import com.itheima.service.LinkManService;
import com.itheima.service.UserService;

import com.itheima.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan>{
	private LinkManService linkManService;
	private LinkMan linkMan = new LinkMan();
	private Integer currentPage;
	private Integer pageSize;

	public String list() throws Exception {
		//封装离线查询对象
		DetachedCriteria dc =DetachedCriteria.forClass(LinkMan.class);
		if(StringUtils.isNotBlank(linkMan.getLkm_name())) {
			dc.add(Restrictions.like("lkm_name", "%"+linkMan.getLkm_name()+"%"));
		}
		if(linkMan.getCustomer()!=null && linkMan.getCustomer().getCust_id()!=null) {
		    dc.add(Restrictions.eq("customer.cust_id", linkMan.getCustomer().getCust_id()));
		}    
		PageBean pageBean = linkManService.getPageBean(dc,currentPage,pageSize);
		
		ActionContext.getContext().put("pageBean", pageBean);
		return "list";
	}


	
	public String add() throws Exception {
		linkManService.save(linkMan);
		
		return "toList";
		
	}
	public String toEdit() throws Exception {
		LinkMan lm = linkManService.getById(linkMan.getLkm_id());
		
		ActionContext.getContext().put("linkman", lm);
		return "add";
	}




	@Override
	public LinkMan getModel() {
		return linkMan;
	}




	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	
}
