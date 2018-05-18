package com.huan.business.dao;

import java.math.BigDecimal;
import java.util.List;

import com.huan.business.po.TsMainview;
import com.huan.tool.TotalNum;

public interface IMainDao {
    	public List<TsMainview> getTopUserByOrderNum(BigDecimal manageId);
    	public Integer getTotalOrderNum(BigDecimal manageId);
    	public Integer getTotalClientNum(BigDecimal manageId);
    	public Double getTotalPriceNum(BigDecimal manageId);
}
