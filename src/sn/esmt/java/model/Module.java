package sn.esmt.java.model;

public class Module {
	private int id_module;
	private String nom_module;
	private int coeff;
	
	public Module(int id_module, String nom_module) {
		this.id_module=id_module;
		this.nom_module=nom_module;
	}
	
	public Module(int id_module, String nom_module, int coeff) {
		this.id_module=id_module;
		this.nom_module=nom_module;
		this.coeff=coeff;
	}
	
	public Module(String nom_module, int coeff) {
		this.nom_module=nom_module;
		this.coeff=coeff;
	}

	public int getId_module() {
		return id_module;
	}

	public void setId_module(int id_module) {
		this.id_module = id_module;
	}

	public String getNom_module() {
		return nom_module;
	}

	public void setNom_module(String nom_module) {
		this.nom_module = nom_module;
	}

	public int getCoeff() {
		return coeff;
	}

	public void setCoeff(int coeff) {
		this.coeff = coeff;
	}
	
	
}
