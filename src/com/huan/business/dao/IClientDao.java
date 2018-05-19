package com.huan.business.dao;

import java.math.BigDecimal;
import java.util.List;

import com.huan.business.po.TsClient;
import com.huan.business.po.TsOrder;
import com.huan.tool.PageBean;
import com.huan.tool.PageModel;

public interface IClientDao {
	public PageModel getClientList(TsClient client,PageBean page,String hql);

	public boolean addClient(TsClient client);

	public boolean delClient(TsClient client);

	public boolean updateClient(TsClient client);

	public Integer getUserIdByName(String userName);
	
	public TsClient getClientById(Integer clientId);
	
	public List<String> getClientsByUserId(BigDecimal userId);
	
	public Integer getClientNumByUserId(BigDecimal userId);
}
