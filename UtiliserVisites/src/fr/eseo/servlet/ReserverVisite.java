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
import fr.eseo.jee.ReservationVisite;
import fr.eseo.jee.SEIGestionVisites;
import fr.eseo.jee.Visite;
import fr.eseo.login.Client;

/**
 * Servlet implementation class ReserverVisite
 */
@WebServlet("/ReserverVisite")
public class ReserverVisite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReserverVisite() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String codeVisite = request.getParameter("codeVis");
		int nombrePersonnes = Integer.valueOf(request.getParameter("nbrClient"));
		int clientID = (int) session.getAttribute("clientID");
		
		GestionVisitesService service = new GestionVisitesService();
		SEIGestionVisites port = service.getGestionVisitesPort();
		
		Visite visiteChoisie = new Visite();
		visiteChoisie.setCodeVisite(codeVisite);
		visiteChoisie = port.trouverVisite(visiteChoisie).get(0);
		
		ReservationVisite reservationVoulue = new ReservationVisite();
		reservationVoulue.setCodeVisite(visiteChoisie.getCodeVisite());
		reservationVoulue.setNbPersonnes(nombrePersonnes);
		reservationVoulue.setCodeClient(clientID);
		
		String reservation = port.reserverVisite(reservationVoulue);
		
		session.setAttribute("reservation", reservation);
		
		RequestDispatcher dispt = request.getRequestDispatcher("ConfirmationReservation.jsp");
		dispt.forward(request, response);
		
		
		
		
	}

}
