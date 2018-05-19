package com.huan.business.action;

import java.util.List;

import com.huan.business.po.LljLogs;
import com.huan.business.po.TsUser;
import com.huan.business.service.ILogsService;
import com.huan.tool.PageBean;
import com.huan.tool.PageModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LogAction extends ActionSupport implements ModelDriven<LljLogs>{

	private LljLogs log = new LljLogs(); 
	private List<LljLogs> logs;
	private ILogsService logsService;
	private PageModel pageModel;
	private PageBean page = new PageBean(0, 200);
	@SuppressWarnings("unchecked")
	public String listLog() {
		pageModel = logsService.getLogs(log.getUserId(),log.getLogStateStr(), page);
		logs = (List<LljLogs>) pageModel.getObject();
		return "list";
		
	}
	@SuppressWarnings("unchecked")
	public String managelistLog() {
		pageModel = logsService.ManageGetLogs(log.getManageId(),log.getLogStateStr(), page);
		logs = (List<LljLogs>) pageModel.getObject();
		return "ManageList";
		
	}
	public String addLog() {
		if(logsService.addLog(log)){
			return "success";
		}else{
			this.addActionError("添加日志失败");
			return INPUT;
		}

		
	}
	public String delLog() {
		if(logsService.delectLog(log)){
			return "success";
		}else{
			this.addActionError("添加日志失败");
			return INPUT;
		}
	}
	public String updBefLog() {
		
		log = logsService.getLogById(log.getLogId().intValue());
		
		return "update";
		
	}
	public String updLog() {
		boolean flag = logsService.updateLog(log);
		if(flag){
			return SUCCESS;
		}else{
			this.addActionError("添加日志失败");
			return INPUT;
		}
	}

	@Override
	public LljLogs getModel() {
		// TODO Auto-generated method stub
		return log;
	}
	public LljLogs getLog() {
		return log;
	}
	public void setLog(LljLogs log) {
		this.log = log;
	}
	public List<LljLogs> getLogs() {
		return logs;
	}
	public void setLogs(List<LljLogs> logs) {
		this.logs = logs;
	}
	public ILogsService getLogsService() {
		return logsService;
	}
	public void setLogsService(ILogsService logsService) {
		this.logsService = logsService;
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
