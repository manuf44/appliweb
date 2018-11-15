package com.formation.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;



public class GenericDaoImpl<T, U> implements GenericDao<T, U>{

	
	public void add(T t) throws Exception{
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.persist(t);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			throw e;
		}
	}

	public void delete(T t) throws Exception{
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.remove(t);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			throw e;
		}
	}

	public  void update(T t) throws Exception{
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			em.merge(t);
			et.commit();
		} catch (Exception e) {
			et.rollback();
			throw e;
		}
	}
	
	public void update(List<T> listeT) throws Exception{
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		try {
			for (T t : listeT) {
				em.merge(t);
			}
			
			et.commit();
		} catch (Exception e) {
			et.rollback();
			throw e;
		}
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public T findById(Class c , U id){
		return (T) DAOUtil
				.getEntityManager()
				.find(c, id);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public  List<T> findAll(Class c){
		String req = "select Object(t) from "+ c.getName() + " t";
		return DAOUtil
				.getEntityManager()
				.createQuery(req, c)
				.getResultList();
	}

}
