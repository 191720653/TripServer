package com.zehao.service.impl;

import java.io.Serializable;
import java.util.List;

import com.zehao.dao.IBaseDao;
import com.zehao.service.IBaseService;
import com.zehao.util.Page;

public class BaseServiceImpl<T> implements IBaseService<T> {

	/**
	 * ×¢ÈëIBaseDao
	 */
	private IBaseDao<T> iBaseDao;

	public IBaseDao<T> getIBaseDao() {
		return iBaseDao;
	}

	public void setIBaseDao(IBaseDao<T> iBaseDao) {
		this.iBaseDao = iBaseDao;
	}

	@Override
	public void insert(T entity) {
		// TODO Auto-generated method stub
		this.iBaseDao.insert(entity);
	}

	@Override
	public Serializable save(T entity) {
		// TODO Auto-generated method stub
		return this.iBaseDao.save(entity);
	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		this.iBaseDao.update(entity);
	}

	@Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		this.iBaseDao.delete(id);
	}

	@Override
	public T findById(Serializable id) {
		// TODO Auto-generated method stub
		return this.iBaseDao.findById(id);
	}

	@Override
	public List<T> findByHQL(String hql, List<Object> params) {
		// TODO Auto-generated method stub
		return this.iBaseDao.findByHQL(hql, params);
	}

	@Override
	public List<T> findBySQL(String sql, List<Object> params) {
		// TODO Auto-generated method stub
		return this.iBaseDao.findBySQL(sql, params);
	}

	@Override
	public List<T> getAll() {
		// TODO Auto-generated method stub
		return this.iBaseDao.getAll();
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return this.iBaseDao.getSize();
	}

	@Override
	public Page<T> find(int currentPage, int pageSize, String sql,
			List<Object> values) {
		return iBaseDao.find(currentPage, pageSize, sql, values);
	}

	@Override
	public List<T> findByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return this.iBaseDao.findByProperty(propertyName, value);
	}

	@Override
	public T findUniqueByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return this.iBaseDao.findUniqueByProperty(propertyName, value);
	}

	@Override
	public Page<T> findPageByHQL(int currentPage, int pageSize, String hql,
			List<Object> values) {
		// TODO Auto-generated method stub
		return this.iBaseDao.findPageByHQL(currentPage, pageSize, hql, values);
	}

	@Override
	public T findUniqueByPropertys(String hql, List<Object> values) {
		// TODO Auto-generated method stub
		return this.iBaseDao.findUniqueByPropertys(hql, values);
	}

}
