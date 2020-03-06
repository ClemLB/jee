package fr.eseo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eseo.jee.GestionVisitesService;
import fr.eseo.jee.SEIGestionVisites;
import fr.eseo.login.Client;

/**
 * Servlet implementation class AnnulerVisite
 */
@WebServlet("/AnnulerVisite")
public class AnnulerVisite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AnnulerVisite() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int idClient = ((Client) session.getAttribute("client")).getIdClient();
		//TODO Vérifier que le client qui annule est celui qui a passé la réservation
		//TODO Annuler la réservation
		GestionVisitesService service = new GestionVisitesService();
		SEIGestionVisites port = service.getGestionVisitesPort();
	}

}
