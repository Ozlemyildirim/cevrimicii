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
@Table(name="DUYURU")
public class Duyuru extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String sehir;
	private String pozisyon;
	private String sirket;
	private String sektor;
	private Date duyurutarihi;
	private String egitim;
	private String deneyim;
	private String askerlik;

	@Id
	@SequenceGenerator(name = "SEQ_DUYURU_ID", sequenceName = "SEQ_DUYURU_ID", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_DUYURU_ID")
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "SEHIR")
	public String getSehir() {
		return sehir;
	}

	public void setSehir(String sehir) {
		this.sehir = sehir;
	}

	@Column(name = "POZISYON")
	public String getPozisyon() {
		return pozisyon;
	}

	public void setPozisyon(String pozisyon) {
		this.pozisyon = pozisyon;
	}

	@Column(name = "SIRKET")
	public String getSirket() {
		return sirket;
	}

	public void setSirket(String sirket) {
		this.sirket = sirket;
	}

	@Column(name = "SEKTOR")
	public String getSektor() {
		return sektor;
	}

	public void setSektor(String sektor) {
		this.sektor = sektor;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DUYURUTARIHI")
	public Date getDuyurutarihi() {
		return duyurutarihi;
	}

	public void setDuyurutarihi(Date duyurutarihi) {
		this.duyurutarihi = duyurutarihi;
	}

	@Column(name = "EGITIM")
	public String getEgitim() {
		return egitim;
	}

	public void setEgitim(String egitim) {
		this.egitim = egitim;
	}

	@Column(name = "DENEYIM")
	public String getDeneyim() {
		return deneyim;
	}

	public void setDeneyim(String deneyim) {
		this.deneyim = deneyim;
	}

	@Column(name = "ASKERLIK")
	public String getAskerlik() {
		return askerlik;
	}

	public void setAskerlik(String askerlik) {
		this.askerlik = askerlik;
	}

}
