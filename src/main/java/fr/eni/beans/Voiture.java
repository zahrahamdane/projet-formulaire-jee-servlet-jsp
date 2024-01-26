package fr.eni.beans;

public class Voiture {
	
	private static final long serialVersionUID = -1;
	
	private String marque;
	private String modele;
	private String kilometrage;
	private String immatriculation;
	private int annee;
	
	public Voiture() {
	}
	

	public Voiture(String marque, String modele, String kilometrage, String immatriculation, int annee) {
		super();
		this.marque = marque;
		this.modele = modele;
		this.kilometrage = kilometrage;
		this.immatriculation = immatriculation;
		this.annee = annee;
	}


	public String getMarque() {
		return marque;
	}


	public void setMarque(String marque) {
		this.marque = marque;
	}


	public String getModele() {
		return modele;
	}


	public void setModele(String modele) {
		this.modele = modele;
	}


	public String getKilometrage() {
		return kilometrage;
	}


	public void setKilometrage(String kilometrage) {
		this.kilometrage = kilometrage;
	}


	public String getImmatriculation() {
		return immatriculation;
	}


	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}


	public int getAnnee() {
		return annee;
	}


	public void setAnnee(int annee) {
		this.annee = annee;
	}


	@Override
	public String toString() {
		return "Voiture [marque=" + marque + ", modele=" + modele + ", kilometrage=" + kilometrage
				+ ", immatriculation=" + immatriculation + ", annee=" + annee + "]";
	}



}
