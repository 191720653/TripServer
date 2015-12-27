package com.zehao.util;

import java.util.List;

/**
 * 分页Bean
 * 
 * @author zehao
 * 
 * @param <T>
 */
public class Page<T> {
	/**
	 * 结果集
	 */
	private List<T> resultList;
	/**
	 * 总记录数
	 */
	private int recordSUM;
	/**
	 * 总页数
	 */
	private int pageSUM;
	/**
	 * 当前页
	 */
	private int currentPage;
	/**
	 * 页记录数
	 */
	private int pageSize;

	/**
	 * 初始化
	 */
	public Page(List<T> resultList, int recordSUM, int pageSize, int currentPage) {
		this.resultList = resultList;
		this.recordSUM = recordSUM;
		this.pageSize = pageSize;
		this.countCurrentPage(currentPage);
		this.countTotalPage(pageSize, recordSUM);
	}

	/**
	 * 总页数
	 */
	public void countTotalPage(int pageSize, int recordSUM) {

		pageSUM = recordSUM % pageSize == 0 ? recordSUM / pageSize : recordSUM
				/ pageSize + 1;

	}

	/**
	 * 静态方法，当前页开始记录号，数据库从此处开始取数据
	 */
	public static int countOffset(int pageSize, int currentPage) {

		return pageSize * (currentPage - 1);

	}

	/**
	 * 当前页
	 */
	public void countCurrentPage(int page) {

		currentPage = (page == 0 ? 1 : page);

	}

	/**
	 * 判断当前页的状态,是否是第一页
	 */
	public boolean isFirstPage() {
		return currentPage != 1;
	}

	/**
	 * 是否是最后一页
	 */
	public boolean isLastPage() {
		return currentPage != pageSUM;
	}

	/**
	 * 是否有上一页
	 */
	public boolean isHasPreviousPage() {
		return currentPage != 1;
	}

	/**
	 * 是否有下一页
	 */
	public boolean isHasNextPage() {
		return currentPage != pageSUM;
	}

	/**
	 * 上一页
	 */
	public int previousPage() {
		return currentPage - 1;
	}

	/**
	 * 下一页
	 */
	public int nextPage() {
		return currentPage + 1;
	}

	/**
	 * Get/Set方法
	 */
	public List<T> getResultList() {
		return resultList;
	}

	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}

	public int getRecordSUM() {
		return recordSUM;
	}

	public void setRecordSUM(int recordSUM) {
		this.recordSUM = recordSUM;
	}

	public int getPageSUM() {
		return pageSUM>0?pageSUM:1;
	}

	public void setPageSUM(int pageSUM) {
		this.pageSUM = pageSUM;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "Page [resultList=" + resultList + ", recordSUM=" + recordSUM
				+ ", pageSUM=" + pageSUM + ", currentPage=" + currentPage
				+ ", pageSize=" + pageSize + "]";
	}

}
