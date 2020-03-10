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

public class TestReserverVisite {

	@BeforeClass
	public static void creationVisiteTest() {
		try {
			DriverManager.registerDriver(new Driver());
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://" + AllTests.DB_ADRESSE + "/GestionnaireVisites", AllTests.USERNAME,
					AllTests.PASSWORD);

			// Création d'une visite de test
			Statement stmt = conn.createStatement();
			String query = "INSERT INTO Visites(typeVisite, ville, dateVisite, prixVisite, codeVisite) VALUES ('test', 'angers', '2020-03-25', '29.99', 'teangers250320')";
			stmt.executeUpdate(query);

			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public static void supressionVisiteTest() {
		try {
			DriverManager.registerDriver(new Driver());
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://" + AllTests.DB_ADRESSE + "/GestionnaireVisites", AllTests.USERNAME,
					AllTests.PASSWORD);

			// Suppression d'une visite de test
			Statement stmt = conn.createStatement();
			String query = "DELETE FROM Visites WHERE codeVisite = 'teangers250320'";
			stmt.executeUpdate(query);

			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testReserverVisiteExiste() {
		ReservationVisite reservationTest = new ReservationVisite();
		reservationTest.setCodeVisite("teangers250320");
		reservationTest.setNbPersonnes(42);
		reservationTest.setCodeClient(1);
		GestionVisites gestion = new GestionVisites();
		String codeReservation = gestion.reserverVisite(reservationTest);

		int nbReservation = 0;

		try {
			DriverManager.registerDriver(new Driver());
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://" + AllTests.DB_ADRESSE + "/GestionnaireVisites", AllTests.USERNAME,
					AllTests.PASSWORD);

			Statement stmt = conn.createStatement();

			String query = "SELECT COUNT(*) FROM Reservations WHERE codeReservation = '" + codeReservation + "'";
			ResultSet rs = stmt.executeQuery(query);

			rs.next();
			nbReservation = rs.getInt(1);

			stmt.close();

			stmt = conn.createStatement();

			query = "DELETE FROM Reservations WHERE codeReservation = '" + codeReservation + "'";
			stmt.executeUpdate(query);

			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Assert.assertEquals("Il y a bien une réservation avec le code de réservation n°" + codeReservation, 1,
				nbReservation);
	}

	@Test
	public void testReserverVisiteNExistePas() {
		ReservationVisite reservationTest = new ReservationVisite();
		reservationTest.setCodeVisite("nexistepas");
		reservationTest.setNbPersonnes(42);
		reservationTest.setCodeClient(1);
		GestionVisites gestion = new GestionVisites();

		int nbReservationAvant = 0;
		int nbReservationApres = -1;

		try {
			DriverManager.registerDriver(new Driver());
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://" + AllTests.DB_ADRESSE + "/GestionnaireVisites", AllTests.USERNAME,
					AllTests.PASSWORD);

			Statement stmt = conn.createStatement();

			String query = "SELECT COUNT(*) FROM Reservations WHERE idClient = 1";
			ResultSet rs = stmt.executeQuery(query);

			rs.next();
			nbReservationAvant = rs.getInt(1);

			gestion.reserverVisite(reservationTest);

			rs = stmt.executeQuery(query);

			rs.next();
			nbReservationApres = rs.getInt(1);

			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// On compare le nombre de réservation avant et après la tentative de
		// réservation
		Assert.assertEquals("La réservation n'a pas pu se faire", nbReservationAvant, nbReservationApres);
	}

}
