package fr.eseo.jee;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Assert;
import org.junit.Test;

public class TestGestionVisites {
	
	//static final String DB_ADRESSE = "localhost";
	static final String DB_ADRESSE = "192.168.4.197";

	@Test
	public void testTrouverVisite() {
		fail("Not yet implemented");
	}

	@Test
	public void testReserverVisite() {
		fail("Not yet implemented");
	}

	@Test
	public void testPayerVisite() {
		GestionVisites gv = new GestionVisites();
		
		gv.payerVisite("12345");
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection conn = DriverManager
					.getConnection("jdbc:mysql://" + DB_ADRESSE + "/GestionnaireVisites?user=admin&password=admin");

			Statement stmt = conn.createStatement();

			// Attributs de la réservation

			String query = "SELECT * FROM Reservations WHERE codeReservation='12345'";
			stmt.executeQuery(query);
			ResultSet res = stmt.getResultSet();
			
			while (res.next())
			{
				System.out.println(res.getBoolean("booleenPaiementEffectue"));
				Assert.assertTrue("La réservation a bien été payée !", res.getBoolean("booleenPaiementEffectue"));
			}
			
			res.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testAnnulerVisite() {
		fail("Not yet implemented");
	}

}
