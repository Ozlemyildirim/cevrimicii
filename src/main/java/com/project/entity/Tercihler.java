package com.project.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "TERCÝHLER")
public class Tercihler extends BaseEntity {

	
	 
	private static final long serialVersionUID = 1L;
	private Long id;
	private String ulke;
	private String sehir;
	private String sektor; 
	private String pozisyon;
	
	@Id
	@SequenceGenerator(name="SEQ_TERCÝHLER_ID",sequenceName="SEQ_TERCÝHLER_ID",allocationSize=1,initialValue=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ_TERCÝHLER_ID")
	@Column(name="ID")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "ÜLKE")
	public String getUlke() {
		return ulke;
	}
	public void setUlke(String ulke) {
		this.ulke = ulke;
	}
	@Column(name = "SEHIR")
	public String getSehir() {
		return sehir;
	}
	public void setSehir(String sehir) {
		this.sehir = sehir;
	}
	@Column(name = "SEKTOR")
	public String getSektor() {
		return sektor;
	}
	public void setSektor(String sektor) {
		this.sektor = sektor;
	}

	
	@Column(name = "POZISYON")
	public String getPozisyon() {
		return pozisyon;
	}
	public void setPozisyon(String pozisyon) {
		this.pozisyon = pozisyon;
	}

}