package com.goopai.carmaxcompute.db;

public class PageBean {

	private static final int DEFAULT_PAGE_SIZE = 22;
	private int pageSize = DEFAULT_PAGE_SIZE; // 默认每页显示数据条数
	private int start = 0; // 当前页第一条数据在数据库中的位置，从0开始
	private int totalPage = 0; // 总页数
	private int page = 1; // 当前页
	private int totalCount; // 总记录数

	private static PageBean instance = null;

	private PageBean() {

	}

	public PageBean(int page) {
		this.page = page;
	}

	public static PageBean getInstance() {
		if (instance == null) {
			instance = new PageBean();
		}
		return instance;
	}

	public void setPage(int page) {
		if (page > 0) {
			this.start = (page - 1) * pageSize;
			this.page = page;
		}
	}

	public int getPage() {
		return page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getStart() {
		return start;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		this.totalPage = (int) Math.ceil((totalCount + pageSize - 1) / pageSize);
		this.start = (page - 1) * pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getLastPage() {
		if (hasLastPage()) {
			return page - 1;
		}
		return page;
	}

	public int getNextPage() {
		if (hasNextPage()) {
			return page + 1;
		}
		return page;
	}

	/**
	 * 该页是否有下一页.
	 */
	public boolean hasNextPage() {
		return page < totalPage;
	}

	/**
	 * 该页是否有上一页.
	 */
	public boolean hasLastPage() {
		return page > 1;
	}
}
