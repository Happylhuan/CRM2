package com.huan.business.service;

import java.util.List;

import com.huan.business.dao.IUserMainDao;
import com.huan.business.po.TsClient;
import com.huan.business.po.TsUsermain;
import com.huan.tool.TotalNum;

public class UserMainService implements IUserMainService{

	private IUserMainDao userMainDao;
	
	public IUserMainDao getUserMainDao() {
		return userMainDao;
	}

	public void setUserMainDao(IUserMainDao userMainDao) {
		this.userMainDao = userMainDao;
	}

	@Override
	public List<TsUsermain> getTopClients(Integer userId) {
		// TODO Auto-generated method stub
		return userMainDao.getTopClients(userId);
	}

	@Override
	public TsClient getClientById(Integer clientId) {
		// TODO Auto-generated method stub
		return userMainDao.getClientById(clientId);
	}

	@Override
	public TotalNum getTotalNum(Integer userId) {
		// TODO Auto-generated method stub
		Integer orderNum = userMainDao.getTotalOrderNum(userId);
		Integer clientNum = userMainDao.getTotalClientNum(userId);
		Double priceNum = userMainDao.getTotalPriceNum(userId);
		TotalNum totalNum = new TotalNum(orderNum, clientNum,priceNum);
		return totalNum;
	}

}
