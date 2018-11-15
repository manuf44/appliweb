package com.formation.jpa.service;

import java.util.List;

import com.formation.jpa.bean.Film;
import com.formation.jpa.dao.FilmDAO;

public class GestionFilm {

	FilmDAO dao;
	
	public GestionFilm(){
		dao = new FilmDAO();
	}
	
	public List<Film> listeFilms(){
		return dao.findAll();
	}
	
	public Film trouverFilm(int id){
		return dao.findById(id);
	}
	
	
	public void ajoutFilm(Film f) throws Exception{
		dao.add(f);
	}
	
	public void modifierFilm(Film f) throws Exception{
//		Film film = dao.findOne(f.getId());
//		film.setActeurs(f.getActeurs());
//		film.setAnnee(f.getAnnee());
//		film.setDuree(f.getDuree());
//		film.setReal(f.getReal());
//		film.setStyle(f.getStyle());
//		film.setSynopsis(f.getSynopsis());
//		film.setTitre(f.getTitre());
//		film.setVu(f.isVu());
//		dao.save(film);
		dao.update(f);
	}
	
	public void supprimerFilm(Film f) throws Exception{
		dao.delete(f);
	}
	
	public void supprimerFilm(int id) throws Exception{
		dao.delete(trouverFilm(id));
	}

	public List<Film> trier(String par) {
		List<Film> liste = null;
		
		switch (par) {
		default : liste = dao.findAll();

		}
		
		return liste;
	}
	
	
	
}
