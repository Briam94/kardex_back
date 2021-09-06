package com.kardex.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.kardex.entities.Users;

@Repository
public class UsersDao extends AbstractDao<Users> {
	
	@PersistenceContext
	private EntityManager em;
	
	public UsersDao() {
		super(Users.class);
	}
	
	@Override
    protected EntityManager getEntityManager() {
        return em;
    }
	
	public Users findByEmail(String email) {
		Users user = new Users();
		try {
			Query q = em.createQuery(
					"SELECT u  FROM Users u " + 
					"WHERE u.userEmail = :email")
					.setParameter("email", email);
			user =  (Users) q.getSingleResult();
		} catch (Exception e) {
			user = null;
			e.printStackTrace();
		}
		return user;
	}


}
