package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="REFERANS")
public class Referans extends BaseEntity{

	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String ad;
	private String soyad;
	private String referanstipi;
	private String pozisyon;
	
	
	
	
	@Id
	@SequenceGenerator(name="SEQ_REFERANS_ID",sequenceName="SEQ_REFERANS_ID",allocationSize=1,initialValue=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ_REFERANS_ID")
	@Column(name="ID")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
		
	}
	
	
	@Column(name = "ADI")
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	
	
	
	@Column(name = "SOYAD")
	public String getSoyad() {
		return soyad;
	}
	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}
	
	
	
	@Column(name = "REFERANSTIPI")
	public String getReferanstipi() {
		return referanstipi;
	}
	public void setReferanstipi(String referansTipi) {
		this.referanstipi = referanstipi;
	}
	

	@Column(name = "POZISYON")
	public String getPozisyon() {
		return pozisyon;
	}
	public void setPozisyon(String pozisyon) {
		this.pozisyon = pozisyon;
	}
	




}
