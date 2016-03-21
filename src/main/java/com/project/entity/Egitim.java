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
@Table(name = "EGITIM")
public class Egitim extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String egitimseviyesi;
	private String okuladi;
	private Date mezuniyetyili;
	private float diplomanotu;
	private String staj_sirketadi;
	private String staj_sektor;
	private Date staj_baslamatarihi;
	private Date staj_bitistarihi;
	private int staj_suresi;
	private String yabancýdiller;
	private String yetkinlikler_adi;
	private String yetkinlikler_seviye;
	private String kurs_adi;
	private String kurs_kurum;
	private String sýnav_adi;
	private float sýnav_notu;
	private String sertifika_alani;
	private String sertifika_adi;
	private String sertifika_kurum;

	@Id
	@SequenceGenerator(name = "SEQ_EGITIM_ID", sequenceName = "SEQ_EGITIM_ID", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EGITIM_ID")
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "EGITIMSEVIYESI")
	public String getEgitimseviyesi() {
		return egitimseviyesi;
	}

	public void setEgitimseviyesi(String egitimseviyesi) {
		this.egitimseviyesi = egitimseviyesi;
	}

	@Column(name = "OKULADI")
	public String getOkuladi() {
		return okuladi;
	}

	public void setOkuladi(String okuladi) {
		this.okuladi = okuladi;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "MEZUNIYETYILI")
	public Date getMezuniyetyili() {
		return mezuniyetyili;
	}

	public void setMezuniyetyili(Date mezuniyetyili) {
		this.mezuniyetyili = mezuniyetyili;
	}

	@Column(name = "DIPLOMANOTU")
	public float getDiplomanotu() {
		return diplomanotu;
	}

	public void setDiplomanotu(float diplomanotu) {
		this.diplomanotu = diplomanotu;
	}

	@Column(name = "STAJSIRKETADI")
	public String getStaj_sirketadi() {
		return staj_sirketadi;
	}

	public void setStaj_sirketadi(String staj_sirketadi) {
		this.staj_sirketadi = staj_sirketadi;
	}

	@Column(name = "STAJSEKTORU")
	public String getStaj_sektor() {
		return staj_sektor;
	}

	public void setStaj_sektor(String staj_sektor) {
		this.staj_sektor = staj_sektor;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "STAJBASLAMA")
	public Date getStaj_baslamatarihi() {
		return staj_baslamatarihi;
	}

	public void setStaj_baslamatarihi(Date staj_baslamatarihi) {
		this.staj_baslamatarihi = staj_baslamatarihi;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "STAJBITIS")
	public Date getStaj_bitistarihi() {
		return staj_bitistarihi;
	}

	public void setStaj_bitistarihi(Date staj_bitistarihi) {
		this.staj_bitistarihi = staj_bitistarihi;
	}

	@Column(name = "STAJSURESI")
	public int getStaj_suresi() {
		return staj_suresi;
	}

	public void setStaj_suresi(int staj_suresi) {
		this.staj_suresi = staj_suresi;
	}

	@Column(name = "YABANCIDILLER")
	public String getYabancýdiller() {
		return yabancýdiller;
	}

	public void setYabancýdiller(String yabancýdiller) {
		this.yabancýdiller = yabancýdiller;
	}

	@Column(name = "YETKINLIKADI")
	public String getYetkinlikler_adi() {
		return yetkinlikler_adi;
	}

	public void setYetkinlikler_adi(String yetkinlikler_adi) {
		this.yetkinlikler_adi = yetkinlikler_adi;
	}

	@Column(name = "YETKINLIKSEVIYE")
	public String getYetkinlikler_seviye() {
		return yetkinlikler_seviye;
	}

	public void setYetkinlikler_seviye(String yetkinlikler_seviye) {
		this.yetkinlikler_seviye = yetkinlikler_seviye;
	}

	@Column(name = "KURSADI")
	public String getKurs_adi() {
		return kurs_adi;
	}

	public void setKurs_adi(String kurs_adi) {
		this.kurs_adi = kurs_adi;
	}

	@Column(name = "KURSKURUM")
	public String getKurs_kurum() {
		return kurs_kurum;
	}

	public void setKurs_kurum(String kurs_kurum) {
		this.kurs_kurum = kurs_kurum;
	}

	@Column(name = "SINAVADI")
	public String getSýnav_adi() {
		return sýnav_adi;
	}

	public void setSýnav_adi(String sýnav_adi) {
		this.sýnav_adi = sýnav_adi;
	}

	@Column(name = "SINAVNOTU")
	public float getSýnav_notu() {
		return sýnav_notu;
	}

	public void setSýnav_notu(float sýnav_notu) {
		this.sýnav_notu = sýnav_notu;
	}

	@Column(name = "SERTIFIKAALANI")
	public String getSertifika_alani() {
		return sertifika_alani;
	}

	public void setSertifika_alani(String sertifika_alani) {
		this.sertifika_alani = sertifika_alani;
	}

	@Column(name = "SERTIFIKAADI")
	public String getSertifika_adi() {
		return sertifika_adi;
	}

	public void setSertifika_adi(String sertifika_adi) {
		this.sertifika_adi = sertifika_adi;
	}

	@Column(name = "SERTIFIKAKURUM")
	public String getSertifika_kurum() {
		return sertifika_kurum;
	}

	public void setSertifika_kurum(String sertifika_kurum) {
		this.sertifika_kurum = sertifika_kurum;
	}

}
