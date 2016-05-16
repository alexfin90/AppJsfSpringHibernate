package com.journaldev.spring.service;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.springframework.stereotype.Component;

import com.journaldev.jpa.data.Nazione;



@ManagedBean(name="nazioneService", eager = true)
@ApplicationScoped
@Component
public class NazioneService {
	
	private List<Nazione> listanazioni;
	
	public NazioneService() {
		// TODO Auto-generated constructor stub
		System.out.println("Costruttore Nazione Service");
	}
	
	 @PostConstruct
	    public void init() {
		 
		 	System.out.println("Post Construct / Nazione Service");
		   	listanazioni = new ArrayList<Nazione>();
	        listanazioni.add(new Nazione("it-ITA", "IT",  "Italia"));
	        listanazioni.add(new Nazione("us-ENG", "US", "United States"));
	        listanazioni.add(new Nazione("en-ENG" ,"EN",  "England"));
	    }

	public List<Nazione> getListanazioni() {
				return listanazioni;
	}
	
	public Nazione getNazione(String id){
		Nazione tmp= new Nazione();
		tmp.setId(id);
		int i = listanazioni.indexOf(tmp);
		return listanazioni.get(i);	
	}
	
}
