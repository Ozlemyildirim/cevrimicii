package com.project.mbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.project.entity.Duyuru;
import com.project.entity.Sirket;
import com.project.service.DuyuruService;
import com.project.service.SirketService;

@Controller("duyuruBean")
@Scope("session")
public class DuyuruBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	@Autowired
	private transient DuyuruService duyuruService;

	@Autowired
	private transient SirketService sirketService;
	private Duyuru duyuru;
	private String mesaj;
	List<Duyuru> duyuruList;

	@PostConstruct
	public void init() {
		duyuruList = duyuruService.getAll();
	}

	public void kaydet() {
		System.out.println(duyuru.toString());

		if (this.duyuru != null && this.duyuru.getId() != null) {
			duyuruService.update(duyuru);
		} else {
			duyuruService.save(duyuru);
		}

		duyuruList = duyuruService.getAll();

		FacesContext.getCurrentInstance().addMessage("Kayýt",
				new FacesMessage("duyuru Kaydedildi"));
		duyuru = new Duyuru();
	}

	public void sil(Long id) {
		Duyuru entity = duyuruService.getById(id);
		duyuruService.delete(entity);
		duyuruList = duyuruService.getAll();
		FacesContext.getCurrentInstance().addMessage("Kayýt",
				new FacesMessage("duyuru Silindi"));
	}

	public List<Sirket> sirketAcomp(String key) {
		return (List<Sirket>) sirketService.getByName(key);
	}

	public void duzenle(Long id) {
		Duyuru entity = duyuruService.getById(id);
		this.duyuru = entity;
	}

	public void yeni() {
		this.duyuru = new Duyuru();
	}

	public Duyuru getDuyuru() {
		if (duyuru == null) {
			duyuru = new Duyuru();
		}
		return duyuru;
	}

	public void setDuyuru(Duyuru duyuru) {
		this.duyuru = duyuru;
	}

	public String getMesaj() {
		return mesaj;
	}

	public List<Duyuru> getDuyuruList() {
		return duyuruList;
	}

}