package com.journaldev.prime.faces.beans;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="welcomeBean")
@RequestScoped
public class WelcomeBeans {
	
	
	public void logout()
	{
		
		try {
			System.out.println("Logout!");
			FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
