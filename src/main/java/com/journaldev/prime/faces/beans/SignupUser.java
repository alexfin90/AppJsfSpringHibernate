package com.journaldev.prime.faces.beans;
import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import com.journaldev.jpa.data.Nazione;
import com.journaldev.jpa.data.Users;
import com.journaldev.spring.service.NazioneService;
import com.journaldev.spring.service.UsersHome;


@ManagedBean
@SessionScoped
public class SignupUser {


	@ManagedProperty("#{usersHome}")
	private UsersHome usersHome;
	
	@ManagedProperty("#{nazioneService}")
	private NazioneService nazioneService;
	

	private String name;
	private String surname;
	private String address;
	private String username;
	private String password;
	
	
	private Nazione nazioneselezionata;
	private List<Nazione> listanazioni;
	
	
	@PostConstruct
	public void init(){
		listanazioni = nazioneService.getListanazioni();
	}
	
	
	public void save(){
		
		System.out.println("Salvo l'utente / nel db");
		
		Users u = new Users(username,name,surname,address,password);
		
		usersHome.persist(u);
		
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("riepilogo.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public UsersHome getUsersHome() {
		return usersHome;
	}

	public void setUsersHome(UsersHome usersHome) {
		this.usersHome = usersHome;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Nazione getNazioneselezionata() {
		return nazioneselezionata;
	}

	public void setNazioneselezionata(Nazione nazioneselezionata) {
		this.nazioneselezionata = nazioneselezionata;
	}

	public List<Nazione> getListanazioni() {
		return listanazioni;
	}

	public void setListanazioni(List<Nazione> listanazioni) {
		this.listanazioni = listanazioni;
	}
	public NazioneService getNazioneService() {
		return nazioneService;
	}


	public void setNazioneService(NazioneService nazioneService) {
		this.nazioneService = nazioneService;
	}
	
}
