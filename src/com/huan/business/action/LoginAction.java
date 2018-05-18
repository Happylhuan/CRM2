package com.huan.business.action;

import java.math.BigDecimal;
import java.util.List;

import com.huan.business.po.TsManage;
import com.huan.business.po.TsNotice;
import com.huan.business.po.TsUser;
import com.huan.business.service.ILoginService;
import com.huan.business.service.ILogsService;
import com.huan.business.service.INoticeService;
import com.huan.business.service.IUserService;
import com.huan.tool.ManageIndex;
import com.huan.tool.UserIndex;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	private String loginName;
	private TsManage manage;
	private String passWord;
	private boolean checkFlag = false;
	private ManageIndex manageIndex = new ManageIndex();
	private UserIndex userIndex = new UserIndex();
	
	private ILoginService loginService;
	private IUserService userService;
	private INoticeService noticeService;
	private ILogsService logsService;
	
	public String  checkUser() {
		checkFlag = loginService.CheckUser(loginName, passWord);
		if(checkFlag){
			int userId = userService.getUserByName(loginName).getUserId().intValue();
			String userName = userService.getUserByName(loginName).getUserName();
			ActionContext.getContext().getSession().put("userId", userId);
			ActionContext.getContext().getSession().remove("error");
			ActionContext.getContext().getSession().put("userName", userName);
			System.out.println("---------------------------用户登录-------------------------------");
			return "usersuccess";
		}
	    TsUser user = loginService.getUserByName(loginName);
		if(null == user){
			ActionContext.getContext().getSession().put("nameError","用户不存在，请重新输入^_^"); 
		}else{
			ActionContext.getContext().getSession().put("passError","密码错误，请重新输入^_^");
		}
		return "login";
	}
	public String  checkManage() {
		checkFlag = loginService.CheckManage(loginName, passWord);	
		if(checkFlag){
			TsManage tmanage = loginService.getManageByName(loginName);
			ActionContext.getContext().getSession().remove("error");
			ActionContext.getContext().getSession().put("manageName", tmanage.getManageName());
			ActionContext.getContext().getSession().put("manageId", tmanage.getManageId());
			System.out.println("---------------------------管理员登录-------------------------------");
			return "managesuccess";
		}
		TsManage tmanage = loginService.getManageByName(loginName);
		if(null == tmanage){
			ActionContext.getContext().getSession().put("nameError","账号不存在，请重新输入^_^"); 
		}else{
			ActionContext.getContext().getSession().put("passError","密码错误，请重新输入^_^");
		}
		return "login";
	}
	public String RegManage(){
		 TsManage tmanage = loginService.getManageByName(manage.getManageLoginName());
		 if(null != tmanage){
			 ActionContext.getContext().getSession().put("isSuccess", "isExist");
		 }else{
			 if(loginService.saveManage(manage)){
				 System.out.println("---------------------------管理员注册成功-------------------------------");
				 ActionContext.getContext().getSession().put("isSuccess", "true");
			 }else{
				 ActionContext.getContext().getSession().put("isSuccess", "error"); 
			 }
		 }
		return "regmanagesuccess";
	}
	public String  Userdownindex() {
		ActionContext.getContext().getSession().remove("userId");
		return "login";
	}
	public String  Managedownindex() {
		
		ActionContext.getContext().getSession().remove("manageId");
		return "login";
	}
	
	
	public String  manageindex() {
		Object manageId =  ActionContext.getContext().getSession().get("manageId");
		if(null != manageId){
		TsManage tmanage = loginService.getManageById((BigDecimal)manageId);
		int	logNum = logsService.getLogsNumByManageId(tmanage.getManageId());
		List<TsNotice> notices = noticeService.getNoticesByManageId((BigDecimal)tmanage.getManageId());
		manageIndex.setManage(tmanage);
		manageIndex.setLogNum(logNum);
		manageIndex.setNotices(notices);
		}
		return "manageindex";
	}
	public String  userindex() {
		Object userId =  ActionContext.getContext().getSession().get("userId");
		if(null != userId){
		TsUser tuser = userService.getUserById((Integer)userId);
		int	logNum = logsService.getLogsNumByUserId(tuser.getUserId());
		List<TsNotice> notices = noticeService.getNoticesByUserId((BigDecimal)tuser.getUserId());
		userIndex.setUser(tuser);
		userIndex.setLogNum(logNum);
		userIndex.setNotices(notices);
		}
		return "userindex";
	}
	
	public ILoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public boolean isCheckFlag() {
		return checkFlag;
	}
	public void setCheckFlag(boolean checkFlag) {
		this.checkFlag = checkFlag;
	}
	
	public IUserService getUserService() {
		return userService;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	public TsManage getManage() {
		return manage;
	}
	public void setManage(TsManage manage) {
		this.manage = manage;
	}
	public INoticeService getNoticeService() {
		return noticeService;
	}
	public void setNoticeService(INoticeService noticeService) {
		this.noticeService = noticeService;
	}
	public ILogsService getLogsService() {
		return logsService;
	}
	public void setLogsService(ILogsService logsService) {
		this.logsService = logsService;
	}
	public ManageIndex getManageIndex() {
		return manageIndex;
	}
	public void setManageIndex(ManageIndex manageIndex) {
		this.manageIndex = manageIndex;
	}
	public UserIndex getUserIndex() {
		return userIndex;
	}
	public void setUserIndex(UserIndex userIndex) {
		this.userIndex = userIndex;
	}


	
}
