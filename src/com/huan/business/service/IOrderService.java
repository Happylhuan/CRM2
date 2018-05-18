package com.huan.business.service;

import com.huan.business.po.TsOrder;
import com.huan.tool.PageBean;
import com.huan.tool.PageModel;

public interface IOrderService {
	public PageModel getOrderList(TsOrder Order,PageBean page);
	public boolean addOrder(TsOrder Order);

	public boolean delOrder(TsOrder Order);

	public boolean updateOrder(TsOrder Order);

	public TsOrder getOrderById(int orderId);

	public boolean sendOrder(TsOrder Order);
}
