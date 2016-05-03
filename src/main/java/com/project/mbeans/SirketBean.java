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

	private Sirket sirket;
	private String mesaj;
	List<Sirket> SirketList;

	@PostConstruct
	public void init() {
		SirketList = SirketService.getAll();
	}

	public void olustur() {
		System.out.println(sirket.toString());

		if (this.sirket != null && this.sirket.getId() != null) {
			SirketService.update(sirket);
		} else {
			SirketService.save(sirket);
		}

		SirketList = SirketService.getAll();

		FacesContext.getCurrentInstance().addMessage("Kayýt",
				new FacesMessage("Sirket Kaydedildi"));
		sirket = new Sirket();
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
		this.sirket = entity;
	}

	public void yeni() {
		this.sirket = new Sirket();
	}

	public Sirket getSirket() {
		if (sirket == null) {
			sirket = new Sirket();
		}
		return sirket;
	}

	public void setSirket(Sirket Sirket) {
		this.sirket = Sirket;
	}

	public String getMesaj() {
		return mesaj;
	}

	public List<Sirket> getSirketList() {
		return SirketList;
	}

}