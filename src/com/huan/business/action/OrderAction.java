package com.huan.business.action;

import java.math.BigDecimal;
import java.util.List;

import com.huan.business.po.TsClient;
import com.huan.business.po.TsOrder;
import com.huan.business.service.ClientService;
import com.huan.business.service.IClientService;
import com.huan.business.service.IOrderService;
import com.huan.business.service.IProductService;
import com.huan.business.service.IUserService;
import com.huan.tool.PageBean;
import com.huan.tool.PageModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class OrderAction extends ActionSupport implements ModelDriven<TsOrder>{
	private TsOrder order = new TsOrder();
	private List<TsOrder> orders;
	private PageModel pageModel;
	private PageBean page = new PageBean(1,20);
	private IOrderService orderService;
	private IClientService clientService;
	private IProductService productService;
	private List<String> clientsName;
	private List<String> productsName;
	private IUserService userService ;
	@SuppressWarnings("unchecked")
	public String listOrder() {
		
		pageModel = this.orderService.getOrderList(order, page);		
		orders = (List<TsOrder>) pageModel.getObject();
		if(orders!=null){
			return "list";
		}
		return INPUT;
						
	}
	@SuppressWarnings("unchecked")
	public String managelistOrder() {
		
		pageModel = this.orderService.getOrderList(order, page);		
		orders = (List<TsOrder>) pageModel.getObject();
		if(orders!=null){
			return "managelist";
		}
		return INPUT;
						
	}
	public String getinfoOrder(){
		TsOrder lorder = this.orderService.getOrderById(order.getOrderId().intValue());
		if (lorder!= null) {
			order = lorder;
			return "info";
		} else {
			this.addActionError("获取订单详情失败");
			return INPUT;
		}
	}
	public String getupOrder(){
		TsOrder lorder = this.orderService.getOrderById(order.getOrderId().intValue());
		if (lorder!= null) {
			order = lorder;
			return "update";
		} else {
			this.addActionError("更改订单失败");
			return INPUT;
		}
	}
	public String addbefOrder(){
		List<String> list = clientService.getClientsByUserId(new BigDecimal(order.getUserId()));
		List<String> list2 = productService.getProductsName();
		if (list!= null&&list2!=null) {
			clientsName = list;
			productsName = list2;
			return "addbef";
		} else {
			this.addActionError("获取客户失败");
			return INPUT;
		}
	}
	public String addOrder(){
		String userName = userService.getUserNameById(order.getUserId());
		order.setUserName(userName);
		if(this.orderService.addOrder(order)){
			return "success";
		}
		return INPUT;
	}
	public String delOrder() {
		if (this.orderService.delOrder(order)) {
			return "success";
		} else {
			this.addActionError("删除订单失败");
			return INPUT;
		}
	}
	public String updateOrder() {
		if (this.orderService.updateOrder(order)) {
			return "success";
		} else {
			this.addActionError("更新订单失败");
			return INPUT;
		}
	}
	

	public String sendOrder() {
		if (this.orderService.sendOrder(order)) {
			return "success";
		} else {
			this.addActionError("更新订单失败");
			return INPUT;
		}
	}
	
	public IProductService getProductService() {
		return productService;
	}
	public void setProductService(IProductService productService) {
		this.productService = productService;
	}
	public List<String> getProductsName() {
		return productsName;
	}
	public void setProductsName(List<String> productsName) {
		this.productsName = productsName;
	}
	public IClientService getClientService() {
		return clientService;
	}
	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}

	public List<String> getClientsName() {
		return clientsName;
	}
	public void setClientsName(List<String> clientsName) {
		this.clientsName = clientsName;
	}
	public IOrderService getOrderService() {
		return orderService;
	}


	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
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

	public TsOrder getOrder() {
		return order;
	}

	public void setOrder(TsOrder order) {
		this.order = order;
	}

	public List<TsOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<TsOrder> orders) {
		this.orders = orders;
	}

	
	public IUserService getUserService() {
		return userService;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	@Override
	public TsOrder getModel() {
		// TODO Auto-generated method stub
		return order;
	}

}
