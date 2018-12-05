package com.itheima.dao;

import java.util.List;

import com.itheima.domain.BaseDict;

public interface BaseDictDao extends BaseDao<BaseDict> {
	//根据typecode获得数据字典list
	List<BaseDict> findListByTypeCode(String dict_type_code);
	
}
