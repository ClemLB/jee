package fr.eseo.jee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class GestionVisites {

	/**
	 * Prend une visite en paramètre
	 * @param uneVisiste
	 * @return List<Visite>
	 */
	public List<Visite> trouverVisite(Visite uneVisiste) {
		
	}

	public String reserverVisite(ReservationVisite uneReservation) 
	{
		try 
		{
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Biblio?user=admin&password=admin");
			
			Statement stmt = conn.createStatement();
			String table = "Reservations";
			
			
			// Attributs de la réservation
			String codeReservation = null;
			int codeVisite;
			String codeClient = null;
			int nbPersonnes;
			
			String columns = "(";
			String values = "('";
			
			if(uneReservation.getCodeReservation() != null)
			{
				codeReservation = uneReservation.getCodeReservation();
				columns += "codeReservation, ";
				values += codeReservation + "', '";
			}
			
			if((Integer) uneReservation.getCodeVisite() != null)
			{
				codeVisite = uneReservation.getCodeVisite();
				columns += "idVisite, ";
				values += codeVisite + "', '";
			}
			
			if(uneReservation.getCodeClient() != null)
			{
				codeClient = uneReservation.getCodeClient();
				columns += "idClient, ";
				values += codeClient + "', '";
			}
			
			if((Integer) uneReservation.getNbPersonnes() != null)
			{
				nbPersonnes = uneReservation.getNbPersonnes();
				columns += "nombreplaces, ";
				values += nbPersonnes + "', '";
			}
			
			columns += "booleenPaiementEffectue)";
			values += "0')";
			String query = "INSERT INTO "+ table + columns + "VALUES " + values;
			ResultSet res = stmt.executeQuery(query);
		
			res.close();
			stmt.close();
			conn.close();
			
			return uneReservation.getCodeReservation();
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return null;
	}

	public String payerVisite(String codeReservation) 
	{
		try 
		{
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Biblio?user=admin&password=admin");
			
			Statement stmt = conn.createStatement();
			String table = "Reservations";
			
			
			// Attributs de la réservation
			
			String query = "UPDATE " + table + " SET booleenPaiementEffectue = '1' WHERE codeReservation = " + codeReservation;
			ResultSet res = stmt.executeQuery(query);
		
			res.close();
			stmt.close();
			conn.close();
			
			return "Paiement effectué !";
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return "Problème lors du paiement !";
	}

	public boolean annulerVisite(String codeReservation) {

	}
}
