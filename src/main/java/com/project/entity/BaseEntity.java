package com.project.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public abstract class BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String crtr;
	private Date crtm;
	private String updtr;
	private Date updtm;

	@Column(name = "crtr", length = 100)
	public String getCrtr() {
		return crtr;
	}

	public void setCrtr(String crtr) {
		this.crtr = crtr;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "crtm")
	public Date getCrtm() {
		return crtm;
	}

	public void setCrtm(Date crtm) {
		this.crtm = crtm;
	}

	@Column(name = "updtr", length = 100)
	public String getUpdtr() {
		return updtr;
	}

	public void setUpdtr(String updtr) {
		this.updtr = updtr;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updtm")
	public Date getUpdtm() {
		return updtm;
	}

	public void setUpdtm(Date updtm) {
		this.updtm = updtm;
	}

}
