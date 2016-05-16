package com.alex.spring.service;

import java.util.List;

// default package
// Generated May 16, 2016 12:53:11 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.alex.jpa.data.Users;

/**
 * Home object for domain model class Users.
 * 
 * @see .Users
 * @author Hibernate Tools
 */
@Component
public class UsersHome {

	private static final Log log = LogFactory.getLog(UsersHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void persist(Users transientInstance) {
		log.debug("persisting Users instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
			System.out.println("salvato");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Users persistentInstance) {
		log.debug("removing Users instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Users merge(Users detachedInstance) {
		log.debug("merging Users instance");
		try {
			Users result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Users findById(String id) {
		log.debug("getting Users instance with id: " + id);
		try {
			Users instance = entityManager.find(Users.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Users> getUsers() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select u from Users u ", Users.class).getResultList();

	}
}
