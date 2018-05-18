package com.huan.business.service;

import java.math.BigDecimal;
import java.util.List;

import com.huan.business.po.TsClient;
import com.huan.business.po.TsOrder;
import com.huan.tool.PageBean;
import com.huan.tool.PageModel;

public interface IClientService {
	public PageModel getClientList(TsClient client,PageBean page);

	public boolean addClient(TsClient client);

	public boolean delClient(TsClient client);

	public boolean updateClient(TsClient client);
	
	public boolean changeClient(TsClient client);
	
	public TsClient getClientById(Integer clientId);
	
	public List<String> getClientsByUserId(BigDecimal userId);
}
