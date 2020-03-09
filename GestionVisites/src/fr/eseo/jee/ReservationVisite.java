package fr.eseo.jee;

public class ReservationVisite {

	// Attributs
	private String codeVisite;
	private int idClient;
	private int nbPersonnes;
	private boolean paiementEffectue;
	private String codeReservation;

	// Accesseurs
	public String getCodeReservation() {
		return this.codeReservation;
	}

	public void setCodeReservation(String codeReservation) {
		this.codeReservation = codeReservation;
	}

	public String getCodeVisite() {
		return this.codeVisite;
	}

	public void setCodeVisite(String codeVisite) {
		this.codeVisite = codeVisite;
	}

	public int getCodeClient() {
		return this.idClient;
	}

	public void setCodeClient(int codeClient) {
		this.idClient = codeClient;
	}

	public int getNbPersonnes() {
		return this.nbPersonnes;
	}

	public void setNbPersonnes(int nbPersonnes) {
		this.nbPersonnes = nbPersonnes;
	}

	public boolean isPaiementEffectue() {
		return this.paiementEffectue;
	}

	public void setPaiementEffectue(boolean paiementEffectue) {
		this.paiementEffectue = paiementEffectue;
	}
}