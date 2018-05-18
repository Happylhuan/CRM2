package com.huan.tool;

public class TotalNum {
	private Integer orderTotalNum;
	private Integer clientTotalNum;
	private double priceNum;
	public Integer getOrderTotalNum() {
		return orderTotalNum;
	}
	public void setOrderTotalNum(Integer orderTotalNum) {
		this.orderTotalNum = orderTotalNum;
	}
	public Integer getClientTotalNum() {
		return clientTotalNum;
	}
	public void setClientTotalNum(Integer clientTotalNum) {
		this.clientTotalNum = clientTotalNum;
	}
	public double getPriceNum() {
		return priceNum;
	}
	public void setPriceNum(double priceNum) {
		this.priceNum = priceNum;
	}
	public TotalNum(Integer orderTotalNum, Integer clientTotalNum, double priceNum) {
		super();
		this.orderTotalNum = orderTotalNum;
		this.clientTotalNum = clientTotalNum;
		this.priceNum = priceNum;
	}
	public TotalNum() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
