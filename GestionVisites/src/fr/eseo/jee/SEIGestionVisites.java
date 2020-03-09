package fr.eseo.jee;

import java.util.List;

import javax.jws.WebService;

@WebService(name = "SEIGestionVisites", targetNamespace = "http://jee.eseo.fr/")
public interface SEIGestionVisites {

	/**
	 * Prend une visite en paramètre et renvoie toutes les visites ayant un
	 * paramètre en commun
	 * 
	 * @param uneVisiste
	 * @return List<Visite>
	 */
	List<Visite> trouverVisite(Visite uneVisite);

	/**
	 * Permet la réservation d'une visite et l'insertion dans la db
	 * 
	 * @param uneReservation
	 * @return
	 */

	String reserverVisite(ReservationVisite uneReservation);

	/**
	 * Permet de payer la réservation avec le code de reservation passer en
	 * paramètre
	 * 
	 * @param codeReservation
	 * @return
	 */

	String payerVisite(String codeReservation);

	/**
	 * Permet d'annuler une réservation à partir de son code de réservation
	 * 
	 * @param codeReservation
	 * @return
	 */

	boolean annulerVisite(String codeReservation, int idClient);

}