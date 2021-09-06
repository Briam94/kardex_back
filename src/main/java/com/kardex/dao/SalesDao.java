package com.kardex.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.kardex.entities.Sales;

@Repository
public class SalesDao extends AbstractDao<Sales> {

	@PersistenceContext
	private EntityManager em;
	
	public SalesDao() {
		super(Sales.class);
	}
	
	@Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
