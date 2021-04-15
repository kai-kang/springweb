package com.kangk.springweb.task.uitl;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
@Getter
public final class PageResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -890029358604704551L;

	/** 总记录数 **/
	private int totalCount;

	/** 每页记录数 **/
	private int pageSize;

	/** 总页数 **/
	private int totalPage;

	/** 当前页数 **/
	private int currentPage;

	/** 分页数据列表 **/
	private List<?> list;

	/**
	 * 分页
	 * 
	 * @param list
	 *            分页数据列表
	 * 
	 * @param totalCount
	 *            总记录数
	 * 
	 * @param pageSize
	 *            每页记录数
	 * 
	 * @param currPage
	 *            当前页数
	 */
	public PageResult(List<?> list, int totalCount, int pageSize, int currentPage) {
		this.list = list;
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.totalPage = (int) Math.ceil((double) totalCount / pageSize);
	}
}
