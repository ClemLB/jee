package fr.eseo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eseo.jee.GestionVisitesService;
import fr.eseo.jee.SEIGestionVisites;

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
		int idClient = (int) session.getAttribute("clientID");

		GestionVisitesService service = new GestionVisitesService();
		SEIGestionVisites port = service.getGestionVisitesPort();
		// boolean res = port.annulerVisite(request.getParameter("codeRes"), idClient);
		boolean res = port.annulerVisite(request.getParameter("codeRes"));
		session.setAttribute("resultat", res);
		RequestDispatcher dispt = request.getRequestDispatcher("ConfirmationAnnulation.jsp");
		dispt.forward(request, response);
	}
}
