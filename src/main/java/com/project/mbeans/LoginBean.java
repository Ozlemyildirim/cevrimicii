package com.project.mbeans;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.project.entity.Kullanici;
import com.project.service.KullaniciService;

@Controller("loginBean")
@Scope("session")
public class LoginBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5684303049190985275L;

	/**
	 * 
	 */
	

	@Autowired
	private transient KullaniciService kullaniciService;
	
	private String username;
	private String password;
	
	public void logIn() {

		Kullanici kullanici = kullaniciService.getUserByUsernameAndPwd(username, password);
		if(kullanici!=null && kullanici.getId()!=null){			
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			session.setAttribute("user", Boolean.TRUE);
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("/CevrimiciPortal/secure/kullanici.xhtml?faces-redirect=true");	
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void logOut() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.invalidate();
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/Dersane/login.xhtml?faces-redirect=true");	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
}