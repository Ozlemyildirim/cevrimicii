package com.project.mbeans;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.project.entity.Tercihler;
import com.project.service.TercihlerService;


@Controller("tercihlersBean")
@Scope("session")
public class TercihlerBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private transient TercihlerService tercihlerService;
	private Tercihler tercihler;
	List<Tercihler> tercihlerList;
	private String mesaj;
	
	@PostConstruct
	public void init() {
		System.out.println("tercihlerBean construct");
		tercihlerService=new TercihlerService();	
		tercihlerList=tercihlerService.getAll();
	}
	public void kaydet() {
		System.out.println(tercihler.toString());
		
		if (this.tercihler != null && this.tercihler.getId() != null) {
			tercihlerService.update(tercihler);
		} else {
			tercihlerService.save(tercihler);
		}
		
	
		tercihlerList=tercihlerService.getAll();
		
		FacesContext.getCurrentInstance().addMessage("Kayýt",
				new FacesMessage("Tercihler Kaydedildi"));
		tercihler= new Tercihler();
		
	}
	
	public void sil(Long id) {
		Tercihler entity=tercihlerService.getById(id);
		tercihlerService.delete(entity);
		tercihlerList=tercihlerService.getAll();
		FacesContext.getCurrentInstance().addMessage("Kayýt",
				new FacesMessage("Tercihler Silindi"));
	}
	
	public void duzenle(Long id) {
		Tercihler entity = tercihlerService.getById(id);
		this.tercihler = entity;
	}

	public void yeni() {
		this.tercihler = new Tercihler();
	}

	public Tercihler getTercihler() {
		if (tercihler == null) {
			tercihler = new Tercihler();
		}
		return tercihler;
	}



	public List<Tercihler> getTercihlerList() {
		return tercihlerList;
	}
	

		
	public void setTercihler(Tercihler tercihler) {
		this.tercihler = tercihler;
	}
	
	public void setTercihlerList(List<Tercihler> tercihlerList) {
		this.tercihlerList =tercihlerList;
	}
	
	public String getMesaj() {
		return mesaj;
	}
	
	

}