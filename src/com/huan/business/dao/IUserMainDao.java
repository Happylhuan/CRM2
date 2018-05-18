package com.huan.business.dao;

import java.util.List;

import com.huan.business.po.TsClient;
import com.huan.business.po.TsUsermain;

public interface IUserMainDao {

	public List<TsUsermain> getTopClients(Integer userid);
	public Integer getUserIdByName(String userName);
	public TsClient getClientById(Integer userid);
	public Integer getTotalOrderNum(Integer userId);
	public Integer getTotalClientNum(Integer userId);
	public Double getTotalPriceNum(Integer userId);
}
