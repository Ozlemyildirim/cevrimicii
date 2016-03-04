package com.project.mbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.project.entity.›lan;
import com.project.service.›lanService;


@Controller("ilanBean")
@Scope("session")
public class ›lanBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private transient ›lanService ilanService;
	private ›lan ilan;
	List<›lan> ilanList;
	private String mesaj;
	
	@PostConstruct
	public void init() {
		System.out.println("ilanBean construct");
		ilanService=new ›lanService();	
		ilanList=ilanService.getAll();
	}
	public void kaydet() {
		System.out.println(ilan.toString());
		ilanService.save(ilan);
		ilanList=ilanService.getAll();
		mesaj="›lan kaydedildi";
		ilan=new ›lan();

	}
	
	public void sil(Long id) {
		›lan entity=ilanService.getById(id);
		ilanService.delete(entity);
		ilanList=ilanService.getAll();
	}
	
	public ›lan get›lan() {
		if(ilan==null){
			ilan= new ›lan();
		}
		return ilan;
	}
	public void set›lan(›lan ilan) {
		this.ilan = ilan;
	}
	public List<›lan> get›lanList() {
		return ilanList;
	}
	public void set›lanList(List<›lan> ilanList) {
		this.ilanList = ilanList;
	}
	public String getMesaj() {
		return mesaj;
	}
	public void setMesaj(String mesaj) {
		this.mesaj = mesaj;
	}
	
	

}