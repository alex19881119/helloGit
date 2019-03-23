package com.itheima.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itheima.dao.CustomerDao;
import com.itheima.domain.Customer;
@SuppressWarnings("all")
public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao{

	public List<Object[]> getIndustryCount(String source) {
		
		List<Object[]> list = getHibernateTemplate().execute(new HibernateCallback<List>() {
			
			
			
			@Override
			public List doInHibernate(Session session) throws HibernateException {
				String sql = null;
				if(source==null) {
					sql ="SELECT bd.dict_item_name,COUNT(*) total FROM\r\n" + 
								"cst_customer c,base_dict bd\r\n" + 
								"WHERE bd.dict_id=c.cust_industry GROUP BY c.cust_industry";
					}else {
					sql ="SELECT bd.dict_item_name,COUNT(*) total FROM\r\n" + 
								"cst_customer c,base_dict bd\r\n" + 
								"WHERE bd.dict_id=c.cust_source GROUP BY c.cust_source";
					}
				SQLQuery query = session.createSQLQuery(sql);
				/*if(source!=null) {
					query.setParameter(0, "c.cust_source");
					//query.setParameter(1, "c.cust_source");
				}
				else {
					query.setParameter(0, "c.cust_industry");
					//query.setParameter(1, "c.cust_industry");
				}*/
				//query.setParameter(0, "c.cust_industry");
				return query.list();
			}
		});
		
		return list;
	}
	
	

}
