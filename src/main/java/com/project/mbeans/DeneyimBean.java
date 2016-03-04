package com.project.mbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.project.entity.Deneyim;
import com.project.service.DeneyimService;


@Controller("deneyimBean")
@Scope("session")
public class DeneyimBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private transient DeneyimService deneyimService;
	private Deneyim deneyim;
	List<Deneyim> deneyimList;
	private String mesaj;
	
	@PostConstruct
	public void init() {
		System.out.println("deneyimBean construct");
		deneyimService=new DeneyimService();	
		deneyimList=deneyimService.getAll();
	}
	public void kaydet() {
		System.out.println(deneyim.toString());
		deneyimService.save(deneyim);
		deneyimList=deneyimService.getAll();
		mesaj="Deneyim kaydedildi";
		deneyim=new Deneyim();

	}
	
	public void sil(Long id) {
		Deneyim entity=deneyimService.getById(id);
		deneyimService.delete(entity);
		deneyimList=deneyimService.getAll();
	}
	
	public Deneyim getDeneyim() {
		if(deneyim==null){
			deneyim= new Deneyim();
		}
		return deneyim;
	}
	public void setDeneyim(Deneyim deneyim) {
		this.deneyim = deneyim;
	}
	public List<Deneyim> getDeneyimList() {
		return deneyimList;
	}
	public void setDeneyimList(List<Deneyim> deneyimList) {
		this.deneyimList = deneyimList;
	}
	public String getMesaj() {
		return mesaj;
	}
	public void setMesaj(String mesaj) {
		this.mesaj = mesaj;
	}
	
	

}