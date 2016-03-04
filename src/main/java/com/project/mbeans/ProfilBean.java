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
public class ProfilBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private transient ProfilService profilService;
	private Profil profil;
	List<Profil> profilList;
	private String mesaj;
	
	@PostConstruct
	public void init() {
		System.out.println("profilBean construct");
		profilService=new ProfilService();	
		profilList=profilService.getAll();
	}
	public void kaydet() {
		System.out.println(profil.toString());
		profilService.save(profil);
		profilList=profilService.getAll();
		mesaj="Profil kaydedildi";
		profil=new Profil();

	}
	
	public void sil(Long id) {
		Profil entity=profilService.getById(id);
		profilService.delete(entity);
		profilList=profilService.getAll();
	}
	
	public Profil getProfil() {
		if(profil==null){
			profil= new Profil();
		}
		return profil;
	}
	public void setProfil(Profil profil) {
		this.profil = profil;
	}
	public List<Profil> getProfilList() {
		return profilList;
	}
	public void setProfilList(List<Profil> profilList) {
		this.profilList = profilList;
	}
	public String getMesaj() {
		return mesaj;
	}
	public void setMesaj(String mesaj) {
		this.mesaj = mesaj;
	}
	
	

}