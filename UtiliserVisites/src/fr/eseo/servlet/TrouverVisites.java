package fr.eseo.servlet;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		String ville = request.getParameter("nomVille");
		String type = request.getParameter("typeVisite");
		Double prix = Double.valueOf(request.getParameter("prixVisite"));
		String date = request.getParameter("dateVisite");
		String code = request.getParameter("codeVisite");
		
		Visite visite = new Visite();
		visite.setVille(ville);
		visite.setTypeVisite(type);
		visite.setPrix(prix);
		visite.setDateVisite(date);
		visite.setCodeVisite(code);
		
		
		
		
		
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
		} catch (SQLException e) {
			
		}
		
	}

}
