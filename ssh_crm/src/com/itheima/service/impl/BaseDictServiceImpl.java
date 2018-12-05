package com.itheima.service.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itheima.dao.BaseDictDao;
import com.itheima.domain.BaseDict;
import com.itheima.service.BaseDictService;

public class BaseDictServiceImpl implements BaseDictService{
	private BaseDictDao bdd;
	@Override
	public List<BaseDict> findListByTypeCode(String dict_type_code) {
		List<BaseDict> list =bdd.findListByTypeCode(dict_type_code);
		return list;
	}
	public void setBdd(BaseDictDao bdd) {
		this.bdd = bdd;
	}
 
	
}
