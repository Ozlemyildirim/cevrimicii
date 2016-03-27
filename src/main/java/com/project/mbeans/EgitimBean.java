package com.project.mbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.ToggleEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.project.entity.Egitim;
import com.project.service.EgitimService;

@Controller("egitimBean")
@Scope("session")
public class EgitimBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private transient EgitimService egitimService;
	private Egitim egitim;
	List<Egitim> egitimList;
	private String mesaj;
	private String[] selectedEgitim;
	private List<String> egitimbilgisi;

	@PostConstruct
	public void init() {
		System.out.println("deneyimBean construct");
		egitimService = new EgitimService();
		egitimList = egitimService.getAll();
	}

	public void kaydet() {
		System.out.println(egitim.toString());

		if (this.egitim != null && this.egitim.getId() != null) {
			egitimService.update(egitim);
		} else {
			egitimService.save(egitim);
		}

		egitimList = egitimService.getAll();

		FacesContext.getCurrentInstance().addMessage("Kay�t",
				new FacesMessage("Egitim Kaydedildi"));
		egitim = new Egitim();
	}

	public void sil(Long id) {
		Egitim entity = egitimService.getById(id);
		egitimService.delete(entity);
		egitimList = egitimService.getAll();
		FacesContext.getCurrentInstance().addMessage("Kay�t",
				new FacesMessage("E�itim Silindi"));
	}

	public void duzenle(Long id) {
		Egitim entity = egitimService.getById(id);
		this.egitim = entity;
	}

	public void yeni() {
		this.egitim = new Egitim();
	}

	public Egitim getEgitim() {
		if (egitim == null) {
			egitim = new Egitim();
		}
		return egitim;
	}

	public void setEgitim(Egitim egitim) {
		this.egitim = egitim;
	}

	public List<Egitim> getEgitimList() {
		return egitimList;
	}

	public void setEgitimList(List<Egitim> egitimList) {
		this.egitimList = egitimList;
	}

	public String getMesaj() {
		return mesaj;
	}

	public void setMesaj(String mesaj) {
		this.mesaj = mesaj;
	}

	public String[] getSelectedEgitim() {
		return selectedEgitim;
	}

	public void setSelectedEgitim(String[] selectedEgitim) {
		this.selectedEgitim = selectedEgitim;
	}

	public List<String> getEgitimbilgisi() {
		return egitimbilgisi;
	}

	public void setEgitimbilgisi(List<String> egitimbilgisi) {
		this.egitimbilgisi = egitimbilgisi;
	}

	public class FieldsetView {

		public void handleToggle(ToggleEvent event) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Toggled", "Visibility:" + event.getVisibility());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

}