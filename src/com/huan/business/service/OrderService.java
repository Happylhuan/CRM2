package com.huan.business.service;

import java.util.Date;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huan.business.dao.IOrderDao;
import com.huan.business.po.TsOrder;
import com.huan.tool.PageBean;
import com.huan.tool.PageModel;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)  
public class OrderService implements IOrderService {
	private IOrderDao orderDao;
	
	public IOrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(IOrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public PageModel getOrderList(TsOrder order, PageBean page) {
		String hql = " from TsOrder order where 1=1 ";
		if(null!=order.getUserId()){
			hql += " and order.userId ='"+order.getUserId()+"' ";
		}else if(null!=order.getManageId()){
			hql += " and order.userId in (select userId from TsUser where manageId = "+order.getManageId()+") ";
		}
		if(null!=order.getSendState()||null!=order.getIsSend()){
			if("all".equals(order.getSendState())){
				
			}else {
				if("yes".equals(order.getSendState())||"yes".equals(order.getIsSend())){
					hql += "  and order.isSend=true ";
				}else if("no".equals(order.getSendState())||"no".equals(order.getIsSend())){
					hql += " and order.isSend=false ";
				}
			}
			
		}
		if(null!=order.getAddress()){
			order.setAddress("");
			order.setClienName("");;
			order.setOrderId(null);
			order.setPhoneNum("");
			order.setProductName("");
			order.setSendTime(null);
			order.setUserName("");
		}
		PageModel pageModel = ( PageModel) this.orderDao.getOrderList(order, page,hql);
		return pageModel;
	}

	@Override
	public boolean addOrder(TsOrder order) {
		order.setClienName(order.getClienName().trim());
		order.setAddress(order.getAddress().trim());
		order.setPhoneNum(order.getPhoneNum().trim());
		order.setProductName( order.getProductName().trim());
		order.setTotalPrice((long)order.getProductNum()*order.getProductPrice());
		order.setOrderTime(new Date());
		order.setIsSend(false);
		if(this.orderDao.addOrder(order)){
			return true;
		}
		return false;
	}

	@Override
	public boolean delOrder(TsOrder Order) {
		// TODO Auto-generated method stub
		return this.orderDao.delOrder(Order);
	}

	@Override
	public boolean updateOrder(TsOrder Order) {
		// TODO Auto-generated method stub
		return orderDao.updateOrder(Order);
	}
	@Override
	public boolean sendOrder(TsOrder Order) {
		// TODO Auto-generated method stub
		TsOrder order2 = orderDao.getOrderById(Order.getOrderId());
		if(order2.getIsSend()){
			order2.setIsSend(false);
		}else{
			order2.setIsSend(true);
		}
		return orderDao.updateOrder(order2);
	}
	@Override
	public TsOrder getOrderById(int orderId) {
		// TODO Auto-generated method stub
		return orderDao.getOrderById(orderId);
	}

}
