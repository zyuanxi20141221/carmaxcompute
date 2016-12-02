package com.goopai.carmaxcompute.db;

public class PageBean {

	private static final int DEFAULT_PAGE_SIZE = 22;
	private int pageSize = DEFAULT_PAGE_SIZE; // Ĭ��ÿҳ��ʾ��������
	private int start = 0; // ��ǰҳ��һ�����������ݿ��е�λ�ã���0��ʼ
	private int totalPage = 0; // ��ҳ��
	private int page = 1; // ��ǰҳ
	private int totalCount; // �ܼ�¼��

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
	 * ��ҳ�Ƿ�����һҳ.
	 */
	public boolean hasNextPage() {
		return page < totalPage;
	}

	/**
	 * ��ҳ�Ƿ�����һҳ.
	 */
	public boolean hasLastPage() {
		return page > 1;
	}
}
