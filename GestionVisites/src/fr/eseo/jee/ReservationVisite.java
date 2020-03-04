package fr.eseo.jee;

public class ReservationVisite {

	private String codeReservation;
	private String codeVisite;
	private String codeClient;
	private int nbPersonnes;
	private boolean paiementEffectue;

	public String getCodeReservation() {
		return codeReservation;
	}

	public void setCodeReservation(String codeReservation) {
		this.codeReservation = codeReservation;
	}

	public String getCodeVisite() {
		return codeVisite;
	}

	public void setCodeVisite(String codeVisite) {
		this.codeVisite = codeVisite;
	}

	public String getCodeClient() {
		return codeClient;
	}

	public void setCodeClient(String codeClient) {
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