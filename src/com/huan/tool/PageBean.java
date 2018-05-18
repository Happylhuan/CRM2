package com.huan.tool;

public class PageBean {
	
	private int pageNo ;//当前页
	private int pageSize ;
	private int allRows ; //总记录数
    private int totalPage ; //总页数
	public int getAllRows() {
		return allRows;
	}

	public PageBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setAllRows(int allRows) {
		this.allRows = allRows;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public PageBean(int pageNo, int pageSize) {
		super();
		this.pageNo = pageNo;
		this.pageSize = pageSize;
	}
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	  /**
     * 得到总页数
     * @param pageSize 每页记录数
     * @param allRows  总记录数
     * @return 总页数
     */
    public int getTotalPages(int pageSize, int allRows)
    {
        int totalPage = (allRows % pageSize == 0)? (allRows / pageSize): (allRows / pageSize) + 1;
        
        return totalPage;
    }
    /**
     * 得到当前开始记录号
     * @param pageSize 每页记录数
     * @param currentPage 当前页
     * @return
     */
    public int getCurrentPageOffset(int pageSize, int currentPage)
    {
        int offset = pageSize * (currentPage - 1);
        
        return offset;
    }
    /**
     * 得到当前页， 如果为0 则开始第一页，否则为当前页
     * @param page
     * @return
     */
    public int getCurPage(int page)
    {
        int currentPage = (page == 0)? 1: page;
        
        return currentPage;
    }
}
