package fr.eseo.jee;

public class Visite {

	// Attributs
	private String codeVisite;
	private String typeVisite;
	private String ville;
	private String dateVisite;
	private float prix;

	// Getters & Setters

	public String getCodeVisite() {
		return this.codeVisite;
	}

	public void setCodeVisite(String codeVisite) {
		this.codeVisite = codeVisite;
	}

	public String getTypeVisite() {
		return this.typeVisite;
	}

	public void setTypeVisite(String typeVisite) {
		this.typeVisite = typeVisite;
	}

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getDateVisite() {
		return this.dateVisite;
	}

	public void setDateVisite(String dateVisite) {
		this.dateVisite = dateVisite;
	}

	public float getPrix() {
		return this.prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

}
