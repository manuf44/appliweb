package com.formation.jpa.servlet.film;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.formation.jpa.bean.Acteur;
import com.formation.jpa.bean.Film;
import com.formation.jpa.bean.Realisateur;
import com.formation.jpa.bean.Style;
import com.formation.jpa.service.GestionFilm;
import com.formation.jpa.service.GestionStyle;

/**
 * Servlet implementation class AjouterServlet
 */
@WebServlet("/ajouter")
public class AjouterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionStyle gs = new GestionStyle();	
		request.setAttribute("listeStyles", gs.listeStyles());
		
		RequestDispatcher rd = request.getRequestDispatcher("ajouterFilm.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			GestionStyle gs = new GestionStyle();
			Style s = gs.trouverStyle(Integer.parseInt(request.getParameter("style")));
			
			Film f = new Film();
			f.setTitre(request.getParameter("titre"));
			f.setAnnee(Integer.parseInt(request.getParameter("annee")));
			f.setStyle(s);
			Realisateur r = new Realisateur();
			r.setNom(request.getParameter("real.nom"));
			r.setPrenom(request.getParameter("real.prenom"));
			f.setReal(r);
			f.setDuree(request.getParameter("duree"));
			f.setVu(Boolean.parseBoolean(request.getParameter("vu")));
			f.setSynopsis(request.getParameter("synopsis"));
			List<Acteur> listeA = new ArrayList<>();
			for (int i = 0; i < 5; i++) {
				String nom = request.getParameter("nom"+i).trim();
				String prenom = request.getParameter("prenom"+i).trim();
				if (!nom.equals("") || !prenom.equals(""))
					listeA.add(new Acteur(nom, prenom));
			}
			f.setActeurs(listeA);
			
			GestionFilm gf = new GestionFilm();
			gf.ajoutFilm(f);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("lister");
	}

}
