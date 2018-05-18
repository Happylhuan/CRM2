package com.huan.business.dao;

import java.math.BigDecimal;
import java.util.List;

import com.huan.business.po.LljLogs;
import com.huan.business.po.TsUser;

public interface ILogsDao {
	public List<LljLogs> getLogs(String sql,int pageNo,int numNo);
	public boolean  addLog(LljLogs log);
	public boolean  updateLog(LljLogs log);
	public boolean  delectLog(LljLogs log);
	public LljLogs  getLogById(int logId);
	public Integer getLogsNumByUserId(BigDecimal userId);
	public Integer getLogsNumByManageId(BigDecimal manageId);
	
}
