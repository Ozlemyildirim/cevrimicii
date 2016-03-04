package com.project.mbeans;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.project.entity.Referans;
import com.project.service.ReferansService;


@Controller("referansBean")
@Scope("session")
public class ReferansBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private transient ReferansService referansService;
	private Referans referans;
	List<Referans> referansList;
	private String mesaj;
	
	@PostConstruct
	public void init() {
		System.out.println("referansBean construct");
		referansService=new ReferansService();	
		referansList=referansService.getAll();
	}
	public void kaydet() {
		System.out.println(referans.toString());
		referansService.save(referans);
		referansList=referansService.getAll();
		mesaj="Referans kaydedildi";
		referans=new Referans();

	}
	
	public void sil(Long id) {
		Referans entity=referansService.getById(id);
		referansService.delete(entity);
		referansList=referansService.getAll();
	}
	
	public Referans getReferans() {
		if(referans==null){
			referans= new Referans();
		}
		return referans;
	}
	public void setReferans(Referans referans) {
		this.referans = referans;
	}
	public List<Referans> getReferansList() {
		return referansList;
	}
	public void setReferansList(List<Referans> referansList) {
		this.referansList = referansList;
	}
	public String getMesaj() {
		return mesaj;
	}
	public void setMesaj(String mesaj) {
		this.mesaj = mesaj;
	}
	
	

}