package com.assessment.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.assessment.model.ProductStore;

public class ProductDao {
	
	private EntityManagerFactory entityManagerFactory;

	public void create(ProductStore ps) {

		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();

		em.getTransaction().begin();

		em.persist(ps);

		em.getTransaction().commit();
	}
	
	public ProductStore find(long id) {
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();
		
		ProductStore ps = em.find(ProductStore.class, id);
		
		return ps;
	}
	
	public List<ProductStore> findAll() {
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();

		List<ProductStore> products = em.createQuery("select s from Product s", ProductStore.class).getResultList();

		return products;
	}
	
	public ProductStore update(long prodid, String prodname,int prodprice,int prodquantity) {
		
		entityManagerFactory=HibernateOGMUtil.getEntityManagerFactory();
		EntityManager em=entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		
		ProductStore ps1=em.find(ProductStore.class, prodid);
		ps1.setProdname(prodname);
		ps1.setProdprice(prodprice);
		ps1.setProdquant(prodquantity);
		em.getTransaction().commit();
		return ps1;
	}
	public void delete(ProductStore ps) {
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();
		
		em.getTransaction().begin();
		
		em.remove(em.contains(ps) ? ps : em.merge(ps));
		
		em.getTransaction().commit();
	}
	public void delete(long prodid) {
		entityManagerFactory = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = entityManagerFactory.createEntityManager();
		
		em.getTransaction().begin();
		
		em.remove(em.find(ProductStore.class, prodid));
		
		em.getTransaction().commit();
	}
	

}
