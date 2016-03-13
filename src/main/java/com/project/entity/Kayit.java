package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name="KAYIT")
public class Kayit extends BaseEntity{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -71084122760408808L;
	private Long id;
    private String adi;
    private String soyadi;
    private String sifre;
    private String eposta;
    
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
    
    @Column(name="SIFRE",length=100)
	public String getSifre() {
		return sifre;
	}
	public void setSifre(String sifre) {
		this.sifre = sifre;
	}
	
    
    @Column(name="EPOSTA",length=100)
    public String getEposta() {
        return eposta;
    }

    public void setEposta (String eposta) {
        this.eposta = eposta;
    }
    
    
    
   
   
    
    @Override
    public boolean equals(Object arg0) {
    	if(arg0 instanceof Kayit){
    		Kayit t = (Kayit) arg0;
    		if(t.getId().equals(this.id)){
    			return true;
    		}
    	}
    	return false;
    }
}