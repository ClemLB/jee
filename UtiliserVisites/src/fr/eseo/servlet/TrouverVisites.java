package fr.eseo.servlet;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eseo.jee.GestionVisitesService;
import fr.eseo.jee.SEIGestionVisites;
import fr.eseo.jee.Visite;

/**
 * Servlet implementation class TrouverVisites
 */
@WebServlet("/TrouverVisites")
public class TrouverVisites extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrouverVisites() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String ville;
		String type;
		Double prix;
		String date;
		String code;
		
		if (request.getParameter("nomVille").equals("")) {
			ville = null;
		}else {
			ville = request.getParameter("nomVille");
		}
		if (request.getParameter("typeVisite").equals("")) {
			type = null;
		}else {
			type = request.getParameter("typeVisite");
		}
		if (request.getParameter("prixVisite").equals("")) {
			prix = null;
		}else {
			prix = Double.valueOf(request.getParameter("prixVisite"));
		}
		if (request.getParameter("dateVisite").equals("")) {
			date = null;
		}else {
			date = request.getParameter("dateVisite");
		}
		if (request.getParameter("codeVisite").equals("")) {
			code = null;
		}else {
			code = request.getParameter("codeVisite");
		}
		
		
		//String ville = request.getParameter("nomVille");
		//String type = request.getParameter("typeVisite");
		//Double prix = Double.valueOf(request.getParameter("prixVisite"));
		//String date = request.getParameter("dateVisite");
		//String code = request.getParameter("codeVisite");
		
		
		GestionVisitesService service = new GestionVisitesService();
		SEIGestionVisites port = service.getGestionVisitesPort();
		
		Visite visite = new Visite();
		visite.setVille(ville);
		visite.setTypeVisite(type);
		visite.setPrix(prix);
		visite.setDateVisite(date);
		visite.setCodeVisite(code);
		
		List<Visite> listeVisite = port.trouverVisite(visite);
		
		session.setAttribute("resListe", listeVisite);
		
		RequestDispatcher dispReq = request.getRequestDispatcher("ListeVisite.jsp");
		dispReq.forward(request, response);
	}

}
