package com.huan.tool;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.huan.business.po.TsNotice;
import com.huan.business.service.ILoginService;
import com.huan.business.service.INoticeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.Interceptor;

@SuppressWarnings("serial")
public class ManageLoginInterceptor implements Interceptor{
	@Autowired
	private ILoginService loginService;
	private INoticeService noticeService;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		// TODO Auto-generated method stub
		Object manageId =  ActionContext.getContext().getSession().get("manageId");
		if(null == manageId){
			System.out.println("---------------------------管理员登录过期-------------------------------");
            return "relogin";  
		}else{
			
			System.out.println("---------------------------管理员登录未过期-------------------------------");
			 return actionInvocation.invoke(); 
		}
	}

	public ILoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}

	public INoticeService getNoticeService() {
		return noticeService;
	}

	public void setNoticeService(INoticeService noticeService) {
		this.noticeService = noticeService;
	}

}
