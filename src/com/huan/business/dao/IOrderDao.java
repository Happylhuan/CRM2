package com.huan.business.dao;

import com.huan.business.po.TsOrder;
import com.huan.tool.PageBean;
import com.huan.tool.PageModel;

public interface IOrderDao {
	public PageModel getOrderList(TsOrder Order,PageBean page,String hql);

	public boolean addOrder(TsOrder Order);

	public boolean delOrder(TsOrder Order);

	public boolean updateOrder(TsOrder Order);

	public TsOrder getOrderById(int orderId);

	public Integer getUserIdByName(String userName);
	
}
