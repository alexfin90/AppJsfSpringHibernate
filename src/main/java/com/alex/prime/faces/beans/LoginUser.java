package com.alex.prime.faces.beans;

import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.alex.jpa.data.Users;
import com.alex.spring.service.UsersHome;

@ManagedBean
@SessionScoped
public class LoginUser {

	@ManagedProperty("#{usersHome}")
	private UsersHome usersHome;

	private String username;
	private String password;

	public void login() {

		boolean value = false;

		Users u = usersHome.findById(username);
		if (u != null && u.getPassword().compareTo(password) == 0)
			value = true;

		if (u == null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Utente non presente!"));
		} else if (u != null && value==true) {

			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("welcome.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (u != null && value == false) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("password errata!"));
		}

	}

	public void logout() {

		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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

	public UsersHome getUsersHome() {
		return usersHome;
	}

	public void setUsersHome(UsersHome usersHome) {
		this.usersHome = usersHome;
	}

}
