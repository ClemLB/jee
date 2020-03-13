package fr.eseo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.joda.time.LocalDate;

import fr.eseo.jee.taxi.GestionTaxiService;
import fr.eseo.jee.taxi.SEITaxi;
import fr.eseo.jee.taxi.Taxi;

/**
 * Servlet implementation class TrouverTaxis
 */
@WebServlet("/TrouverTaxis")
public class TrouverTaxis extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrouverTaxis() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		String date;
		String ville;
		String categorie;
		
		Taxi taxi = new Taxi();
		
		if (!request.getParameter("ville").equals("")) {
			ville = request.getParameter("date");
			taxi.setVille(ville);
		}
		
		if (!request.getParameter("categorie").equals("")) {
			categorie = request.getParameter("categorie");
			taxi.setCategorie(categorie);
		}
		
		if (!request.getParameter("date").equals("")) {
			date = request.getParameter("date");
		} else {
			date = LocalDate.now().toString();
		}
		
		GestionTaxiService service = new GestionTaxiService();
		SEITaxi port = service.getGestionTaxiPort();
		
		List<Taxi> listeTaxis = port.trouverTaxi(taxi, date);
		String resPhrase;
		
		if(listeTaxis.isEmpty()) {
			resPhrase = "Pas de taxis disponibles.";
		}else {
			resPhrase = "Voici les visites disponibles :";
		}
		
		session.setAttribute("resPhrase", resPhrase);
		//session.setAttribute("resListe", strVisites);
		session.setAttribute("listeTaxis", listeTaxis);
		
		RequestDispatcher dispReq = request.getRequestDispatcher("ListeTaxis.jsp");
		dispReq.forward(request, response);
	}

}
