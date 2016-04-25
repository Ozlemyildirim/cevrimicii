package com.project.mbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.project.entity.Sirket;
import com.project.service.SirketService;

@Controller("sirketBean")
@Scope("session")
public class SirketBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	@Autowired
	private transient SirketService SirketService;

	private Sirket Sirket;
	private String mesaj;
	List<Sirket> SirketList;

	@PostConstruct
	public void init() {
		SirketList = SirketService.getAll();
	}

	public void olustur() {
		System.out.println(Sirket.toString());

		if (this.Sirket != null && this.Sirket.getId() != null) {
			SirketService.update(Sirket);
		} else {
			SirketService.save(Sirket);
		}

		SirketList = SirketService.getAll();

		FacesContext.getCurrentInstance().addMessage("Kayýt",
				new FacesMessage("Sirket Kaydedildi"));
		Sirket = new Sirket();
	}

	public void sil(Long id) {
		Sirket entity = SirketService.getById(id);
		SirketService.delete(entity);
		SirketList = SirketService.getAll();
		FacesContext.getCurrentInstance().addMessage("Kayýt",
				new FacesMessage("Sirket Silindi"));
	}

	public void duzenle(Long id) {
		Sirket entity = SirketService.getById(id);
		this.Sirket = entity;
	}

	public void yeni() {
		this.Sirket = new Sirket();
	}

	public Sirket getSirket() {
		if (Sirket == null) {
			Sirket = new Sirket();
		}
		return Sirket;
	}

	public void setSirket(Sirket Sirket) {
		this.Sirket = Sirket;
	}

	public String getMesaj() {
		return mesaj;
	}

	public List<Sirket> getSirketList() {
		return SirketList;
	}

}