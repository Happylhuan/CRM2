package com.huan.business.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huan.business.dao.BaseDao;
import com.huan.business.dao.ILogsDao;
import com.huan.business.dao.LogsDao;
import com.huan.business.po.LljLogs;
import com.huan.business.po.TsUser;
import com.huan.tool.PageBean;
import com.huan.tool.PageModel;
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)  
public class LogsService implements ILogsService{
	private ILogsDao logDao;
	private IUserService userService;
	
	@Override
	public PageModel getLogs(BigDecimal userId,String logStateStr,PageBean page) {
		// TODO Auto-generated method stub
		TsUser user2 = userService.getUserById(userId.intValue());
		String sql = "select u.user_id,u.user_name,l.manage_id,l.log_info,l.log_addtime,l.log_title,l.log_id from llj_logs l,ts_user u where l.user_id = u.user_id and l.manage_id = u.manage_id and power <="+user2.getPower()+"";
		if("all".equals(logStateStr)){
			sql += " and 1 = 1";
		}
		else if("sh".equals(logStateStr)){
			sql += " and log_state =1";
		}else if ("gz".equals(logStateStr)){
			sql += " and log_state =0";
		} 
		PageModel pageModel = new PageModel();
		int totalNum = BaseDao.getTotalNum(sql);
		int totalPage = BaseDao.getTotalPage(totalNum,pageModel.getPage().getPageSize());
		List<LljLogs> list = logDao.getLogs(sql, page.getPageNo(), page.getPageSize());
		page.setAllRows(totalNum);
		page.setTotalPage(totalPage);
		pageModel.setObject(list);
		pageModel.setPage(page);
		return pageModel;
	}
	
	@Override
	public PageModel ManageGetLogs(BigDecimal manageId,String logStateStr, PageBean page) {
		// TODO Auto-generated method stub
		String sql = "select u.user_id,u.user_name,l.manage_id,l.log_info,l.log_addtime,l.log_title,l.log_id from llj_logs l,ts_user u where l.user_id = u.user_id and l.manage_id = "+manageId+" and power <=9";
		if("all".equals(logStateStr)){
			sql += " and 1 = 1";
		}
		else if("sh".equals(logStateStr)){
			sql += " and log_state =1";
		}else if ("gz".equals(logStateStr)){
			sql += " and log_state =0";
		} 
		PageModel pageModel = new PageModel();
		int totalNum = BaseDao.getTotalNum(sql);
		int totalPage = BaseDao.getTotalPage(totalNum,pageModel.getPage().getPageSize());
		List<LljLogs> list = logDao.getLogs(sql, page.getPageNo(), page.getPageSize());
		page.setAllRows(totalNum);
		page.setTotalPage(totalPage);
		pageModel.setObject(list);
		pageModel.setPage(page);
		return pageModel;
	}
	
	@Override
	public boolean addLog(LljLogs log) {
		// TODO Auto-generated method stub
		TsUser user = userService.getUserById(log.getUserId().intValue());
		log.setUserId(user.getUserId());
		log.setManageId(user.getManageId());
		
		if(logDao.addLog(log)){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateLog(LljLogs log) {
		// TODO Auto-generated method stub
		return logDao.updateLog(log);
	}

	@Override
	public boolean delectLog(LljLogs log) {
		// TODO Auto-generated method stub
		return logDao.delectLog(log);
	}

	@Override
	public LljLogs getLogById(int logId) {
		// TODO Auto-generated method stub
		return logDao.getLogById(logId);
	}


	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public ILogsDao getLogDao() {
		return logDao;
	}

	public void setLogDao(ILogsDao logDao) {
		this.logDao = logDao;
	}

	@Override
	public Integer getLogsNumByUserId(BigDecimal userId) {
		// TODO Auto-generated method stub
		return logDao.getLogsNumByUserId(userId);
	}

	@Override
	public Integer getLogsNumByManageId(BigDecimal manageId) {
		// TODO Auto-generated method stub
		return logDao.getLogsNumByManageId(manageId);
	}

	


}
