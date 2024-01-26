package fr.eni.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.eni.beans.Voiture;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AjouterServlet")
public class AjouterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// private List<Voiture> voitures;

	@Override
	public void init() throws ServletException {
		// this.voitures = new ArrayList<>();
		getServletContext().setAttribute("voitures", Collections.synchronizedList(new ArrayList<>()));
		super.init();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/ajouterVoiture.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 0-Utilisation encodage UTF-8 pour la lecture
		response.setCharacterEncoding("UTF-8");

		// 1-Lecture des entêtes de la requete
		String contentType = request.getContentType();

		// 2-Lecture des paramètres
		String marque = request.getParameter("marque");
		String modele = request.getParameter("modele");
		String kilometrage = request.getParameter("kilometrage");
		String immatriculation = request.getParameter("immatriculation");
		int annee = Integer.parseInt(request.getParameter("annee"));
		
		List<Voiture> voitures = (List<Voiture>) request.getServletContext().getAttribute("voitures");

		voitures.add(new Voiture(marque, modele, kilometrage, immatriculation, annee));

		/* RequestDispatcher rd = request.getRequestDispatcher("/ListerServlet");
		rd.forward(request, response); */
		
		response.sendRedirect(request.getContextPath()+ "/ListerServlet");
	}

}
