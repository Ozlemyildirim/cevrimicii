package com.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="KULLANICI")
public class Kullanici extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String username;
	private String password;
	private Profil profil;
	private Deneyim deneyim;
	private Egitim egitim;
	private Referans referans;
	private Tercihler tercihler;
	private Duyuru duyuru;
	private Sirket sirket;
	
	
	@Id
	@SequenceGenerator(name="SEQ_KULLANICI_ID",sequenceName="SEQ_KULLANICI_ID",allocationSize=1,initialValue=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ_KULLANICI_ID")
	@Column(name="ID")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="USERNAME",length=100)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Column(name="PWD",length=100)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_KULLANICI_PROFIL_ID"), name = "PROFIL_ID")
    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }
    
    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_KULLANICI_DENEYIM_ID"), name = "DENEYIM_ID")
    public Deneyim getDeneyim() {
        return deneyim;
    }

    public void setDeneyim(Deneyim deneyim) {
        this.deneyim = deneyim;
    }
    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_KULLANICI_EGITIM_ID"), name = "EGITIM_ID")
    public Egitim getEgitim() {
        return egitim;
    }

    public void setEgitim(Egitim egitim) {
        this.egitim = egitim;
    }
    
    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_KULLANICI_REFERANS_ID"), name = "REFERANS_ID")
    public Referans getReferans() {
        return referans;
    }

    public void setReferans(Referans referans) {
        this.referans = referans;
    }
    
    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_KULLANICI_TERCIHLER_ID"), name = "TERCIHLER_ID")
    public Tercihler getTercihler() {
        return tercihler;
    }

    public void setTercihler(Tercihler tercihler) {
        this.tercihler = tercihler;
    }
    
    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_KULLANICI_DUYURU_ID"), name = "DUYURU_ID")
    public Duyuru getDuyuru() {
        return duyuru;
    }

    public void setDuyuru(Duyuru duyuru) {
        this.duyuru = duyuru;
    }
    
    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_KULLANICI_SIRKET_ID"), name = "SIRKET_ID")
    public Sirket getSirket() {
        return sirket;
    }

    public void setSirket(Sirket sirket) {
        this.sirket = sirket;
    }
    
	
	
	
}
