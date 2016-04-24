package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SIRKET")
public class Sirket extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String adi;
	private String sektoru;
	private int calisansayisi;
	private String adresi;
	private String ulke;
	private String sehir;
	private String webadresi;

	@Id
	@SequenceGenerator(name = "SEQ_SIRKET_ID", sequenceName = "SEQ_SIRKET_ID", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SIRKET_ID")
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "SIRKETADI")
	public String getAdi() {
		return adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

	@Column(name = "SEKTORU")
	public String getSektoru() {
		return sektoru;
	}

	public void setSektoru(String sektoru) {
		this.sektoru = sektoru;
	}

	@Column(name = "CALISANSAYISI")
	public int getCalisansayisi() {
		return calisansayisi;
	}

	public void setCalisansayisi(int calisansayisi) {
		this.calisansayisi = calisansayisi;
	}

	@Column(name = "SIRKETADRESI")
	public String getAdresi() {
		return adresi;
	}

	public void setAdresi(String adresi) {
		this.adresi = adresi;
	}

	@Column(name = "ULKE")
	public String getUlke() {
		return ulke;
	}

	public void setUlke(String ulke) {
		this.ulke = ulke;
	}

	@Column(name = "SIRKETSEHRI")
	public String getSehir() {
		return sehir;
	}

	public void setSehir(String sehir) {
		this.sehir = sehir;
	}

	@Column(name = "WEBADRESI")
	public String getWebadresi() {
		return webadresi;
	}

	public void setWebadresi(String webadresi) {
		this.webadresi = webadresi;
	}

}
