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

import org.apache.commons.lang3.StringUtils;

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
		Visite visite = new Visite();
		
		if (!request.getParameter("nomVille").equals("")) {
			ville = request.getParameter("nomVille");
			visite.setVille(ville);
		}
		if (!request.getParameter("typeVisite").equals("")) {
			type = StringUtils.stripAccents(request.getParameter("typeVisite"));
			visite.setTypeVisite(type);
		}
		if (!request.getParameter("prixVisite").equals("")) {
			prix = Double.valueOf(request.getParameter("prixVisite"));
			visite.setPrix(prix);
		}
		if (!request.getParameter("dateVisite").equals("")) {
			date = request.getParameter("dateVisite");
			visite.setDateVisite(date);
		}
		if (!request.getParameter("codeVisite").equals("")) {
			code = request.getParameter("codeVisite");
			visite.setCodeVisite(code);
		}
		
		GestionVisitesService service = new GestionVisitesService();
		SEIGestionVisites port = service.getGestionVisitesPort();
		
		List<Visite> listeVisite = port.trouverVisite(visite);
		List<String> strVisites = new ArrayList<String>();
		String resPhrase;
		
		if(listeVisite.isEmpty()) {
			resPhrase = "Pas de visites disponibles.";
		}else {
			/**
			for (int i = 0; i < listeVisite.size(); i++) {
				String strInter = "Ville : ";
				strInter += listeVisite.get(i).getVille();
				strInter += " | Type Visite : ";
			    strInter += listeVisite.get(i).getTypeVisite();
				strInter += " | Prix : ";
			    strInter += String.valueOf(listeVisite.get(i).getPrix());
				strInter += " | Date : ";
			    strInter += listeVisite.get(i).getDateVisite();
			    strInter += " | Code Visite : ";
			    strInter += listeVisite.get(i).getCodeVisite();
			    strVisites.add(strInter);
			}
			*/
			resPhrase = "Voici les visites disponibles :";
		}
		
		session.setAttribute("resPhrase", resPhrase);
		//session.setAttribute("resListe", strVisites);
		session.setAttribute("test", listeVisite);
		
		RequestDispatcher dispReq = request.getRequestDispatcher("ListeVisite.jsp");
		dispReq.forward(request, response);
	}

}
