package com.alex.prime.faces.beans;
import java.io.Serializable;
import com.alex.jpa.data.Users;
import com.alex.spring.service.UsersHome;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import java.util.List;

@ManagedBean
@ViewScoped
public class DataView implements Serializable{

	
	@ManagedProperty("#{usersHome}")
    private UsersHome userHome;
	
	private List<Users> user;
	
	
	@PostConstruct
    public void init() {
        user = userHome.getUsers();
    }
	
	
	    public List<Users> getUsers() {
		return user;
	}


		public UsersHome getUserHome() {
			return userHome;
		}


		public void setUserHome(UsersHome userHome) {
			this.userHome = userHome;
		}



		


	
	
	
	
	
	
}
