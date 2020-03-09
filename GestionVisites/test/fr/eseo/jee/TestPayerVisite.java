package fr.eseo.jee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestPayerVisite {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			// Création d'une visite de test
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection conn = DriverManager
					.getConnection("jdbc:mysql://" + AllTests.DB_ADRESSE + "/GestionnaireVisites?user="+ AllTests.USERNAME +"&password="+ AllTests.PASSWORD);

			Statement stmt = conn.createStatement();

			String query = "INSERT INTO Visites(typeVisite, ville, dateVisite, prixVisite, idVisite, codeVisite) VALUES ('test', 'angers', '2020-04-29', '9.99', '777', 'teangers042920')";
			stmt.executeUpdate(query);
			stmt.close();
			
			stmt = conn.createStatement();
			query = "INSERT INTO Reservations(idVisite, idClient, nombreplaces, booleenPaiementEffectue, codeReservation) VALUES ('777', '1', '3', '0', 'test1')";
			stmt.executeUpdate(query);
			stmt.close();
			
			stmt = conn.createStatement();
			query = "INSERT INTO Reservations(idVisite, idClient, nombreplaces, booleenPaiementEffectue, codeReservation) VALUES ('777', '1', '3', '1', 'test2')";
			stmt.executeUpdate(query);
			stmt.close();
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		try {
			// Création d'une visite de test
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection conn = DriverManager
					.getConnection("jdbc:mysql://" + AllTests.DB_ADRESSE + "/GestionnaireVisites?user="+ AllTests.USERNAME +"&password="+ AllTests.PASSWORD);

			Statement stmt = conn.createStatement();

			String query = "DELETE FROM Reservations WHERE codeReservation = 'test2'";
			stmt.executeUpdate(query);
			stmt.close();
			
			stmt = conn.createStatement();
			query = "DELETE FROM Reservations WHERE codeReservation = 'test1'";
			stmt.executeUpdate(query);
			stmt.close();
			
			stmt = conn.createStatement();
			query = "DELETE FROM Visites WHERE idVisite = '777'";
			stmt.executeUpdate(query);
			stmt.close();
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testPayerVisiteExistanteNonPayee() {
		GestionVisites gv = new GestionVisites();
		
		String answer = gv.payerVisite("test1");
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection conn = DriverManager
					.getConnection("jdbc:mysql://" + AllTests.DB_ADRESSE + "/GestionnaireVisites?user="+ AllTests.USERNAME +"&password="+ AllTests.PASSWORD);

			Statement stmt = conn.createStatement();

			// Attributs de la réservation

			String query = "SELECT * FROM Reservations WHERE codeReservation='test1'";
			stmt.executeQuery(query);
			ResultSet res = stmt.getResultSet();
			
			while (res.next())
			{
				Assert.assertTrue("La réservation a bien été payée !", res.getBoolean("booleenPaiementEffectue"));
			}
			
			Assert.assertEquals("Les messages de retour sont identiques", "Paiement effectué !", answer);
			
			res.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testPayerVisiteExistantePayee() {
		GestionVisites gv = new GestionVisites();
		
		String answer = gv.payerVisite("test2");
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection conn = DriverManager
					.getConnection("jdbc:mysql://" + AllTests.DB_ADRESSE + "/GestionnaireVisites?user="+ AllTests.USERNAME +"&password="+ AllTests.PASSWORD);

			Statement stmt = conn.createStatement();

			// Attributs de la réservation

			String query = "SELECT * FROM Reservations WHERE codeReservation='test2'";
			stmt.executeQuery(query);
			ResultSet res = stmt.getResultSet();
			
			while (res.next())
			{
				Assert.assertTrue("La réservation est bien payée !", res.getBoolean("booleenPaiementEffectue"));
			}
			
			Assert.assertEquals("Les messages de retour sont identiques", "Paiement impossible !", answer);
			
			res.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testPayerVisiteNonExistante() {
		GestionVisites gv = new GestionVisites();
		
		String answer = gv.payerVisite("testNonExistante");
		Assert.assertEquals("Les messages de retour sont identiques", "Paiement impossible !", answer);
		
	}

}
