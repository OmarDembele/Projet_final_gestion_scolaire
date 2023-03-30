package sn.esmt.java.dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



import sn.esmt.java.dataSource.Dao;
import sn.esmt.java.exception.DaoException;
import sn.esmt.java.model.Administrateur;
import sn.esmt.java.model.Caissier;
import sn.esmt.java.model.Secretaire;
import sn.esmt.java.model.Personne;

public class DBUsers implements Dao<Personne>{

	@Override
	public void create(Personne obj) throws DaoException {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Insert into Utilisateurs (id, nom, prenom, login, password, role, email, numero) values (?, ?, ?, ?,?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, obj.getId());
			ps.setString(2, obj.getNom());
			ps.setString(3, obj.getPrenom());
			ps.setString(4, obj.getLogin());
			ps.setString(5, obj.getPassword());
			ps.setString(6, obj.getRole());
			ps.setString(7, obj.getEmail());
			ps.setString(8, obj.getNuméro());
			
			ps.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e.getMessage());
		}

	}
		
	

	@Override
	public void update(Personne obj) throws DaoException {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Update Utilisateurs Set nom=?, prenom=?, login=?, password=?, role=?, email=?, numero=? Where id=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(8, obj.getId());
			ps.setString(1, obj.getNom());
			ps.setString(2, obj.getPrenom());
			ps.setString(3, obj.getLogin());
			ps.setString(4, obj.getPassword());
			ps.setString(5, obj.getRole());
			ps.setString(6, obj.getEmail());
			ps.setString(7, obj.getNuméro());
			ps.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
		
	}

	@Override
	public void delete(int id) throws DaoException {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Delete From Utilisateurs Where id=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
		
	}

	@Override
	public List<Personne> list() throws DaoException {
		List<Personne> user = new ArrayList<>();
		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * From Utilisateurs";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int identifiant = rs.getInt("id");
				String login = rs.getString("login");
				String pwd = rs.getString("password");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String numero = rs.getString("numero");
				String role = rs.getString("role");
				Personne u;
				if(role.equals("ADMIN")) {
					u = new Administrateur(identifiant, nom, prenom, login, pwd, role, email, numero);
					user.add(u);
				} else if(role.equals("SECRETAIRE")){
					u = new Secretaire(identifiant, nom, prenom, login, pwd, role, email, numero);
					user.add(u);
				}else if (role.equals("CAISSIER")){
					u = new Caissier(identifiant, nom, prenom, login, pwd, role, email, numero);
					user.add(u);
				}
			}
		} catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
		return user;
	}

	@Override
	public Personne read(int id) throws DaoException {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * From utilisateurs where id=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.first()) {
				String login = rs.getString("login");
				String pwd = rs.getString("password");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String numero = rs.getString("numero");
				String role = rs.getString("role");
				Personne user = new Personne(login,pwd,nom,prenom,email,numero,role);
				return user;
			}
		} catch (Exception e) {
			throw new DaoException(e.getMessage());
		}

		return null;
	}	



	@Override
	public List<Personne> list1() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Personne read2(String identifiant) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void update2(Personne obj) throws DaoException {
		// TODO Auto-generated method stub
		
	}
	

}
