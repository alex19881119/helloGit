package com.itheima.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.itheima.domain.BaseDict;
import com.itheima.service.BaseDictService;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;

public class BaseDictAction extends ActionSupport{
	private String dict_type_code;
	
	private BaseDictService baseDictService;
	@Override
	public String execute() throws Exception {
		//1.调用service根据typecode获得数据字典list
		List<BaseDict> list = baseDictService.findListByTypeCode(dict_type_code);
		//2.将list转换为json
		String json = JSONArray.fromObject(list).toString();
		//3.将json发送给浏览器
		
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		return null;//不需要结果处理
	}
	
	public String getDict_type_code() {
		return dict_type_code;
	}

	public void setDict_type_code(String dict_type_code) {
		this.dict_type_code = dict_type_code;
	}

	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}
	
}
