package com.zehao.dao;

import java.io.Serializable;
import java.util.List;

import com.zehao.util.Page;

/**
 * 通用Dao接口
 * 
 * @author zehao
 * 
 * @param <T>
 */
public interface IBaseDao<T> {

	/**
	 * 保存实体
	 * 
	 * @param entity
	 */
	public void insert(T entity);

	/**
	 * 保存实体，并返回实体的主键
	 * 
	 * @param entity
	 * @return id
	 */
	public Serializable save(T entity);

	/**
	 * 更新实体
	 * 
	 * @param entity
	 */
	public void update(T entity);

	/**
	 * 删除实体
	 * 
	 * @param id
	 */
	public void delete(Serializable id);

	/**
	 * 根据主键查找实体
	 * 
	 * @param id
	 * @return T
	 */
	public T findById(Serializable id);

	/**
	 * 根据传入的hql语句查找实体
	 * 
	 * @param hql
	 * @param params
	 * @return List<T>
	 */
	public List<T> findByHQL(String hql, List<Object> params);

	/**
	 * 根据传入的sql语句查找实体
	 * 
	 * @param sql
	 * @param params
	 * @return List<T>
	 */
	public List<T> findBySQL(String sql, List<Object> params);

	/**
	 * 獲取所有記錄
	 * 
	 * @return List<T>
	 */
	public List<T> getAll();

	/**
	 * 獲取總記錄數
	 * 
	 * @return size
	 */
	public int getSize();

	/**
	 * 分页获取数据(sql)
	 * 
	 * @param currentPage
	 * @param pageSize
	 * @param sql
	 * @param values
	 * @return
	 */
	public Page<T> find(int currentPage, int pageSize, String sql,
			List<Object> values);
	
	/**
	 * 分页获取数据(hql)
	 * @param currentPage
	 * @param pageSize
	 * @param hql
	 * @param values
	 * @return
	 */
	public Page<T> findPageByHQL(int currentPage, int pageSize, String hql,
			List<Object> values);

	/**
	 * 根據屬性獲取記錄
	 * 
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public List<T> findByProperty(String propertyName, Object value);

	/**
	 * 根據屬性獲取唯一記錄
	 * 
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public T findUniqueByProperty(String propertyName, Object value);
	
	/**
	 * 根据hql获取唯一记录(hql)
	 * 
	 * @param propertyName
	 * @param values
	 * @return
	 */
	public T findUniqueByPropertys(String hql, List<Object> values);

}
