package com.project.mbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.project.entity.Egitim;
import com.project.service.EgitimService;

@Controller("egitimBean")
@Scope("session")
public class EgitimBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private transient EgitimService egitimService;
	private Egitim egitim;
	List<Egitim> egitimList;
	private String mesaj;

	@PostConstruct
	public void init() {
		System.out.println("deneyimBean construct");
		egitimService = new EgitimService();
		egitimList = egitimService.getAll();
	}

	public void kaydet() {
		System.out.println(egitim.toString());

		if (this.egitim != null && this.egitim.getId() != null) {
			egitimService.update(egitim);
		} else {
			egitimService.save(egitim);
		}

		egitimList = egitimService.getAll();

		FacesContext.getCurrentInstance().addMessage("Kayýt",
				new FacesMessage("Egitim Kaydedildi"));
		egitim = new Egitim();
	}

	public void sil(Long id) {
		Egitim entity = egitimService.getById(id);
		egitimService.delete(entity);
		egitimList = egitimService.getAll();
		FacesContext.getCurrentInstance().addMessage("Kayýt",
				new FacesMessage("Eðitim Silindi"));
	}

	public void duzenle(Long id) {
		Egitim entity = egitimService.getById(id);
		this.egitim = entity;
	}

	public void yeni() {
		this.egitim = new Egitim();
	}

	public Egitim getEgitim() {
		if (egitim == null) {
			egitim = new Egitim();
		}
		return egitim;
	}

	public void setEgitim(Egitim egitim) {
		this.egitim = egitim;
	}

	public List<Egitim> getEgitimList() {
		return egitimList;
	}

	public String getMesaj() {
		return mesaj;
	}

}
