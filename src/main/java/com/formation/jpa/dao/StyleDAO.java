package com.formation.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.formation.jpa.bean.Style;



public class StyleDAO{

	
	public void add(Style s) throws Exception{
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.persist(s);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			throw e;
		}
		finally {
			em.close();
		}
	}

	public void delete(Style s) throws Exception{
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		s = em.find(Style.class, s.getId());
		et.begin();
		try {
			em.remove(s);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			throw e;
		}
		finally {
			em.close();
		}
	}

	public  void update(Style s) throws Exception{
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.merge(s);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			throw e;
		}
		finally {
			em.close();
		}
	}
	


	public Style findById(int id){
		EntityManager em = DAOUtil.getEntityManager();
		Style s = em.find(Style.class, id);
		em.close();
		return s;
	}
	
	public  List<Style> findAll(){
		String req = "select Object(s) from Style s";
		EntityManager em = DAOUtil.getEntityManager();
		List<Style> liste = em
				.createQuery(req, Style.class)
				.getResultList();
		em.close();
		
		return liste;
	}


}
