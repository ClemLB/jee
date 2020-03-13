package fr.eseo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eseo.jee.visite.GestionVisitesService;

/**
 * Servlet implementation class PayerVisite
 */
@WebServlet("/PayerVisite")
public class PayerVisite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayerVisite() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String codeReservation = request.getParameter("codeReservation");
		HttpSession session = request.getSession();
		
		GestionVisitesService client = new GestionVisitesService();
		
		String answer = client.getGestionVisitesPort().payerVisite(codeReservation);
		session.setAttribute("resultat", answer);
		session.setAttribute("codeReservation", codeReservation);
		RequestDispatcher rd = request.getRequestDispatcher("ConfirmationPaiement.jsp");
		rd.forward(request, response);
	}

}
