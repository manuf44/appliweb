package com.formation.jpa.service;

import java.util.List;

import com.formation.jpa.bean.Style;
import com.formation.jpa.dao.StyleDAO;


public class GestionStyle {

	private StyleDAO dao;
	
	public GestionStyle(){
		dao = new StyleDAO();
	}
	
	public List<Style> listeStyles(){
		return dao.findAll();
	}
	
	
	public Style trouverStyle(int id){
		return dao.findById(id);
	}

	public void ajoutStyle(Style s) throws Exception{
		
		if (s.getLibelle() != null && !s.getLibelle().trim().equals(""))
			dao.add(s);
		else
			throw new Exception("...");
	}
	
	public void modifierStyle(Style s) throws Exception{
		dao.update(s);
	}
	
	public void supprimerStyle(Style s) throws Exception{
		dao.delete(s);
	}
	
	public void supprimerStyle(int id) throws Exception{
		Style s = dao.findById(id);
		dao.delete(s);
	}
	
	public List<Style> trier(String type){
		List<Style> liste = null;
		switch (type){
		default : liste = dao.findAll();
		}
		return liste;
	}
	
}
