package com.project.mbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.project.entity.Deneyim;
import com.project.service.DeneyimService;

@Controller("deneyimBean")
@Scope("session")
public class DeneyimBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	@Autowired
	private transient DeneyimService deneyimService;

	private Deneyim deneyim;
	private String mesaj;
	List<Deneyim> deneyimList;

	@PostConstruct
	public void init() {
		deneyimList = deneyimService.getAll();
	}

	public void olustur() {
		System.out.println(deneyim.toString());

		if (this.deneyim != null && this.deneyim.getId() != null) {
			deneyimService.update(deneyim);
		} else {
			deneyimService.save(deneyim);
		}

		deneyimList = deneyimService.getAll();

		FacesContext.getCurrentInstance().addMessage("Kayýt",
				new FacesMessage("Deneyim Kaydedildi"));
		deneyim = new Deneyim();
	}

	public void sil(Long id) {
		Deneyim entity = deneyimService.getById(id);
		deneyimService.delete(entity);
		deneyimList = deneyimService.getAll();
		FacesContext.getCurrentInstance().addMessage("Kayýt",
				new FacesMessage("Deneyim Silindi"));
	}

	public void duzenle(Long id) {
		Deneyim entity = deneyimService.getById(id);
		this.deneyim = entity;
	}

	public void yeni() {
		this.deneyim = new Deneyim();
	}

	public Deneyim getDeneyim() {
		if (deneyim == null) {
			deneyim = new Deneyim();
		}
		return deneyim;
	}

	public void setDeneyim(Deneyim deneyim) {
		this.deneyim = deneyim;
	}

	public String getMesaj() {
		return mesaj;
	}

	public List<Deneyim> getDeneyimList() {
		return deneyimList;
	}

}