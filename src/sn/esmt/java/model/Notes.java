package sn.esmt.java.model;

public class Notes {
	private int id_note;
	private String nom;
	private String prenom;
	private String cycle;
	private String identifiant;
	private double valeur_note;
	private String  module;
	private int coeff;
	private String classe;
	
	public Notes(int id_note, String identifiant_eleve, String nom, String prenom, double valeur_note, String module, String classe, String cycle) {
		this.id_note=id_note;
		this.identifiant=identifiant_eleve;
		this.nom=nom;
		this.prenom=prenom;
		this.valeur_note=valeur_note;
		this.module=module;
		this.classe=classe;
		this.cycle=cycle;
			
	}
	
	public Notes(int id_note, String identifiant_eleve, String nom, String prenom, double valeur_note, String module, String classe, String cycle, int coeff) {
		this.id_note=id_note;
		this.identifiant=identifiant_eleve;
		this.nom=nom;
		this.prenom=prenom;
		this.valeur_note=valeur_note;
		this.module=module;
		this.classe=classe;
		this.cycle=cycle;
		this.coeff=coeff;	
	}
	
	public Notes(String identifiant_eleve, String nom, String prenom, double valeur_note, String module, String classe, String cycle, int coeff) {
		this.identifiant=identifiant_eleve;
		this.nom=nom;
		this.prenom=prenom;
		this.valeur_note=valeur_note;
		this.module=module;
		this.classe=classe;
		this.cycle=cycle;
		this.coeff=coeff;	
	}
	
	public Notes(String identifiant_eleve, String nom, String prenom, double valeur_note, String module, String classe, String cycle) {
		this.identifiant=identifiant_eleve;
		this.nom=nom;
		this.prenom=prenom;
		this.valeur_note=valeur_note;
		this.module=module;
		this.classe=classe;
		this.cycle=cycle;
			
	}
	
	public Notes( String nom, String prenom, double valeur_note, String module, String classe) {
		this.nom=nom;
		this.prenom=prenom;
		this.valeur_note=valeur_note;
		this.module=module;
		this.classe=classe;	
	}

	public double getValeur_note() {
		return valeur_note;
	}

	public void setValeur_note(double valeur_note) {
		this.valeur_note = valeur_note;
	}

	public int getId_note() {
		return id_note;
	}

	public void setId_note(int id_note) {
		this.id_note = id_note;
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

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getCycle() {
		return cycle;
	}

	public void setCycle(String cycle) {
		this.cycle = cycle;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public int getCoeff() {
		return coeff;
	}

	public void setCoeff(int coeff) {
		this.coeff = coeff;
	}

	
	
	
}
