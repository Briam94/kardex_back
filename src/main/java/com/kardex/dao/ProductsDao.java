package com.kardex.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.kardex.entities.Products;

@Repository
public class ProductsDao extends AbstractDao<Products> {

	@PersistenceContext
	private EntityManager em;
	
	public ProductsDao() {
		super(Products.class);
	}
	
	@Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
