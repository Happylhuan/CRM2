package com.huan.business.dao;

import java.util.List;

import com.huan.business.po.LljMent;

public interface IMentDao {
	public List<LljMent>  getMents();
	public boolean  addMent(LljMent ment);
	public boolean  updateMent(LljMent ment);
	public boolean  delectMent(LljMent ment);
	public boolean getMentById(int mentId);
}
