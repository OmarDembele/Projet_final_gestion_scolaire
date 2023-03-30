package sn.esmt.java.model;

public class Eleves {
	
	private int id_etudiant;
	private String nom_etudiant;
	private String prenom_etudiant;
	private String email_etudiant;
	private String identifiant;
	private String date_naissance;
	private String lieu_naissance;
	private String genre;	
	private String adresse;
	private String section;
	private String observation_inscription;
	private String classe;
	
	public Eleves(int id_etudiant, String nom_etudiant, String prenom_etudiant, 
			String date_naissance, String lieu_naissance, String email_etudiant, String identifiant,String genre, String adresse, String section,
			String observation_inscription, String classe) {
		this.id_etudiant = id_etudiant;
		this.nom_etudiant = nom_etudiant;
		this.prenom_etudiant = prenom_etudiant;
		this.date_naissance = date_naissance;
		this.lieu_naissance = lieu_naissance;
		this.email_etudiant = email_etudiant;
		this.identifiant=identifiant;
		this.genre = genre;
		this.adresse = adresse;
		this.section = section;
		this.observation_inscription = observation_inscription;
		this.classe = classe;
	}
	public Eleves( String nom_etudiant, String prenom_etudiant, 
			String date_naissance, String lieu_naissance,String email_etudiant,String identifiant, String genre, String adresse,String section, String observation_inscription, String classe
			) {
		this.nom_etudiant = nom_etudiant;
		this.prenom_etudiant = prenom_etudiant;
		this.date_naissance = date_naissance;
		this.lieu_naissance = lieu_naissance;
		this.email_etudiant = email_etudiant;
		this.identifiant = identifiant;
		this.genre = genre;
		this.adresse = adresse;
		this.section = section;
		this.observation_inscription = observation_inscription;
		this.classe = classe;
	}
	
	public Eleves( String identifiant ,String observation_inscription) {
		this.identifiant=identifiant;
		this.observation_inscription=observation_inscription;
	}
	
	public int getId_etudiant() {
		return id_etudiant;
	}
	
	public String getNom_etudiant() {
		return nom_etudiant;
	}
	
	public void setNom_etudiant(String nom_etudiant) {
		this.nom_etudiant = nom_etudiant;
	}
	
	public String getPrenom_etudiant() {
		return prenom_etudiant;
	}
	
	public void setPrenom_etudiant(String prenom_etudiant) {
		this.prenom_etudiant = prenom_etudiant;
	}
	
	public String getEmail_etudiant() {
		return email_etudiant;
	}
	
	public void setEmail_etudiant(String email_etudiant) {
		this.email_etudiant = email_etudiant;
	}
	
	public String getDate_naissance() {
		return date_naissance;
	}
	
	public void setDate_naissance(String date_naissance) {
		this.date_naissance = date_naissance;
	}
	
	public String getLieu_naissance() {
		return lieu_naissance;
	}
	
	public void setLieu_naissance(String lieu_naissance) {
		this.lieu_naissance = lieu_naissance;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getAdresse() {
		return adresse;
	}
	
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public String getSection() {
		return section;
	}
	
	public void setSection(String section) {
		this.section = section;
	}
	
	public String getObservation_inscription() {
		return observation_inscription;
	}
	
	public void setObservation_inscription(String observation_inscription) {
		this.observation_inscription = observation_inscription;
	}
	
	public String getClasse() {
		return classe;
	}
	
	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	
	
	
	
	
}
