package fr.eseo.jee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestionVisites {

	private static final String DB_ADRESSE = "192.168.4.197";
	private static final String USERNAME = "java";
	private static final String PASSWORD = "network";

	/**
	 * Prend une visite en paramètre et renvoie toutes les visites ayant un
	 * paramètre en commun
	 * 
	 * @param uneVisiste
	 * @return List<Visite>
	 */
	public List<Visite> trouverVisite(Visite uneVisite) {

		List<Visite> visites = new ArrayList<>();
		List<String> param = new ArrayList<>();
		String codeVisite = uneVisite.getCodeVisite();
		String typeVisite = uneVisite.getTypeVisite();
		String ville = uneVisite.getVille();
		String dateVisite = uneVisite.getDateVisite();
		String prix = Double.toString(uneVisite.getPrix());
		param.add(codeVisite);
		param.add(typeVisite);
		param.add(ville);
		param.add(dateVisite);
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
			sql += "codeVisite = \"" + codeVisite + "\" AND typeVisite = \"" + typeVisite + "\" AND ville = \"" + ville
					+ "\" AND dateVisite = \"" + dateVisite + "\" AND prixVisite = \"" + prix + "\"";
			break;
		case 4:
			if (codeVisite != null) {
				sql += "typeVisite = \"" + typeVisite + "\" AND ville = \"" + ville + "\" AND dateVisite = \""
						+ dateVisite + "\" AND prixVisite = \"" + prix + "\"";
			} else if (typeVisite != null) {
				sql += "codeVisite = \"" + codeVisite + "\" AND ville = \"" + ville + "\" AND dateVisite = \""
						+ dateVisite + "\" AND prixVisite = \"" + prix + "\"";
			} else if (ville != null) {
				sql += "codeVisite = \"" + codeVisite + "\" AND typeVisite = \"" + typeVisite + "\" AND dateVisite = \""
						+ dateVisite + "\" AND prixVisite = \"" + prix + "\"";
			} else if (dateVisite != null) {
				sql += "codeVisite = \"" + codeVisite + "\" AND typeVisite = \"" + typeVisite + "\" AND ville = \""
						+ ville + "\" AND prixVisite = \"" + prix + "\"";
			} else {
				sql += "codeVisite = \"" + codeVisite + "\" AND typeVisite = \"" + typeVisite + "\" AND ville = \""
						+ ville + "\" AND dateVisite = \"" + dateVisite + "\"";
			}
			break;
		case 3:
			if (codeVisite != null && typeVisite != null) {
				sql += "ville = \"" + ville + "\" AND dateVisite = \"" + dateVisite + "\" AND prixVisite = \"" + prix + "\"";
			} else if (codeVisite != null && ville != null) {
				sql += "typeVisite = \"" + typeVisite + "\" AND dateVisite = \"" + dateVisite + "\" AND prixVisite = \""
						+ prix + "\"";
			} else if (codeVisite != null && dateVisite != null) {
				sql += "AND typeVisite = \"" + typeVisite + "\" AND ville = \"" + ville + "\" AND prixVisite = \"" + prix
						+ "\"";
			} else if (codeVisite != null && prix != null) {
				sql += "typeVisite = \"" + typeVisite + "\" AND ville = \"" + ville + "\" AND dateVisite = \""
						+ dateVisite + "\"";
			} else if (typeVisite != null && ville != null) {
				sql += "codeVisite = \"" + codeVisite + "\" AND dateVisite = \"" + dateVisite + "\" AND prixVisite = \""
						+ prix + "\"";
			} else if (typeVisite != null && dateVisite != null) {
				sql += "codeVisite = \"" + codeVisite + "\" AND ville = \"" + ville + "\" AND prixVisite = \"" + prix + "\"";
			} else if (typeVisite != null && prix != null) {
				sql += "codeVisite = \"" + codeVisite + "\" AND ville = \"" + ville + "\" AND dateVisite = \""
						+ dateVisite + "\"";
			} else if (ville != null && dateVisite != null) {
				sql += "codeVisite = \"" + codeVisite + "\" AND typeVisite = \"" + typeVisite + "\" AND prixVisite = \""
						+ prix + "\"";
			} else if (ville != null && prix != null) {
				sql += "codeVisite = \"" + codeVisite + "\" AND typeVisite = \"" + typeVisite + "\" AND dateVisite = \""
						+ dateVisite + "\"";
			} else {
				sql += "codeVisite = \"" + codeVisite + "\" AND typeVisite = \"" + typeVisite + "\" AND ville = \""
						+ ville + "\"";
			}
			break;
		case 2:
			if (codeVisite != null && typeVisite != null) {
				sql += "codeVisite = \"" + codeVisite + "\" AND typeVisite = \"" + typeVisite + "\"";
			} else if (codeVisite != null && ville != null) {
				sql += "codeVisite = \"" + codeVisite + "\" AND ville = \"" + ville + "\" AND dateVisite = \"";
			} else if (codeVisite != null && dateVisite != null) {
				sql += "codeVisite = \"" + codeVisite + "\" AND dateVisite = \"" + dateVisite + "\"";
			} else if (codeVisite != null && prix != null) {
				sql += "codeVisite = \"" + codeVisite + "\" AND prixVisite = \"" + prix + "\"";
			} else if (typeVisite != null && ville != null) {
				sql += "typeVisite = \"" + typeVisite + "\" AND ville = \"" + ville + "\"";
			} else if (typeVisite != null && dateVisite != null) {
				sql += "typeVisite = \"" + typeVisite + "\" AND dateVisite = \"" + dateVisite + "\"";
			} else if (typeVisite != null && prix != null) {
				sql += "typeVisite = \"" + typeVisite + "\" AND prixVisite = \"" + prix + "\"";
			} else if (ville != null && dateVisite != null) {
				sql += "ville = \"" + ville + "\" AND dateVisite = \"" + dateVisite + "\"";
			} else if (ville != null && prix != null) {
				sql += "ville = \"" + ville + "\" AND prixVisite = \"" + prix + "\"";
			} else {
				sql += "dateVisite = \"" + dateVisite + "\" AND prixVisite = \"" + prix + "\"";
			}
			break;
		case 1:
			if (codeVisite != null) {
				sql += "codeVisite = \"" + codeVisite + "\"";
			} else if (typeVisite != null) {
				sql += "typeVisite = \"" + typeVisite + "\"";
			} else if (ville != null) {
				sql += "ville = \"" + ville + "\"";
			} else if (dateVisite != null) {
				sql += "dateVisite = \"" + dateVisite + "\"";
			} else {
				sql += "prixVisite = \"" + prix + "\"";
			}
			break;
		default:
			break;
		}
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection con = DriverManager.getConnection("jdbc:mysql://" + DB_ADRESSE + "/GestionnaireVisites", USERNAME, PASSWORD);

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
	 * 
	 * @param uneReservation
	 * @return
	 */

	public String reserverVisite(ReservationVisite uneReservation) {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://" + DB_ADRESSE + "/GestionnaireVisites?user=" + USERNAME + "&password=" + PASSWORD);

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
			stmt.executeUpdate(query);

			stmt.close();
			conn.close();

			return uneReservation.getCodeReservation();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Permet de payer la réservation avec le code de reservation passer en
	 * paramètre
	 * 
	 * @param codeReservation
	 * @return
	 */

	public String payerVisite(String codeReservation) {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://" + DB_ADRESSE + "/GestionnaireVisites?user=" + USERNAME + "&password=" + PASSWORD);

			Statement stmt = conn.createStatement();
			String table = "Reservations";

			// Attributs de la réservation

			String query = "UPDATE " + table + " SET booleenPaiementEffectue = '1' WHERE codeReservation = "
					+ codeReservation;
			stmt.executeUpdate(query);
			
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
	 * 
	 * @param codeReservation
	 * @return
	 */

	public boolean annulerVisite(String codeReservation) {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://" + DB_ADRESSE + "/GestionnaireVisites?user=" + USERNAME + "&password=" + PASSWORD);

			Statement stmt = conn.createStatement();
			String table = "Reservations";

			// Attributs de la réservation

			String query = "DELETE FROM " + table + " WHERE codeReservation = " + codeReservation;
			stmt.executeUpdate(query);
			
			stmt.close();
			conn.close();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
}
