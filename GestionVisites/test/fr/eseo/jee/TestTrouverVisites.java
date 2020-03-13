package fr.eseo.jee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mysql.cj.jdbc.Driver;

public class TestTrouverVisites {

	@BeforeClass
	public static void creationVisitesTest() {
		try {
			DriverManager.registerDriver(new Driver());
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://" + AllTests.DB_ADRESSE + "/GestionnaireVisites", AllTests.USERNAME,
					AllTests.PASSWORD);

			// Création d'un visite de test
			Statement stmt = conn.createStatement();
			String query = "INSERT INTO Visites(typeVisite, ville, dateVisite, prixVisite, codeVisite) VALUES ('test', 'angersTest', '3020-03-25', '42.69', 'teangers250320')";
			stmt.executeUpdate(query);

			// Création d'une visite de test
			query = "INSERT INTO Visites(typeVisite, ville, dateVisite, prixVisite, codeVisite) VALUES ('test2', 'angersTest', '3020-03-26', '39.99', 'teangers260320')";
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

			Statement stmt = conn.createStatement();

			// Suppression d'une visite de test
			String query = "DELETE FROM Visites WHERE codeVisite = 'teangers250320'";
			stmt.executeUpdate(query);

			// Suppression d'une visite de test
			query = "DELETE FROM Visites WHERE codeVisite = 'teangers260320'";
			stmt.executeUpdate(query);

			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testTrouverVisiteNExistePas() {
		Visite visiteTest = new Visite();
		visiteTest.setCodeVisite("nexistepas");
		GestionVisites gestion = new GestionVisites();
		List<Visite> listeVisites = gestion.trouverVisite(visiteTest);

		Assert.assertTrue("Il n'y a pas de visites", listeVisites.isEmpty());
	}

	@Test
	public void testTrouverVisiteExisteTypeVisite() {
		Visite visiteTest = new Visite();
		visiteTest.setTypeVisite("test");
		GestionVisites gestion = new GestionVisites();
		List<Visite> listeVisites = gestion.trouverVisite(visiteTest);

		Assert.assertEquals("Il y a une visite", 1, listeVisites.size());
		Assert.assertEquals("Il y a une visite du type 'test'", "test", listeVisites.get(0).getTypeVisite());
	}

	@Test
	public void testTrouverVisiteExiste2Villes() {
		Visite visiteTest = new Visite();
		visiteTest.setVille("angersTest");
		GestionVisites gestion = new GestionVisites();
		List<Visite> listeVisites = gestion.trouverVisite(visiteTest);

		Assert.assertEquals("Il y a une visite", 2, listeVisites.size());
		Assert.assertEquals("Il y a une visite dans la ville 'angersTest'", "angersTest",
				listeVisites.get(0).getVille());
		Assert.assertEquals("Il y a une visite dans la ville 'angersTest'", "angersTest",
				listeVisites.get(1).getVille());
	}

	@Test
	public void testTrouverVisiteExisteDate() {
		Visite visiteTest = new Visite();
		visiteTest.setDateVisite("3020-03-25");
		GestionVisites gestion = new GestionVisites();
		List<Visite> listeVisites = gestion.trouverVisite(visiteTest);

		Assert.assertEquals("Il y a une visite", 1, listeVisites.size());
		Assert.assertEquals("Il y a une visite à la date '3020-03-25'", "3020-03-25",
				listeVisites.get(0).getDateVisite());
	}

	@Test
	public void testTrouverVisiteExistePrix() {
		Visite visiteTest = new Visite();
		visiteTest.setPrix(42.69);
		GestionVisites gestion = new GestionVisites();
		List<Visite> listeVisites = gestion.trouverVisite(visiteTest);

		Assert.assertEquals("Il y a une visite", 1, listeVisites.size());
		Assert.assertEquals("Il y a une visite au prix '42.69'", 42.69, listeVisites.get(0).getPrix(), 0);
	}

	@Test
	public void testTrouverVisiteExisteCodeVisite() {
		Visite visiteTest = new Visite();
		visiteTest.setCodeVisite("teangers250320");
		GestionVisites gestion = new GestionVisites();
		List<Visite> listeVisites = gestion.trouverVisite(visiteTest);

		Assert.assertEquals("Il y a une visite", 1, listeVisites.size());
		Assert.assertEquals("Il y a une visite avec le code 'teangers250320'", "teangers250320",
				listeVisites.get(0).getCodeVisite());
	}

}
