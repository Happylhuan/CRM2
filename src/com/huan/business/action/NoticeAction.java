package com.huan.business.action;

import com.huan.business.po.TsNotice;
import com.huan.business.service.INoticeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class NoticeAction extends ActionSupport implements ModelDriven<TsNotice>{
	
	private TsNotice notice = new TsNotice();
	private INoticeService noticeService ;
	
	public String addNotice(){
		if(noticeService.addNotices(notice)){
			ActionContext.getContext().getSession().put("isNoticeAdd", "noticeAdd");
			return "addNoticSuccess";
		}
		return "addNoticSuccess";
	}
	public String listNotice() {
		return null;
	}
	public String delNotice() {
		if(noticeService.delectNotices(notice)){
			return "delNoticSuccess";
		}
		return "delNoticSuccess";
	}
	
	
	@Override
	public TsNotice getModel() {
		// TODO Auto-generated method stub
		return notice;
	}
	public TsNotice getNotice() {
		return notice;
	}
	public void setNotice(TsNotice notice) {
		this.notice = notice;
	}
	public INoticeService getNoticeService() {
		return noticeService;
	}
	public void setNoticeService(INoticeService noticeService) {
		this.noticeService = noticeService;
	}

}
