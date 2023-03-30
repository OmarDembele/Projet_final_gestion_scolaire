package sn.esmt.java.model;

public class Payement {
	private int id;
	private String identifiant;
	private String nom;
	private String prenom;
	private String classe;
	private double montant_scolarite;
	private String numero_recue;
	private String date_paiement;
	private double montant_inscription;
	private String observation;
	private String jour;
	private String mois;
	private String annee;
	
	public Payement(int id, String identifiant, String nom, String prenom, String classe, double montant_scolarite,
			String numero_recue, String date_paiement, double montant_inscription, String observation) {
		this.id = id;
		this.identifiant = identifiant;
		this.nom = nom;
		this.prenom = prenom;
		this.classe = classe;
		this.montant_scolarite = montant_scolarite;
		this.numero_recue = numero_recue;
		this.date_paiement = date_paiement;
		this.montant_inscription = montant_inscription;
		this.observation = observation;
	}
	
	public Payement(String identifiant, String nom, String prenom, String classe, double montant_scolarite,
			String numero_recue, String date_paiement, double montant_inscription, String observation) {
		this.identifiant = identifiant;
		this.nom = nom;
		this.prenom = prenom;
		this.classe = classe;
		this.montant_scolarite = montant_scolarite;
		this.numero_recue = numero_recue;
		this.date_paiement = date_paiement;
		this.montant_inscription = montant_inscription;
		this.observation = observation;
	}
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getIdentifiant() {
		return identifiant;
	}
	
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getClasse() {
		return classe;
	}
	
	public void setClasse(String classe) {
		this.classe = classe;
	}
	
	public double getMontant_scolarite() {
		return montant_scolarite;
	}
	
	public void setMontant_scolarite(double montant_scolarite) {
		this.montant_scolarite = montant_scolarite;
	}
	
	public String getNumero_recue() {
		return numero_recue;
	}
	
	public void setNumero_recue(String numero_recue) {
		this.numero_recue = numero_recue;
	}
	
	public String getDate_paiement() {
		return date_paiement;
	}
	
	public void setDate_paiement(String date_paiement) {
		this.date_paiement = date_paiement;
	}
	
	public double getMontant_inscription() {
		return montant_inscription;
	}
	
	public void setMontant_inscription(double montant_inscription) {
		this.montant_inscription = montant_inscription;
	}
	
	public String getObservation() {
		return observation;
	}
	
	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getJour() {
		return jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}

	public String getMois() {
		return mois;
	}

	public void setMois(String mois) {
		this.mois = mois;
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}
	
	

}
