package com.itheima.dao.impl;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
//hibernatesupport为dao注入sessionFactory

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
	
	@Override
	public User getByUserCode(String usercode) {
		/*//hql
		User user = getHibernateTemplate().execute(new HibernateCallback<User>() {

			@Override
			public User doInHibernate(Session session) throws HibernateException {
				String hql ="from User where user_code = ?";
				 Query query = session.createQuery(hql);
				 query.setParameter(0, usercode);
				 User user = (User) query.uniqueResult();
				return user;
			}
		});
		
		return user;*/
		
		
		DetachedCriteria dc =DetachedCriteria.forClass(User.class);
		dc.add(Restrictions.eq("user_code", usercode));
		List<User> list = (List<User>) getHibernateTemplate().findByCriteria(dc);
		if(list!=null && list.size()>0){
			return list.get(0);
		}else {
			return null;
		}
	}

	

	
	
}
