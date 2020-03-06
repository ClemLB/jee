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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class VerifierLogin
 */
@WebServlet("/VerifierLogin")
public class VerifierLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final String DB_ADRESSE = "192.168.4.197";
	static final String DB_LOGIN = "java";
	static final String DB_MDP = "network";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VerifierLogin() {
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
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://" + DB_ADRESSE + "/GestionnaireVisites?user=" + DB_LOGIN + "&password=" + DB_MDP);

			Statement stmt = connection.createStatement();

			String sql = "Select * from GestionnaireVisites.Clients WHERE `email`=\"" + email + "\" and motDePasse=\""
					+ password + "\" ";

			ResultSet rset = stmt.executeQuery(sql);

			Client client = new Client();

			while (rset.next()) {

				client.setIdClient(Integer.valueOf(rset.getString("idClient")));
				client.setEmail(rset.getString("email"));
				client.setNom(rset.getString("nom"));
				client.setPrenom(rset.getString("prenom"));
			}

			session.setAttribute("client", client);
			rset.close();
			stmt.close();
			connection.close();

			if (client.getIdClient() == 0) {
				RequestDispatcher dispt = request.getRequestDispatcher("login.html");
				dispt.forward(request, response);
			} else {
				RequestDispatcher dispt = request.getRequestDispatcher("menu.html");
				dispt.forward(request, response);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
