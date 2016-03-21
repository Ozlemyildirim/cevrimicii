package com.project.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "DENEYIM")
public class Deneyim extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String pozisyon;
	private String sirketadi;
	private String sehir;
	private Date isebaslamatarihi;
	private Date bitistarihi;

	@Id
	@SequenceGenerator(name = "SEQ_DENEYIM_ID", sequenceName = "SEQ_DENEYIM_ID", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_DENEYIM_ID")
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "POZISYON")
	public String getPozisyon() {
		return pozisyon;
	}

	public void setPozisyon(String pozisyon) {
		this.pozisyon = pozisyon;
	}

	@Column(name = "SIRKETADI")
	public String getSirketadi() {
		return sirketadi;
	}

	public void setSirketadi(String sirketadi) {
		this.sirketadi = sirketadi;
	}

	@Column(name = "SEHIR")
	public String getSehir() {
		return sehir;
	}

	public void setSehir(String sehir) {
		this.sehir = sehir;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "BASLAMATARIHI")
	public Date getIsebaslamatarihi() {
		return isebaslamatarihi;
	}

	public void setIsebaslamatarihi(Date isebaslamatarihi) {
		this.isebaslamatarihi = isebaslamatarihi;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="BITISTARIHI")
	public Date getBitistarihi() {
		return bitistarihi;
	}

	public void setBitistarihi(Date bitistarihi) {
		this.bitistarihi = bitistarihi;
	}

}
