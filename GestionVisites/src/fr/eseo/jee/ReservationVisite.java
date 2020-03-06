package fr.eseo.jee;

public class ReservationVisite {

	// Attributs
	private String codeReservation;
	private int codeVisite;
	private int codeClient;
	private int nbPersonnes;
	private boolean paiementEffectue;

	// Accesseurs
	public String getCodeReservation() {
		return codeReservation;
	}

	public void setCodeReservation(String codeReservation) {
		this.codeReservation = codeReservation;
	}

	public int getCodeVisite() {
		return codeVisite;
	}

	public void setCodeVisite(int codeVisite) {
		this.codeVisite = codeVisite;
	}

	public int getCodeClient() {
		return codeClient;
	}

	public void setCodeClient(int codeClient) {
		this.codeClient = codeClient;
	}

	public int getNbPersonnes() {
		return nbPersonnes;
	}

	public void setNbPersonnes(int nbPersonnes) {
		this.nbPersonnes = nbPersonnes;
	}

	public boolean isPaiementEffectue() {
		return paiementEffectue;
	}

	public void setPaiementEffectue(boolean paiementEffectue) {
		this.paiementEffectue = paiementEffectue;
	}
}