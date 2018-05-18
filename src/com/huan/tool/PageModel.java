package com.huan.tool;

public class PageModel {
	public PageModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	private PageBean page= new PageBean(0, 5);
	private Object object;
	public PageModel(PageBean page, Object object) {
		super();
		this.page = page;
		this.object = object;
	}
	public PageBean getPage() {
		return page;
	}
	public void setPage(PageBean page) {
		this.page = page;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
}
