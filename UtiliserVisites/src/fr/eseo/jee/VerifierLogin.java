package fr.eseo.jee;

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
	// static final String DB_ADRESSE = "192.168.4.197";
	static final String DB_ADRESSE = "localhost";

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

			Connection connection = DriverManager
					.getConnection("jdbc:mysql://" + DB_ADRESSE + "/GestionnaireVisites?user=root&password=network");

			Statement stmt = connection.createStatement();

			String sql = "Select * from GestionnaireVisites.Clients WHERE `email`=\"" + email + "\" and motDePasse=\""
					+ password + "\" ";
			System.out.println(sql);

			ResultSet rset = stmt.executeQuery(sql);

			Client client = new Client();
			while (rset.next()) {
				System.out.println(rset.getString("idClient"));
				client.setIdClient(Integer.valueOf(rset.getString("idClient")));
				client.setEmail(rset.getString("email"));
				client.setNom(rset.getString("nom"));
				client.setPrenom(rset.getString("prenom"));
			}
			
			System.out.println(client.getIdClient());

			session.setAttribute("client", client);
			rset.close();
			stmt.close();
			connection.close();

			RequestDispatcher dispt = request.getRequestDispatcher("index.html");
			dispt.forward(request, response);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
