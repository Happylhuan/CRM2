package com.huan.business.action;

import java.util.List;

import com.huan.business.po.TsClient;
import com.huan.business.service.IClientService;
import com.huan.tool.PageBean;
import com.huan.tool.PageModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ClientAction extends ActionSupport implements ModelDriven<TsClient>{
	private TsClient client = new TsClient();
	private IClientService clientService;
	private List<TsClient> clients;
	private PageModel pageModel;
	private PageBean page = new PageBean(1, 20);
	
	
	@SuppressWarnings("unchecked")
	public String listClient() {
		pageModel = this.clientService.getClientList(client, page);
		clients = (List<TsClient>) pageModel.getObject();
		if (clients != null) {
			return "list";
		} else {
			this.addActionError("查询客户失败");
			return INPUT;
		}
	}
	
	public String addClient() {
		
		if (this.clientService.addClient(client)) {
			return "success";
		} else {
			this.addActionError("添加客户失败");
			return INPUT;
		}
	}
	public String getupClient() {
		TsClient lclient = this.clientService.getClientById(client.getClientId().intValue());
		if (lclient!= null) {
			client = lclient;
			return "update";
		} else {
			this.addActionError("获取更新用户失败");
			return INPUT;
		}
}
	public String updateClient() {
			if (this.clientService.updateClient(client)) {
				return "success";
			} else {
				this.addActionError("更新客户失败");
				return INPUT;
			}
	}
	public String delClient() {
			
		if (this.clientService.delClient(client)) {
			return "success";
		} else {
			this.addActionError("删除客户失败");
			return INPUT;
		}
	}
	
	public String changeClient() {
		
		if (this.clientService.changeClient(client)) {
			return "success";
		} else {
			this.addActionError("更改客户状态失败");
			return INPUT;
		}
	}
	public TsClient getClient() {
		return client;
	}

	public void setClient(TsClient client) {
		this.client = client;
	}

	public IClientService getClientService() {
		return clientService;
	}

	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}

	public List<TsClient> getClients() {
		return clients;
	}

	public void setClients(List<TsClient> clients) {
		this.clients = clients;
	}

	public PageModel getPageModel() {
		return pageModel;
	}

	public void setPageModel(PageModel pageModel) {
		this.pageModel = pageModel;
	}

	public PageBean getPage() {
		return page;
	}

	public void setPage(PageBean page) {
		this.page = page;
	}

	@Override
	public TsClient getModel() {
		// TODO Auto-generated method stub
		return client;
	}
}
