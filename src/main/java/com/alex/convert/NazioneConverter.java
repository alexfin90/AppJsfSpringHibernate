package com.alex.convert;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.alex.jpa.data.Nazione;
import com.alex.spring.service.NazioneService;


@FacesConverter("nazioneConverter")
public class NazioneConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		// TODO Auto-generated method stub
		if (arg2 != null && arg2.trim().length() > 0) {
			System.out.println("GetAsObject: " + arg2);
			
			NazioneService ns = (NazioneService) FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get("nazioneService");
			return (Nazione) ns.getNazione(arg2);
		} else {
			return null;
		}

	}

	
	
	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		// TODO Auto-generated method stub

		System.out.println("convert with value: " + arg2);
		if (arg2 != null) {
			return String.valueOf(((Nazione) arg2).getId());
		} else {

			return null;
		}
	}

}
