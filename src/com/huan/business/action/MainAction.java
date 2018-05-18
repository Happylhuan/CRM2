package com.huan.business.action;

import java.text.DecimalFormat;
import java.util.List;

import com.huan.business.po.TsMainview;
import com.huan.business.po.TsUser;
import com.huan.business.service.IMainService;
import com.huan.business.service.IUserService;
import com.huan.tool.TotalNum;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MainAction extends ActionSupport implements ModelDriven<TsMainview>{
	 private TsMainview mainView = new TsMainview();
	 private List<TsMainview> mainViews;
	 private IMainService mainService;
	 private IUserService userService;
	 private TsUser user;
	 private TotalNum totalNum;
	 
	

	public String listMain(){
		mainViews = mainService.getTopUserByOrderNum(mainView.getManageId());
		totalNum = mainService.getTotalNum(mainView.getManageId());
		return "view";
	}
	
	public String getinfoMain(){
		user = userService.getUserById(user.getUserId().intValue());
		user.setManageName(userService.getManageById(user.getManageId().intValue()).getManageName());
		return "info";
	}
	//格式化数字显示
	  public String formatDouble(double s){
	      DecimalFormat fmt = new DecimalFormat("#0.00");
	      return fmt.format(s);
	  }
	  public String formatOrder(double s){
	      DecimalFormat fmt = new DecimalFormat("#0");
	      return fmt.format(s);
	  }
	@Override
	public TsMainview getModel() {
		// TODO Auto-generated method stub
		return mainView;
	}
	 
		public TotalNum getTotalNum() {
			return totalNum;
		}

		public void setTotalNum(TotalNum totalNum) {
			this.totalNum = totalNum;
		}

		public TsUser getUser() {
			return user;
		}

		public void setUser(TsUser user) {
			this.user = user;
		}

		public IUserService getUserService() {
			return userService;
		}

		public void setUserService(IUserService userService) {
			this.userService = userService;
		}

		public IMainService getMainService() {
			return mainService;
		}

		public void setMainService(IMainService mainService) {
			this.mainService = mainService;
		}
		

		public TsMainview getMainView() {
			return mainView;
		}

		public void setMainView(TsMainview mainView) {
			this.mainView = mainView;
		}

		public List<TsMainview> getMainViews() {
			return mainViews;
		}

		public void setMainViews(List<TsMainview> mainViews) {
			this.mainViews = mainViews;
		}
	
}
