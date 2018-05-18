package com.huan.tool;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

@SuppressWarnings("serial")
public class UserLoginInterceptor implements Interceptor{

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
		Object userId =  ActionContext.getContext().getSession().get("userId");
		if(null == userId ){
			/*ActionSupport actionSupport = (ActionSupport)actionInvocation.getAction();
			actionSupport.addActionError("用户登录过期，请重新登录");  */
			System.out.println("---------------------------用户登录过期-------------------------------");
            return "relogin";  
		}else{
			System.out.println("---------------------------用户登录未过期-------------------------------");
			ActionContext.getContext().getSession().remove("error");
			return actionInvocation.invoke(); 
		}
	}

}
