package com.huan.business.service;

import java.math.BigDecimal;
import java.util.List;

import com.huan.business.po.TsMainview;
import com.huan.tool.TotalNum;

public interface IMainService {
	public List<TsMainview> getTopUserByOrderNum(BigDecimal manageId);
	public TotalNum getTotalNum(BigDecimal manageId);
}
