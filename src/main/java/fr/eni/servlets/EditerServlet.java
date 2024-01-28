package fr.eni.servlets;

import java.io.IOException;
import java.util.List;

import fr.eni.beans.Voiture;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EditerServlet")
public class EditerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1-Lecture de l'identifiant à editer
		String immatriculation = request.getParameter("immatriculation");
		
		// 2-Rechercher de la voiture à editer
		Voiture voitureAEditer = new Voiture();
		voitureAEditer.setImmatriculation(immatriculation);
		List<Voiture> voitures = (List<Voiture>) this.getServletContext().getAttribute("voitures");
		voitureAEditer = voitures.get(voitures.indexOf(voitureAEditer));
		
		// 3-Transferer la requete à la jsp editerVoiture.jsp
		request.setAttribute("voitureAEditer", voitureAEditer);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/editerVoiture.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1-Lecture de l'identifiant à editer
		String immatriculation = request.getParameter("immatriculation");
		
		// 2-Rechercher de la voiture à editer
		Voiture voitureAEditer = new Voiture();
		voitureAEditer.setImmatriculation(immatriculation);
		List<Voiture> voitures = (List<Voiture>) this.getServletContext().getAttribute("voitures");
		voitureAEditer = voitures.get(voitures.indexOf(voitureAEditer));
		
		// 3-Modification de la voiture
		voitureAEditer.setMarque(request.getParameter("marque"));
		voitureAEditer.setModele(request.getParameter("modele"));
		voitureAEditer.setKilometrage(request.getParameter("kilometrage"));
		voitureAEditer.setAnnee(Integer.parseInt(request.getParameter("annee")));
		
		// 4-Redirection vers la servlet ListerServlet 
		response.sendRedirect(request.getContextPath()+"/ListerServlet");
	}

}
