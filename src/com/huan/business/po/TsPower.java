package com.huan.business.po;

import java.math.BigDecimal;

public class TsPower implements java.io.Serializable {

	// Fields

	private BigDecimal pid;
	private Integer power;
	// Constructors

	
	/** full constructor */
	public TsPower(Integer power) {
		this.power = power;
	}

	public TsPower() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BigDecimal getPid() {
		return pid;
	}

	public void setPid(BigDecimal pid) {
		this.pid = pid;
	}

	public Integer getPower() {
		return power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}


	// Property accessors

}