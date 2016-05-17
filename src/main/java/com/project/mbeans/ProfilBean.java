package com.project.mbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.project.entity.Profil;
import com.project.service.ProfilService;

@Controller("profilBean")
@Scope("session")
public class ProfilBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	@Autowired
	private transient ProfilService ProfilService;

	private Profil profil;
	private String mesaj;
	List<Profil> ProfilList;

	@PostConstruct
	public void init() {
		ProfilList = ProfilService.getAll();
	}

	public void olustur() {
		System.out.println(profil.toString());

		if (this.profil != null && this.profil.getId() != null) {
			ProfilService.update(profil);
		} else {
			ProfilService.save(profil);
		}

		ProfilList = ProfilService.getAll();

		FacesContext.getCurrentInstance().addMessage("Kayýt",
				new FacesMessage("Profil Kaydedildi"));
		profil = new Profil();
	}

	public void sil(Long id) {
		Profil entity = ProfilService.getById(id);
		ProfilService.delete(entity);
		ProfilList = ProfilService.getAll();
		FacesContext.getCurrentInstance().addMessage("Kayýt",
				new FacesMessage("Profil Silindi"));
	}

	public void duzenle(Long id) {
		Profil entity = ProfilService.getById(id);
		this.profil = entity;
	}

	public void yeni() {
		this.profil = new Profil();
	}

	public Profil getProfil() {
		if (profil == null) {
			profil = new Profil();
		}
		return profil;
	}

	public void setProfil(Profil Profil) {
		this.profil = Profil;
	}

	public String getMesaj() {
		return mesaj;
	}

	public List<Profil> getProfilList() {
		return ProfilList;
	}

}