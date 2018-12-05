package com.itheima.action;

import java.io.File;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.itheima.domain.Customer;
import com.itheima.domain.User;
import com.itheima.service.CustomerService;
import com.itheima.service.UserService;
import com.itheima.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	private CustomerService customerService;
	private Customer customer = new Customer();
	
	private File photo;//上传文件自动封装
	private String photoFileName;//在提交键名后加上后缀FileName，文件名会自动封装
	private String photoContentType;//在提交键名后加上后缀ContentType，文件名mime类型自动封装
	
	private Integer currentPage;
	private Integer pageSize;
	public String list() throws Exception {
		//封装离线查询对象
		DetachedCriteria dc =DetachedCriteria.forClass(Customer.class);
		if(StringUtils.isNotBlank(customer.getCust_name())) {
			dc.add(Restrictions.like("cust_name", "%"+customer.getCust_name()+"%"));
		}
		
		PageBean pageBean = customerService.getPageBean(dc,currentPage,pageSize);
		
		ActionContext.getContext().put("pageBean", pageBean);
		return "list";
	}

	
	public String add() throws Exception {
		if(photo!=null) {
			photo.renameTo(new File("D:/BaiduYunDownload/"+photoFileName));
		}
		
		
		//System.out.println(photoFileName);
		//System.out.println(photoContentType);
		//调用service保存customer对象
		
		customerService.save(customer);
		//System.out.println(customer);
		return "toList";
	}
	
	public String toEdit() throws Exception {
		//1.调用service根据id查询客户对象
		Customer c = customerService.getById(customer.getCust_id());
		//2.将客户对象放置到request域
		ActionContext.getContext().put("customer", c);
		return "edit";
	}



	@Override
	public Customer getModel() {
		return customer;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}


	public File getPhoto() {
		return photo;
	}


	public void setPhoto(File photo) {
		this.photo = photo;
	}


	public String getPhotoFileName() {
		return photoFileName;
	}


	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}


	public String getPhotoContentType() {
		return photoContentType;
	}


	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}

	
	
}
