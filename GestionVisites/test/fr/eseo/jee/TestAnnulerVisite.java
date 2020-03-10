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

import com.mysql.cj.jdbc.Driver;

public class TestAnnulerVisite {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			DriverManager.registerDriver(new Driver());
			Connection conn = DriverManager.getConnection("jdbc:mysql://" + AllTests.DB_ADRESSE
					+ "/GestionnaireVisites?user=" + AllTests.USERNAME + "&password=" + AllTests.PASSWORD);

			Statement stmt = conn.createStatement();

			// Création d'une visite de test
			String query = "INSERT INTO Visites(typeVisite, ville, dateVisite, prixVisite, idVisite, codeVisite) VALUES ('test', 'angers', '2020-04-29', '9.99', '777', 'teangers042920')";
			stmt.executeUpdate(query);
			stmt.close();

			// Création d'une réservation de test
			stmt = conn.createStatement();
			query = "INSERT INTO Reservations(idVisite, idClient, nombreplaces, booleenPaiementEffectue, codeReservation) VALUES ('777', '1', '3', '0', 'test1')";
			stmt.executeUpdate(query);
			stmt.close();

			// Création d'une réservation de test
			stmt = conn.createStatement();
			query = "INSERT INTO Reservations(idVisite, idClient, nombreplaces, booleenPaiementEffectue, codeReservation) VALUES ('777', '1', '3', '1', 'test2')";
			stmt.executeUpdate(query);
			stmt.close();

			// Création d'une réservation de test
			stmt = conn.createStatement();
			query = "INSERT INTO Reservations(idVisite, idClient, nombreplaces, booleenPaiementEffectue, codeReservation) VALUES ('777', '2', '3', '1', 'test3')";
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
			DriverManager.registerDriver(new Driver());
			Connection conn = DriverManager.getConnection("jdbc:mysql://" + AllTests.DB_ADRESSE
					+ "/GestionnaireVisites?user=" + AllTests.USERNAME + "&password=" + AllTests.PASSWORD);

			Statement stmt;

			// Suppression d'une réservation de test
			stmt = conn.createStatement();
			String query = "DELETE FROM Reservations WHERE codeReservation = 'test1'";
			stmt.executeUpdate(query);
			stmt.close();

			// Suppression d'une réservation de test
			stmt = conn.createStatement();
			query = "DELETE FROM Reservations WHERE codeReservation = 'test2'";
			stmt.executeUpdate(query);
			stmt.close();

			// Suppression d'une réservation de test
			stmt = conn.createStatement();
			query = "DELETE FROM Reservations WHERE codeReservation = 'test3'";
			stmt.executeUpdate(query);
			stmt.close();

			// Suppression d'une visite de test
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
	public void testAnnulerVisiteExistanteNonPayee() {
		GestionVisites gv = new GestionVisites();

		boolean answer = gv.annulerVisite("test1", 1);

		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection conn = DriverManager.getConnection("jdbc:mysql://" + AllTests.DB_ADRESSE
					+ "/GestionnaireVisites?user=" + AllTests.USERNAME + "&password=" + AllTests.PASSWORD);

			Statement stmt = conn.createStatement();

			// Attributs de la réservation

			String query = "SELECT COUNT(*) FROM Reservations WHERE codeReservation='test1'";
			stmt.executeQuery(query);
			ResultSet res = stmt.getResultSet();
			res.next();

			Assert.assertEquals("La réservation a bien été supprimée de la db !", 0, res.getInt(1));

			Assert.assertTrue("Visite supprimée !", answer);

			res.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testAnnulerVisiteExistantePayee() {
		GestionVisites gv = new GestionVisites();

		boolean answer = gv.annulerVisite("test2", 1);

		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection conn = DriverManager.getConnection("jdbc:mysql://" + AllTests.DB_ADRESSE
					+ "/GestionnaireVisites?user=" + AllTests.USERNAME + "&password=" + AllTests.PASSWORD);

			Statement stmt = conn.createStatement();

			// Attributs de la réservation

			String query = "SELECT COUNT(*) FROM Reservations WHERE codeReservation='test2'";
			stmt.executeQuery(query);
			ResultSet res = stmt.getResultSet();

			res.next();
			Assert.assertEquals("La réservation a bien été supprimée de la db !", 0, res.getInt(1));

			Assert.assertTrue("Visite supprimée !", answer);

			res.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testAnnulerVisiteAutreUtilisateur() {
		GestionVisites gv = new GestionVisites();

		boolean answer = gv.annulerVisite("test3", 1);

		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection conn = DriverManager.getConnection("jdbc:mysql://" + AllTests.DB_ADRESSE
					+ "/GestionnaireVisites?user=" + AllTests.USERNAME + "&password=" + AllTests.PASSWORD);

			Statement stmt = conn.createStatement();

			// Attributs de la réservation

			String query = "SELECT COUNT(*) FROM Reservations WHERE codeReservation='test3'";
			stmt.executeQuery(query);
			ResultSet res = stmt.getResultSet();

			res.next();
			Assert.assertEquals("La réservation d'un autre utilisateur n'a pas été supprimée !", 1, res.getInt(1));

			Assert.assertFalse("Visite non supprimée !", answer);

			res.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testAnnulerVisiteNonExistante() {
		GestionVisites gv = new GestionVisites();

		boolean answer = gv.annulerVisite("testNonExistante", 1);
		Assert.assertFalse("La visite n'existe pas !", answer);

	}

}
