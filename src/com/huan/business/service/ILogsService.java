package com.huan.business.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.huan.business.po.LljLogs;
import com.huan.tool.PageBean;
import com.huan.tool.PageModel;

public interface ILogsService {
	public PageModel getLogs(BigDecimal userId,String logStateStr,PageBean page);
	public boolean  addLog(LljLogs log);
	public boolean  updateLog(LljLogs log);
	public boolean  delectLog(LljLogs log);
	public LljLogs getLogById(int logId);
	public PageModel ManageGetLogs(BigDecimal manageId,String logStateStr,PageBean page);
	public Integer getLogsNumByUserId(BigDecimal userId);
	public Integer getLogsNumByManageId(BigDecimal manageId);
	
}
