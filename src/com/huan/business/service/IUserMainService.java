package com.huan.business.service;

import java.util.List;

import com.huan.business.po.TsClient;
import com.huan.business.po.TsUsermain;
import com.huan.tool.TotalNum;

public interface IUserMainService {

	public List<TsUsermain> getTopClients(Integer userId);

	public TsClient getClientById(Integer clientid);
	
	public TotalNum getTotalNum(Integer userId);
	
}
