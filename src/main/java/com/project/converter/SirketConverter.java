package com.project.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.project.entity.Sirket;
import com.project.service.SirketService;

@Controller("sirketConverter")
@Scope("request")
public class SirketConverter implements Converter {

	@Autowired
	private transient SirketService sirketService;

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && value.trim().length() > 0
				&& !value.equals("Seçiniz")) {
			try {

				return sirketService.getById(Long.parseLong(value));
			} catch (NumberFormatException e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		if (object != null) {
			return String.valueOf(((Sirket) object).getId());
		} else {
			return null;
		}
	}
}
