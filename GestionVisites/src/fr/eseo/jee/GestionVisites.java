package fr.eseo.jee;

import java.lang.reflect.Field;
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
			param.add(uneVisite.getCodeVisite());
			param.add(uneVisite.getTypeVisite());
			param.add(uneVisite.getVille());
			param.add(Double.toString(uneVisite.getPrix()));
			int nonNull = 0;
			for (String s : param) {
				if (!s.isEmpty()) {
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
				if (!uneVisite.getCodeVisite().isEmpty()) {
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

	public String reserverVisite(ReservationVisite uneReservation) {

	}

	public String payerVisite(String codeReservation) {

	}

	public boolean annulerVisite(String codeReservation) {

	}
}
