package com.huan.business.dao;

import java.util.List;

import com.huan.business.po.TsPower;
import com.huan.tool.PageBean;
import com.huan.tool.PageModel;

public interface IPowerDao {
	public PageModel getPowerList(TsPower power,PageBean page);
	public  List<Integer> getPowerList();
}
