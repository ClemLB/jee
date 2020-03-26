package fr.eseo.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreerUtilisateur
 */
@WebServlet("/CreerUtilisateur")
public class CreerUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final String DB_ADRESSE = "localhost";
	static final String DB_LOGIN = "root";
	static final String DB_MDP = "network";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreerUtilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String motDePasse = request.getParameter("motDePasse");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");

		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://" + DB_ADRESSE + "/ClientsVisites?user=" + DB_LOGIN + "&password=" + DB_MDP);

			Statement stmt = connection.createStatement();
			String resultEmail = "";

			String sqlSelect = "Select email from ClientsVisites.Clients WHERE `email`=\"" + email + "\"";
			
			String sqlInsert = "INSERT INTO ClientsVisites.Clients (prenom, nom, email, motDePasse)\n" + 
					" VALUES (\"" + prenom + "\", \"" + nom + "\", \"" + email + "\", \"" + motDePasse + "\")";

			ResultSet rset = stmt.executeQuery(sqlSelect);

			while(rset.next()) {
				resultEmail = rset.getString("email");
			}
				
			if(resultEmail.isEmpty()) {
				stmt.executeUpdate(sqlInsert);

				stmt.close();
				connection.close();

				RequestDispatcher dispt = request.getRequestDispatcher("confirmationCreationCompte.html");
				dispt.forward(request, response);

			}else {

				stmt.close();
				connection.close();

				RequestDispatcher dispt = request.getRequestDispatcher("inscription.html");
				dispt.forward(request, response);
				
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
