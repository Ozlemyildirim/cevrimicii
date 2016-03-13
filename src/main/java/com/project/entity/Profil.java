package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;



@Entity
@Table(name="PROFIL")
public class Profil extends BaseEntity{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -71084122760408808L;
	private Long id;
    private String adi;
    private String soyadi;
    private String cinsiyet;
    private String eposta;
    private String telefon;
    private String dtarihi;
    private String adres;
    private String medenihal;
    private String askerlik;

    @Id
    @SequenceGenerator(name="SEQ_PERSON_ID",sequenceName="SEQ_PERSON_ID",allocationSize=1,initialValue=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="SEQ_PERSON_ID")
    @Column(name="ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="AD",length=100)
    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    @Column(name="SOYAD" ,length=100)
    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }
    
    @Column(name="CINSIYET",length=100)
    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }
    
    @Column(name="EPOSTA",length=100)
    public String getEposta() {
        return eposta;
    }

    public void setEposta (String eposta) {
        this.eposta = eposta;
    }
    
    
    
    @Column(name="DTARIHI",length=100)
    public String getDtarihi() {
        return dtarihi;
    }

    public void setDtarihi(String dtarihi) {
        this.dtarihi = dtarihi;
    }
    
    
    @Column(name="ADRES",length=100)
    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
    
    
    @Column(name="MEDENIHAL",length=100)
    public String getMedenihal() {
        return medenihal;
    }

    public void setMedenihal (String medenihal) {
        this.medenihal = medenihal;
    }
    
    
    @Column(name="ASKERLIK",length=100)
    public String getAskerlik() {
        return askerlik;
    }

    public void setAskerlik(String askerlik) {
        this.askerlik = askerlik;
    }
    
    
    

    @XmlTransient
    @Column(name="PHONE" ,length=13)
    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    
    @Override
    public boolean equals(Object arg0) {
    	if(arg0 instanceof Profil){
    		Profil t = (Profil) arg0;
    		if(t.getId().equals(this.id)){
    			return true;
    		}
    	}
    	return false;
    }
}