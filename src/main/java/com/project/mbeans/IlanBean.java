package com.project.mbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.project.entity.Ilan;
import com.project.service.IlanService;

@Controller("ilanBean")
@Scope("session")
public class IlanBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	@Autowired
	private transient IlanService ilanService;

	private Ilan ilan;
	private String mesaj;
	List<Ilan> ilanList;

	@PostConstruct
	public void init() {
		ilanList = ilanService.getAll();
	}

	public void kaydet() {
		System.out.println(ilan.toString());

		if (this.ilan != null && this.ilan.getId() != null) {
			ilanService.update(ilan);
		} else {
			ilanService.save(ilan);
		}

		ilanList = ilanService.getAll();

		FacesContext.getCurrentInstance().addMessage("Kayýt",
				new FacesMessage("ilan Kaydedildi"));
		ilan = new Ilan();
	}

	public void sil(Long id) {
		Ilan entity = ilanService.getById(id);
		ilanService.delete(entity);
		ilanList = ilanService.getAll();
		FacesContext.getCurrentInstance().addMessage("Kayýt",
				new FacesMessage("ilan Silindi"));
	}

	public void duzenle(Long id) {
		Ilan entity = ilanService.getById(id);
		this.ilan = entity;
	}

	public void yeni() {
		this.ilan = new Ilan();
	}

	public Ilan getDeneyim() {
		if (ilan == null) {
			ilan = new Ilan();
		}
		return ilan;
	}

	public void setIlan(Ilan ilan) {
		this.ilan = ilan;
	}

	public String getMesaj() {
		return mesaj;
	}

	public List<Ilan> getIlanList() {
		return ilanList;
	}

}