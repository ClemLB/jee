package fr.eseo.jee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.jws.WebService;

@WebService(targetNamespace = "http://jee.eseo.fr/", endpointInterface = "fr.eseo.jee.SEIGestionVisites", portName = "GestionVisitesPort", serviceName = "GestionVisitesService")
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

		List<Visite> visites = new ArrayList<Visite>();
		List<String> param = new ArrayList<String>();
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
				sql += "ville = \"" + ville + "\" AND dateVisite = \"" + dateVisite + "\" AND prixVisite = \"" + prix
						+ "\"";
			} else if (codeVisite != null && ville != null) {
				sql += "typeVisite = \"" + typeVisite + "\" AND dateVisite = \"" + dateVisite + "\" AND prixVisite = \""
						+ prix + "\"";
			} else if (codeVisite != null && dateVisite != null) {
				sql += "AND typeVisite = \"" + typeVisite + "\" AND ville = \"" + ville + "\" AND prixVisite = \""
						+ prix + "\"";
			} else if (codeVisite != null && prix != null) {
				sql += "typeVisite = \"" + typeVisite + "\" AND ville = \"" + ville + "\" AND dateVisite = \""
						+ dateVisite + "\"";
			} else if (typeVisite != null && ville != null) {
				sql += "codeVisite = \"" + codeVisite + "\" AND dateVisite = \"" + dateVisite + "\" AND prixVisite = \""
						+ prix + "\"";
			} else if (typeVisite != null && dateVisite != null) {
				sql += "codeVisite = \"" + codeVisite + "\" AND ville = \"" + ville + "\" AND prixVisite = \"" + prix
						+ "\"";
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
			Connection con = DriverManager.getConnection("jdbc:mysql://" + DB_ADRESSE + "/GestionnaireVisites",
					USERNAME, PASSWORD);

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
			int nbPersonnes;

			String columns = "(";
			String values = "('";

			if (uneReservation.getCodeVisite() != null) {
				// On récupère l'id de la visite pour l'insertion dans la table à partir du code visite
				int idVisite = getIdFromCode(uneReservation.getCodeVisite());
				if (idVisite == 0) {
					return "Désolé ! La visite n'existe pas dans notre base de donnée. Veuillez vérifier d'avoir entré le bon code de visite.";
				}
				columns += "idVisite, ";
				values += idVisite + "', '";
			}

			if ((Integer) uneReservation.getCodeClient() != null) {
				columns += "idClient, ";
				values += uneReservation.getCodeClient() + "', '";
			}

			if ((Integer) uneReservation.getNbPersonnes() != null) {
				nbPersonnes = uneReservation.getNbPersonnes();
				columns += "nombreplaces, ";
				values += nbPersonnes + "', '";
			}

			
			columns += "booleenPaiementEffectue, ";
			values += "0', '";
			
			// Génère un code de réservation unique et valide
			String codeReservation = generateNewCodeReservation(7);
			columns += "codeReservation)";
			values += codeReservation + "')";
			
			stmt.close();
			Statement stmtInsert = conn.createStatement();
			String query = "INSERT INTO " + table + columns + "VALUES " + values;
			stmtInsert.executeUpdate(query);

			stmtInsert.close();
			conn.close();

			return codeReservation;

		} catch (SQLException e) {
			e.printStackTrace();
			return "Une erreur est survenue lors de la réservation !";
		}
	}

	/**
	 * Retourne l'id  de la visite à partir de son code de visite
	 * @param codeVisite
	 * @return int idVisite
	 */
	private int getIdFromCode(String codeVisite) {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://" + DB_ADRESSE + "/GestionnaireVisites?user=" + USERNAME + "&password=" + PASSWORD);

			Statement stmt = conn.createStatement();
			String table = "Visites";
			String query = "SELECT idVisite FROM " + table + " WHERE codeVisite = '" + codeVisite + "'";
			stmt.executeQuery(query);
			ResultSet rs = stmt.getResultSet();
			
			while(rs.next())
			{
				return rs.getInt("idVisite");
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * Génère une code de réservation aléatoire
	 * @param codeLength
	 * @return String codeReservation
	 */
	private String generateNewCodeReservation(int codeLength) {
		Random rand = new Random();
		String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ12356789";
		int longueur = chars.length();
		String codeReservation;
		
		do {
			codeReservation = "";
			for(int i = 0; i < codeLength; i++) 
			{
				  int k = rand.nextInt(longueur);
				  codeReservation += k;
			}	
		} while(checkIfExist(codeReservation));

		return codeReservation;
	}

	/**
	 * Vérifie si le codeVisite généré existe déjà dans la db
	 * @param codeVisite
	 * @return boolean
	 */
	private boolean checkIfExist(String codeVisite) {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://" + DB_ADRESSE + "/GestionnaireVisites?user=" + USERNAME + "&password=" + PASSWORD);

			Statement stmt = conn.createStatement();
			String table = "Reservations";
			String query = "SELECT codeReservation FROM " + table;
			stmt.executeQuery(query);
			ResultSet rs = stmt.getResultSet();
			
			while(rs.next())
			{
				if (rs.getString("codeReservation") == codeVisite)
				{
					return true;
				}
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
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

			String query = "DELETE FROM " + table + " WHERE codeReservation = '" + codeReservation + "'";
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
