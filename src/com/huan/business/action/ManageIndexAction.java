package com.huan.business.action;

import com.huan.tool.ManageIndex;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ManageIndexAction extends ActionSupport implements ModelDriven<ManageIndex>{
	
	private ManageIndex manageIndex = new ManageIndex();
	
	public String enterIndex(){
		return null;
	}
	public String flushIndex(){
		return null;
	}
	@Override
	public ManageIndex getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	public ManageIndex getManageIndex() {
		return manageIndex;
	}
	public void setManageIndex(ManageIndex manageIndex) {
		this.manageIndex = manageIndex;
	}
	
}
