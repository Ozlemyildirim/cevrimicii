package com.project.mbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

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
	List<Profil> ProfilList;
	List<Profil> filteredList;

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
filteredList = ProfilService.getAll();


		profil = new Profil();
	}

	public void sil(Long id) {
		Profil entity = ProfilService.getById(id);
		ProfilService.delete(entity);
		ProfilList = ProfilService.getAll();
	
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

	
	public List<Profil> getProfilList() {
		return ProfilList;
	}

	public List<Profil> getFilteredList() {
		return filteredList;
	}

	public void setFilteredList(List<Profil> filteredList) {
		this.filteredList = filteredList;
	}
	
	
	
}