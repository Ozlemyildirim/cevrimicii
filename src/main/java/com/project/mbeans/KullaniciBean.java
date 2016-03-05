package com.project.mbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.project.entity.Kullanici;
import com.project.service.KullaniciService;

@Controller("kullaniciBean")
@Scope("view")
public class KullaniciBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	@Autowired
	private transient KullaniciService kullaniciService;

	
	private Kullanici kullanici;
	private String mesaj;
	List<Kullanici> kullaniciList;
	
	@PostConstruct
	public void init() {
		kullaniciList=kullaniciService.getAll();
	}
	
	public void kaydet() {
		System.out.println(kullanici.toString());
				
		if(this.kullanici!=null && this.kullanici.getId()!=null){
			kullaniciService.update(kullanici);	
		}else{
			kullaniciService.save(kullanici);
		}
		
		kullaniciList=kullaniciService.getAll();
		
		FacesContext.getCurrentInstance().addMessage("Kayýt", new FacesMessage("Kullanýcý Kaydedildi"));
		kullanici=new Kullanici();
	}
	
	
	public void sil(Long id) {
		Kullanici entity= kullaniciService.getById(id);
		kullaniciService.delete(entity);
		kullaniciList=kullaniciService.getAll();
		FacesContext.getCurrentInstance().addMessage("Kayýt", new FacesMessage("Kullanýcý Silindi"));
	}
	
	
	public void duzenle(Long id) {
		Kullanici entity= kullaniciService.getById(id);
		this.kullanici=entity;
	}
	
	public void yeni() {
		this.kullanici=new Kullanici();
	}
	
	public Kullanici getKullanici() {
		if(kullanici==null){
			kullanici=new Kullanici();
		}
		return kullanici;
	}
	
	public void setKullanici(Kullanici kullanici) {
		this.kullanici = kullanici;
	}
	
	public String getMesaj() {
		return mesaj;
	}
	
	public List<Kullanici> getKullaniciList() {
		return kullaniciList;
	}
	

}