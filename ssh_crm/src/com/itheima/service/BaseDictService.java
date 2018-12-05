package com.itheima.service;

import java.util.List;

import com.itheima.domain.BaseDict;

public interface BaseDictService {
	//根据typecode获得数据字典list
	List<BaseDict> findListByTypeCode(String dict_type_code);
	
}
