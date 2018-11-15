package com.formation.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.formation.jpa.bean.Film;



public class FilmDAO{

	
	public void add(Film f) throws Exception{
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.persist(f);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			throw e;
		}
		finally {
			em.close();
		}
	}

	public void delete(Film f) throws Exception{
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		f = em.find(Film.class, f.getId());
		et.begin();
		try {
			em.remove(f);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			throw e;
		}
		finally {
			em.close();
		}
	}

	public  void update(Film f) throws Exception{
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.merge(f);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			throw e;
		}
		finally {
			em.close();
		}
	}
	


	public Film findById(int id){
		EntityManager em = DAOUtil.getEntityManager();
		Film f = em.find(Film.class, id);
		em.close();
		return f;
	}
	
	public  List<Film> findAll(){
		String req = "select Object(f) from Film f";
		EntityManager em = DAOUtil.getEntityManager();
		List<Film> liste = em
				.createQuery(req, Film.class)
				.getResultList();
		em.close();
		
		return liste;
	}


}
