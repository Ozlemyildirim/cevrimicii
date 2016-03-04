package com.project.mbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.project.entity.Tercihler;
import com.project.service.TercihlerService;


@Controller("tercihlerBean")
@Scope("session")
public class TercihlerBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private transient TercihlerService tercihlerService;
	private Tercihler tercihler;
	List<Tercihler> tercihlerList;
	private String mesaj;
	
	@PostConstruct
	public void init() {
		System.out.println("tercihlerBean construct");
		tercihlerService=new TercihlerService();	
		tercihlerList=tercihlerService.getAll();
	}
	public void kaydet() {
		System.out.println(tercihler.toString());
		tercihlerService.save(tercihler);
		tercihlerList=tercihlerService.getAll();
		mesaj="Tercihler kaydedildi";
		tercihler=new Tercihler();

	}
	
	public void sil(Long id) {
		Tercihler entity=tercihlerService.getById(id);
		tercihlerService.delete(entity);
		tercihlerList=tercihlerService.getAll();
	}
	
	public Tercihler getTercihler() {
		if(tercihler==null){
			tercihler= new Tercihler();
		}
		return tercihler;
	}
	public void setTercihler(Tercihler tercihler) {
		this.tercihler = tercihler;
	}
	public List<Tercihler> getTercihlerList() {
		return tercihlerList;
	}
	public void setTercihlerList(List<Tercihler> tercihlerList) {
		this.tercihlerList = tercihlerList;
	}
	public String getMesaj() {
		return mesaj;
	}
	public void setMesaj(String mesaj) {
		this.mesaj = mesaj;
	}
	
	

}