package com.zehao.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.zehao.dao.IBaseDao;
import com.zehao.util.Page;

public class BaseDaoImpl<T> implements IBaseDao<T> {

	private Class<T> class_t;

	/**
	 * 构造方法，获取具体泛型类
	 */
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		ParameterizedType parameterizedType = (ParameterizedType) this
				.getClass().getGenericSuperclass();
		class_t = (Class<T>) parameterizedType.getActualTypeArguments()[0];
		System.out.println("--------Dao的泛型爲 " + class_t.getName() + "--------");
	}

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		System.out.println("---------- 注入session ----------");
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 获取当前的session
	 * 
	 * @return session
	 */
	public Session getSession() {
		System.out.println(sessionFactory==null);
		try {
			return this.sessionFactory.getCurrentSession();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
//			e.printStackTrace();
		}
		return this.sessionFactory.openSession();
	}

	public Criteria createCriteria(Criterion... criterions) {
		Criteria criteria = this.getSession().createCriteria(class_t);
		for (Criterion c : criterions) {
			criteria.add(c);
		}
		return criteria;
	}

	@Override
	public void insert(T entity) {
		// TODO Auto-generated method stub
		this.getSession().save(entity);
	}

	@Override
	public Serializable save(T entity) {
		// TODO Auto-generated method stub
		return this.getSession().save(entity);
	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		this.getSession().update(entity);
	}

	@Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		this.getSession().delete(this.findById(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(Serializable id) {
		// TODO Auto-generated method stub
		return (T) this.getSession().get(this.class_t, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByHQL(String hql, List<Object> params) {
		// TODO Auto-generated method stub
		Query query = this.getSession().createQuery(hql);
		for (int i = 0; params != null && i < params.size(); i++) {
			query.setParameter(i, params.get(i));
		}
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findBySQL(String sql, List<Object> params) {
		// TODO Auto-generated method stub
		Query query = this.getSession().createSQLQuery(sql);
		for (int i = 0; params != null && i < params.size(); i++) {
			query.setParameter(i, params.get(i));
		}
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
		// TODO Auto-generated method stub
		return this.getSession().createQuery("From " + class_t.getName())
				.list();
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return this.getAll().size();
	}

	@SuppressWarnings("unchecked")
	public Page<T> find(int currentPage, int pageSize, String sql,
			List<Object> values) {

		Query queryObject = this.getSession().createSQLQuery(sql).addEntity(class_t);
		if (values != null) {
			for (int i = 0; i < values.size(); i++) {
				queryObject.setParameter(i, values.get(i));
			}
		}
		queryObject.setFirstResult(Page.countOffset(pageSize, currentPage));
		queryObject.setMaxResults(pageSize);
		Page<T> page = new Page<T>(queryObject.list(), this.findBySQL(sql, values).size(),
				pageSize, currentPage);
		return page;

	}
	
	@SuppressWarnings("unchecked")
	public Page<T> findPageByHQL(int currentPage, int pageSize, String hql,
			List<Object> values) {

		System.out.println(this.getSession()==null);
		Query queryObject = this.getSession().createQuery(hql);
		if (values != null) {
			for (int i = 0; i < values.size(); i++) {
				queryObject.setParameter(i, values.get(i));
			}
		}
		queryObject.setFirstResult(Page.countOffset(pageSize, currentPage));
		queryObject.setMaxResults(pageSize);
		Page<T> page = new Page<T>(queryObject.list(), this.findByHQL(hql, values).size(),
				pageSize, currentPage);
		return page;

	}

	@SuppressWarnings("unchecked")
	public List<T> findByProperty(String propertyName, Object value) {
		return createCriteria(Restrictions.eq(propertyName, value)).list();
	}

	@SuppressWarnings("unchecked")
	public T findUniqueByProperty(String propertyName, Object value) {
		return (T) createCriteria(Restrictions.eq(propertyName, value))
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public T findUniqueByPropertys(String hql, List<Object> values) {
		// TODO Auto-generated method stub
		
		Query queryObject = this.getSession().createQuery(hql);
		if (values != null) {
			for (int i = 0; i < values.size(); i++) {
				queryObject.setParameter(i, values.get(i));
			}
		}
		return (T) queryObject.uniqueResult();
	}

}
