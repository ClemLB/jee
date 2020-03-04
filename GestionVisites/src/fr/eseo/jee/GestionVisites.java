package fr.eseo.jee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

public class GestionVisites {

	static final String DB_ADRESSE = "10.0.2.15";

	/**
	 * Prend une visite en paramètre et renvoie toutes les visites ayant un
	 * paramètre en commun
	 * 
	 * @param uneVisiste
	 * @return List<Visite>
	 */
	public List<Visite> trouverVisite(Visite uneVisite) {
		try {
			List<Visite> visites = new ArrayList<>();
			List<String> param = new ArrayList<>();
			String codeVisite = uneVisite.getCodeVisite();
			String typeVisite = uneVisite.getTypeVisite();
			String ville = uneVisite.getVille();
			String prix = Double.toString(uneVisite.getPrix());
			param.add(codeVisite);
			param.add(typeVisite);
			param.add(ville);
			param.add(prix);
			System.out.println(param);
			int nonNull = 0;
			for (String s : param) {
				if (s == null || s.equals("0.0")) {
					s = "";
				} else {
					nonNull++;
				}
			}
			String sql = "SELECT * FROM Visites WHERE ";
			switch (nonNull) {
			case 5:
				sql += "codeVisite = \"" + uneVisite.getCodeVisite() + "\" AND typeVisite = \""
						+ uneVisite.getTypeVisite() + "\" AND ville = \"" + uneVisite.getVille()
						+ "\" AND dateVisite = \"" + uneVisite.getDateVisite() + "\" AND prix = \""
						+ uneVisite.getPrix() + "\"";
				break;
			case 4:
				if (uneVisite.getCodeVisite().isEmpty()) {
					sql += "typeVisite = \"" + uneVisite.getTypeVisite() + "\" AND ville = \"" + uneVisite.getVille()
							+ "\" AND dateVisite = \"" + uneVisite.getDateVisite() + "\" AND prix = \""
							+ uneVisite.getPrix() + "\"";
				} else if (uneVisite.getTypeVisite().isEmpty()) {
					sql += "codeVisite = \"" + uneVisite.getCodeVisite() + "\" AND ville = \"" + uneVisite.getVille()
							+ "\" AND dateVisite = \"" + uneVisite.getDateVisite() + "\" AND prix = \""
							+ uneVisite.getPrix() + "\"";
				} else if (uneVisite.getVille().isEmpty()) {
					sql += "codeVisite = \"" + uneVisite.getCodeVisite() + "\" AND typeVisite = \""
							+ uneVisite.getTypeVisite() + "\" AND dateVisite = \"" + uneVisite.getDateVisite()
							+ "\" AND prix = \"" + uneVisite.getPrix() + "\"";
				} else if (uneVisite.getDateVisite().isEmpty()) {
					sql += "codeVisite = \"" + uneVisite.getCodeVisite() + "\" AND typeVisite = \""
							+ uneVisite.getTypeVisite() + "\" AND ville = \"" + uneVisite.getVille()
							+ "\" AND prix = \"" + uneVisite.getPrix() + "\"";
				} else {
					sql += "codeVisite = \"" + uneVisite.getCodeVisite() + "\" AND typeVisite = \""
							+ uneVisite.getTypeVisite() + "\" AND ville = \"" + uneVisite.getVille()
							+ "\" AND dateVisite = \"" + uneVisite.getDateVisite() + "\"";
				}
				break;
			case 3:
				if (uneVisite.getCodeVisite().isEmpty() && uneVisite.getTypeVisite().isEmpty()) {
					sql += "ville = \"" + uneVisite.getVille() + "\" AND dateVisite = \"" + uneVisite.getDateVisite()
							+ "\" AND prix = \"" + uneVisite.getPrix() + "\"";
				} else if (uneVisite.getCodeVisite().isEmpty() && uneVisite.getVille().isEmpty()) {
					sql += "typeVisite = \"" + uneVisite.getTypeVisite() + "\" AND dateVisite = \""
							+ uneVisite.getDateVisite() + "\" AND prix = \"" + uneVisite.getPrix() + "\"";
				} else if (uneVisite.getCodeVisite().isEmpty() && uneVisite.getDateVisite().isEmpty()) {
					sql += "AND typeVisite = \"" + uneVisite.getTypeVisite() + "\" AND ville = \""
							+ uneVisite.getVille() + "\" AND prix = \"" + uneVisite.getPrix() + "\"";
				} else if (uneVisite.getCodeVisite().isEmpty() && Double.toString(uneVisite.getPrix()).isEmpty()) {
					sql += "typeVisite = \"" + uneVisite.getTypeVisite() + "\" AND ville = \"" + uneVisite.getVille()
							+ "\" AND dateVisite = \"" + uneVisite.getDateVisite() + "\"";
				} else if (uneVisite.getTypeVisite().isEmpty() && uneVisite.getVille().isEmpty()) {
					sql += "codeVisite = \"" + uneVisite.getCodeVisite() + "\" AND dateVisite = \""
							+ uneVisite.getDateVisite() + "\" AND prix = \"" + uneVisite.getPrix() + "\"";
				} else if (uneVisite.getTypeVisite().isEmpty() && uneVisite.getDateVisite().isEmpty()) {
					sql += "codeVisite = \"" + uneVisite.getCodeVisite() + "\" AND ville = \"" + uneVisite.getVille()
							+ "\" AND prix = \"" + uneVisite.getPrix() + "\"";
				} else if (uneVisite.getTypeVisite().isEmpty() && Double.toString(uneVisite.getPrix()).isEmpty()) {
					sql += "codeVisite = \"" + uneVisite.getCodeVisite() + "\" AND ville = \"" + uneVisite.getVille()
							+ "\" AND dateVisite = \"" + uneVisite.getDateVisite() + "\"";
				} else if (uneVisite.getVille().isEmpty() && uneVisite.getDateVisite().isEmpty()) {
					sql += "codeVisite = \"" + uneVisite.getCodeVisite() + "\" AND typeVisite = \""
							+ uneVisite.getTypeVisite() + "\" AND prix = \"" + uneVisite.getPrix() + "\"";
				} else if (uneVisite.getVille().isEmpty() && Double.toString(uneVisite.getPrix()).isEmpty()) {
					sql += "codeVisite = \"" + uneVisite.getCodeVisite() + "\" AND typeVisite = \""
							+ uneVisite.getTypeVisite() + "\" AND dateVisite = \"" + uneVisite.getDateVisite() + "\"";
				} else {
					sql += "codeVisite = \"" + uneVisite.getCodeVisite() + "\" AND typeVisite = \""
							+ uneVisite.getTypeVisite() + "\" AND ville = \"" + uneVisite.getVille() + "\"";
				}
				break;
			case 2:
				if (!uneVisite.getCodeVisite().isEmpty() && !uneVisite.getTypeVisite().isEmpty()) {
					sql += "codeVisite = \"" + uneVisite.getCodeVisite() + "\" AND typeVisite = \""
							+ uneVisite.getTypeVisite() + "\"";
				} else if (!uneVisite.getCodeVisite().isEmpty() && !uneVisite.getVille().isEmpty()) {
					sql += "codeVisite = \"" + uneVisite.getCodeVisite() + "\" AND ville = \"" + uneVisite.getVille()
							+ "\" AND dateVisite = \"";
				} else if (!uneVisite.getCodeVisite().isEmpty() && !uneVisite.getDateVisite().isEmpty()) {
					sql += "codeVisite = \"" + uneVisite.getCodeVisite() + "\" AND dateVisite = \""
							+ uneVisite.getDateVisite() + "\"";
				} else if (!uneVisite.getCodeVisite().isEmpty() && !Double.toString(uneVisite.getPrix()).isEmpty()) {
					sql += "codeVisite = \"" + uneVisite.getCodeVisite() + "\" AND prix = \"" + uneVisite.getPrix()
							+ "\"";
				} else if (!uneVisite.getTypeVisite().isEmpty() && !uneVisite.getVille().isEmpty()) {
					sql += "typeVisite = \"" + uneVisite.getTypeVisite() + "\" AND ville = \"" + uneVisite.getVille()
							+ "\"";
				} else if (!uneVisite.getTypeVisite().isEmpty() && !uneVisite.getDateVisite().isEmpty()) {
					sql += "typeVisite = \"" + uneVisite.getTypeVisite() + "\" AND dateVisite = \""
							+ uneVisite.getDateVisite() + "\"";
				} else if (!uneVisite.getTypeVisite().isEmpty() && !Double.toString(uneVisite.getPrix()).isEmpty()) {
					sql += "typeVisite = \"" + uneVisite.getTypeVisite() + "\" AND prix = \"" + uneVisite.getPrix()
							+ "\"";
				} else if (!uneVisite.getVille().isEmpty() && !uneVisite.getDateVisite().isEmpty()) {
					sql += "ville = \"" + uneVisite.getVille() + "\" AND dateVisite = \"" + uneVisite.getDateVisite()
							+ "\"";
				} else if (!uneVisite.getVille().isEmpty() && !Double.toString(uneVisite.getPrix()).isEmpty()) {
					sql += "ville = \"" + uneVisite.getVille() + "\" AND prix = \"" + uneVisite.getPrix() + "\"";
				} else {
					sql += "dateVisite = \"" + uneVisite.getDateVisite() + "\" AND prix = \"" + uneVisite.getPrix()
							+ "\"";
				}
				break;
			case 1:
				if (codeVisite != null) {
					sql += "codeVisite = \"" + uneVisite.getCodeVisite() + "\"";
				} else if (!uneVisite.getTypeVisite().isEmpty()) {
					sql += "typeVisite = \"" + uneVisite.getTypeVisite() + "\"";
				} else if (!uneVisite.getVille().isEmpty()) {
					sql += "ville = \"" + uneVisite.getVille() + "\"";
				} else if (!uneVisite.getDateVisite().isEmpty()) {
					sql += "dateVisite = \"" + uneVisite.getDateVisite() + "\"";
				} else {
					sql += "prix = \"" + uneVisite.getPrix() + "\"";
				}
				break;
			default:
				break;
			}

			DriverManager.registerDriver(new Driver());
			Connection con = DriverManager.getConnection("jdbc:mysql://" + DB_ADRESSE + "/GestionnaireVisites", "admin",
					"admin");
			Statement stmt = con.createStatement();
			stmt.executeQuery(sql);
			ResultSet rs = stmt.getResultSet();
			Visite visite;
			while (rs.next()) {
				visite = new Visite();
				visite.setCodeVisite((rs.getString("codeVisite")));
				visite.setTypeVisite(rs.getString("typeVisite"));
				visite.setVille((rs.getString("Ville")));
				visite.setDateVisite((rs.getString("dateVisite")));
				visite.setPrix(rs.getDouble("prixVisite"));
				visites.add(visite);
			}
			rs.close();
			stmt.close();
			con.close();
			return visites;
		} catch (SQLException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}
	
	/**
	 * Permet la réservation d'une visite et l'insertion dans la db
	 * @param uneReservation
	 * @return
	 */
	
	public String reserverVisite(ReservationVisite uneReservation) {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection conn = DriverManager
					.getConnection("jdbc:mysql://" + DB_ADRESSE + "/GestionnaireVisites?user=admin&password=admin");

			Statement stmt = conn.createStatement();
			String table = "Reservations";

			// Attributs de la réservation
			String codeReservation = null;
			int codeVisite;
			String codeClient = null;
			int nbPersonnes;

			String columns = "(";
			String values = "('";

			if (uneReservation.getCodeReservation() != null) {
				codeReservation = uneReservation.getCodeReservation();
				columns += "codeReservation, ";
				values += codeReservation + "', '";
			}

			if ((Integer) uneReservation.getCodeVisite() != null) {
				codeVisite = uneReservation.getCodeVisite();
				columns += "idVisite, ";
				values += codeVisite + "', '";
			}

			if (uneReservation.getCodeClient() != null) {
				codeClient = uneReservation.getCodeClient();
				columns += "idClient, ";
				values += codeClient + "', '";
			}

			if ((Integer) uneReservation.getNbPersonnes() != null) {
				nbPersonnes = uneReservation.getNbPersonnes();
				columns += "nombreplaces, ";
				values += nbPersonnes + "', '";
			}

			columns += "booleenPaiementEffectue)";
			values += "0')";
			String query = "INSERT INTO " + table + columns + "VALUES " + values;
			ResultSet res = stmt.executeQuery(query);

			res.close();
			stmt.close();
			conn.close();

			return uneReservation.getCodeReservation();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Permet de payer la réservation avec le code de reservation passer en paramètre
	 * @param codeReservation
	 * @return
	 */
	
	public String payerVisite(String codeReservation) {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection conn = DriverManager
					.getConnection("jdbc:mysql://" + DB_ADRESSE + "/GestionnaireVisites?user=admin&password=admin");

			Statement stmt = conn.createStatement();
			String table = "Reservations";

			// Attributs de la réservation

			String query = "UPDATE " + table + " SET booleenPaiementEffectue = '1' WHERE codeReservation = "
					+ codeReservation;
			ResultSet res = stmt.executeQuery(query);

			res.close();
			stmt.close();
			conn.close();

			return "Paiement effectué !";
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "Problème lors du paiement !";
	}
	
	/**
	 * Permet d'annuler une réservation à partir de son code de réservation
	 * @param codeReservation
	 * @return
	 */

	public boolean annulerVisite(String codeReservation) {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection conn = DriverManager
					.getConnection("jdbc:mysql://" + DB_ADRESSE + "/GestionnaireVisites?user=admin&password=admin");

			Statement stmt = conn.createStatement();
			String table = "Reservations";

			// Attributs de la réservation

			String query = "DELETE FROM " + table + " WHERE codeReservation = " + codeReservation;
			ResultSet res = stmt.executeQuery(query);

			res.close();
			stmt.close();
			conn.close();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
}
