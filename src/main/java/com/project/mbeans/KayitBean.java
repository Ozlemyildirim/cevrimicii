package com.project.mbeans;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.project.entity.Kayit;
import com.project.service.KayitService;


@Controller("kayitBean")
@Scope("session")
public class KayitBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private transient KayitService kayitService;
	private Kayit kayit;
	List<Kayit> kayitList;
	private String mesaj;
	
	@PostConstruct
	public void init() {
		System.out.println("kayitBean construct");
		kayitService=new KayitService();	
		kayitList=kayitService.getAll();
	}
	public void kaydet() {
		System.out.println(kayit.toString());
		kayitService.save(kayit);
		kayitList=kayitService.getAll();
		mesaj="Kayit kaydedildi";
		kayit=new Kayit();

	}
	
	public void sil(Long id) {
		Kayit entity=kayitService.getById(id);
		kayitService.delete(entity);
		kayitList=kayitService.getAll();
	}
	
	public Kayit getKayit() {
		if(kayit==null){
			kayit= new Kayit();
		}
		return kayit;
	}
	public void setKayit(Kayit kayit) {
		this.kayit = kayit;
	}
	public List<Kayit> getKayitList() {
		return kayitList;
	}
	public void setKayitList(List<Kayit> kayitList) {
		this.kayitList = kayitList;
	}
	public String getMesaj() {
		return mesaj;
	}
	public void setMesaj(String mesaj) {
		this.mesaj = mesaj;
	}
	
	

}