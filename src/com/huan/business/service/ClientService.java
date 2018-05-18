package com.huan.business.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huan.business.dao.IClientDao;
import com.huan.business.po.TsClient;
import com.huan.tool.PageBean;
import com.huan.tool.PageModel;
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false) 
public class ClientService implements IClientService {
	private IClientDao clientDao;
	
	public IClientDao getClientDao() {
		return clientDao;
	}

	public void setClientDao(IClientDao clientDao) {
		this.clientDao = clientDao;
	}

	@Override
	public PageModel getClientList(TsClient client, PageBean page) {
		String hql = " from TsClient client where 1=1 ";
		
		if(null!=client.getUserId()&&null==client.getState()){
			hql += " and client.userId ='"+client.getUserId()+"'";
		}
	
		if("del".equals(client.getState())){
			hql += " and client.userId ='"+client.getUserId()+"'";
		}
		if("add".equals(client.getState())){
			hql += " and client.userId ='"+client.getUserId()+"'";
			client.setClientIdcard("");
			client.setClientName("");
			client.setClientPhone("");
			client.setUserName("");
		}
		if("upd".equals(client.getState())){
			
			hql += " and client.userId ='"+client.getUserId()+"'";
			client.setClientIdcard("");
			client.setClientName("");
			client.setClientPhone("");
			client.setUserName("");
		}
		if("queuse".equals(client.getState())){
			if(client.getClientIsuser()){
				hql += " and client.clientIsuser ='1'";
			}else {
				hql += " and client.clientIsuser ='0'";
			}
			
		}
		PageModel pageModel = ( PageModel) this.clientDao.getClientList(client, page,hql);
		return pageModel;
	}

	@Override
	public boolean addClient(TsClient client) {
		// TODO Auto-generated method stub
		client.setClientIdcard(client.getClientIdcard().trim());
		client.setClientPhone(client.getClientPhone().trim());
		client.setClientName(client.getClientName().trim());
		if(clientDao.addClient(client)){
			return true;
		}
		return false;
	}

	@Override
	public boolean delClient(TsClient client) {
		if(clientDao.delClient(client)){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateClient(TsClient client) {
		// TODO Auto-generated method stub
		return clientDao.updateClient(client);
	}


	@Override
	public boolean changeClient(TsClient client) {
		// TODO Auto-generated method stub
		TsClient client2 = getClientById(client.getClientId().intValue());
		
		if(client2.getClientIsuser()){
			client2.setClientIsuser(false);
		}else{
			client2.setClientIsuser(true);
		}
		
		return clientDao.updateClient(client2);
	}

	@Override
	public TsClient getClientById(Integer clientId) {
		// TODO Auto-generated method stub
		return clientDao.getClientById(clientId);
	}

	@Override
	public List<String> getClientsByUserId(BigDecimal userId) {
		// TODO Auto-generated method stub
		return clientDao.getClientsByUserId(userId);
	}

}
