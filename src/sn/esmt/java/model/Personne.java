package sn.esmt.java.model;

public class Personne {
	private int id;
	private String nom;
	private String prenom;
	private String login;
	private String password;
	private String confirmPassword;
	private String role;
	private String email;
	private String numéro;
	


	public Personne(int id, String nom, String prenom, String login, String password,
			String role, String email, String numéro) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		this.role = role;
		this.email = email;
		this.numéro = numéro;
	}

	
	public Personne(int id, String nom, String prenom, String login, String password, String confirmPassword) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}
	
	// {"Id","rôle","nom", "prenom", "email","numéro","login", "password"};
	
	public Personne(String login, String password) {
		this.login=login;
		this.password=password;
	}
	
	public Personne(String login, String pwd, String nom, String prenom, String email, String numero,
			String role, String log, String pwd2, String pwdC) {
		
	}

	public Personne(String iden, String pwd, String nom, String prenom, String email, String numero, String rol,
			String log, String pwdC) {
		// TODO Auto-generated constructor stub
	}

	public Personne(String login2, String pwd, String nom2, String prenom2, String email2, String numero,
			String role2) {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNuméro() {
		return numéro;
	}

	public void setNuméro(String numéro) {
		this.numéro = numéro;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return " ";
	}
	
	
	
	
}
