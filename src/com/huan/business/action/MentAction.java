package com.huan.business.action;

import com.huan.business.po.LljMent;
import com.huan.business.service.IMentService;
import com.huan.tool.PageBean;
import com.huan.tool.PageModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MentAction extends ActionSupport implements ModelDriven<LljMent>{

	private LljMent ment = new LljMent(); 
	private IMentService mentService;
	private PageModel pageModel;
	private PageBean page = new PageBean(1, 5);
	
	/*@SuppressWarnings("unchecked")
	public String listLog() {
		pageModel = mentService.getMents();
		logs = (List<LljLogs>) pageModel.getObject();
		return "list";
		
	}*/
	
	public String addMent() {
		if(mentService.addMent(ment)){
			return "tolist";
		}else{
			this.addActionError("添加日志失败");
			return INPUT;
		}
	}
	public String delMent() {
		if(mentService.delectMent(ment)){
			return "tolist";
		}else{
			this.addActionError("添加日志失败");
			return INPUT;
		}
	}
	@Override
	public LljMent getModel() {
		// TODO Auto-generated method stub
		return ment;
	}

	public LljMent getMent() {
		return ment;
	}

	public void setMent(LljMent ment) {
		this.ment = ment;
	}

	public IMentService getMentService() {
		return mentService;
	}

	public void setMentService(IMentService mentService) {
		this.mentService = mentService;
	}

	public PageModel getPageModel() {
		return pageModel;
	}

	public void setPageModel(PageModel pageModel) {
		this.pageModel = pageModel;
	}

	public PageBean getPage() {
		return page;
	}

	public void setPage(PageBean page) {
		this.page = page;
	}

	
}
