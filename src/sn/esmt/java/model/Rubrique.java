package sn.esmt.java.model;


public class Rubrique {
	private int id;
	private String section;
	private String nom_rubrique;
	private String classe;
	private double montant;
	private String date_limite;
	
	public Rubrique(int id,String section, String nom_rubrique, String classe, double montant, String date_limite) {
		this.id = id;
		this.section=section;
		this.nom_rubrique = nom_rubrique;
		this.classe = classe;
		this.montant = montant;
		this.date_limite = date_limite;
	}
	
	public Rubrique(String section, String nom_rubrique, String classe, double montant, String date_limite) {
		this.section=section;
		this.nom_rubrique = nom_rubrique;
		this.classe = classe;
		this.montant = montant;
		this.date_limite = date_limite;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom_rubrique() {
		return nom_rubrique;
	}

	public void setNom_rubrique(String nom_rubrique) {
		this.nom_rubrique = nom_rubrique;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getDate_limite() {
		return date_limite;
	}

	public void setDate_limite(String date_limite) {
		this.date_limite = date_limite;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}
	
	
	
}
