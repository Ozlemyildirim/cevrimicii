package com.project.mbeans;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.project.entity.Referans;
import com.project.service.ReferansService;


@Controller("referansBean")
@Scope("session")
public class ReferansBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private transient ReferansService referansService;
	private Referans referans;
	List<Referans> referansList;
	private String mesaj;
	
	@PostConstruct
	public void init() {
		System.out.println("referansBean construct");
		referansService=new ReferansService();	
		referansList=referansService.getAll();
	}
	public void kaydet() {
		System.out.println(referans.toString());
		
		if (this.referans != null && this.referans.getId() != null) {
			referansService.update(referans);
		} else {
			referansService.save(referans);
		}
		
	
		referansList=referansService.getAll();
		
		FacesContext.getCurrentInstance().addMessage("Kayýt",
				new FacesMessage("Referans Kaydedildi"));
		referans= new Referans();
		
	}
	
	public void sil(Long id) {
		Referans entity=referansService.getById(id);
		referansService.delete(entity);
		referansList=referansService.getAll();
		FacesContext.getCurrentInstance().addMessage("Kayýt",
				new FacesMessage("Referans Silindi"));
	}
	
	public void duzenle(Long id) {
		Referans entity = referansService.getById(id);
		this.referans = entity;
	}

	public void yeni() {
		this.referans = new Referans();
	}

	public Referans getReferans() {
		if (referans == null) {
			referans = new Referans();
		}
		return referans;
	}



	public List<Referans> getReferansList() {
		return referansList;
	}
	

		
	public void setReferans(Referans referans) {
		this.referans = referans;
	}
	
	public void setReferansList(List<Referans> referansList) {
		this.referansList = referansList;
	}
	
	public String getMesaj() {
		return mesaj;
	}
	
	

}