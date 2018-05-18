package com.huan.business.service;

import java.math.BigDecimal;
import java.util.List;

import com.huan.business.dao.IMainDao;
import com.huan.business.po.TsMainview;
import com.huan.tool.TotalNum;

public class MainService implements IMainService {

	private IMainDao mainDao;
	
	public IMainDao getMainDao() {
		return mainDao;
	}

	public void setMainDao(IMainDao mainDao) {
		this.mainDao = mainDao;
	}

	@Override
	public List<TsMainview> getTopUserByOrderNum(BigDecimal manageId) {
		// TODO Auto-generated method stub
		return mainDao.getTopUserByOrderNum(manageId);
	}

	@Override
	public TotalNum getTotalNum(BigDecimal manageId) {
		// TODO Auto-generated method stub
		Integer clientNum = mainDao.getTotalClientNum(manageId);
		Integer orderNum = mainDao.getTotalOrderNum(manageId);
		Double priceNum = mainDao.getTotalPriceNum(manageId);
		TotalNum totalNum = new TotalNum(orderNum, clientNum,priceNum);
		return totalNum;
		
	}

}
