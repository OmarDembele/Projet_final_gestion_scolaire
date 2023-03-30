package sn.esmt.java.dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import sn.esmt.java.dataSource.Dao;
import sn.esmt.java.exception.DaoException;
import sn.esmt.java.model.Eleves;

public class EleveDaoImple implements Dao<Eleves>{

	@Override
	public void create(Eleves obj) throws DaoException {
		try(Connection connection = DBManager.getConnection()){
			String query = "Insert into Eleve(id, nom_eleve, prenom_eleve, date_naissance, lieu_naissance, email_eleve, identifiant_eleve, genre, adresse, section, observation_inscription, classe) values(?,?,?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement ps =connection.prepareStatement(query);
			ps.setInt(1, (int)obj.getId_etudiant());
			ps.setString(2, obj.getNom_etudiant());
			ps.setString(3, obj.getPrenom_etudiant());
			ps.setString(4, obj.getDate_naissance());
			ps.setString(5, obj.getLieu_naissance());
			ps.setString(6, obj.getEmail_etudiant());
			ps.setString(7, obj.getIdentifiant());
			ps.setString(8, obj.getGenre());
			ps.setString(9, obj.getAdresse());
			ps.setString(10, obj.getSection());
			ps.setString(11,  obj.getObservation_inscription());
			ps.setString(12, obj.getClasse());
			ps.executeUpdate();
		}catch(Exception e) {
			throw new DaoException(e.getMessage());
		}
		
	}

	@Override
	public Eleves read(int id) throws DaoException {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * From Eleve where id=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.first()) {
				int id_etudiant = rs.getInt("id");
				String nom_etudiant = rs.getString("nom_eleve");
				String prenom_etudiant = rs.getString("prenom_eleve");
				String date_naissance = rs.getString("date_naissance");
				String lieu_naissance = rs.getString("lieu_naissance");
				String email_etudiant = rs.getString("email_eleve");
				String identifiant = rs.getString("identifiant_eleve");
				String genre = rs.getString("genre");
				String adresse = rs.getString("adresse");
				String section = rs.getString("section");
				String obs = rs.getString("observation_inscription");
				String classe = rs.getString("classe");
				
				Eleves etudiant = new Eleves(id_etudiant, nom_etudiant, prenom_etudiant,  date_naissance, lieu_naissance, email_etudiant, identifiant, genre,adresse, section, obs, classe);
			
				return etudiant;
			}
		}
		catch (Exception e) {
			throw new DaoException(e.getMessage());
			}
		return null;
	}

	@Override
	public void update(Eleves obj) throws DaoException {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Update Eleve Set nom_eleve=?, prenom_eleve=?, date_naissance=?, lieu_naissance=?, email_eleve=?, identifiant_eleve=?, genre=?, adresse=?, section=?, observation_inscription=?, classe=? Where id=?";
			
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(12, (int)obj.getId_etudiant());
			ps.setString(1, obj.getNom_etudiant());
			ps.setString(2, obj.getPrenom_etudiant());
			ps.setString(3, obj.getDate_naissance());
			ps.setString(4, obj.getLieu_naissance());
			ps.setString(5, obj.getEmail_etudiant());
			ps.setString(6, obj.getIdentifiant());
			ps.setString(7, obj.getGenre());
			ps.setString(8, obj.getAdresse());
			ps.setString(9, obj.getSection());
			ps.setString(10, obj.getObservation_inscription());
			ps.setString(11, obj.getClasse());
			ps.executeUpdate();
			} 
		catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
		
	}

	@Override
	public void delete(int id) throws DaoException {
		try(Connection connection = DBManager.getConnection()){
			String query="Delete from Eleve where id=?";
			
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			}
		catch (Exception e) {
			throw new DaoException(e.getMessage());
		}	
		
	}

	@Override
	public List<Eleves> list() throws DaoException {
		List<Eleves> eleves = new ArrayList<>();
		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * From Eleve";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int id_etudiant = rs.getInt("id");
				String nom_etudiant = rs.getString("nom_eleve");
				String prenom_etudiant = rs.getString("prenom_eleve");
				String date_naissance = rs.getString("date_naissance");
				String lieu_naissance = rs.getString("lieu_naissance");
				String email_etudiant = rs.getString("email_eleve");
				String identifiant = rs.getString("identifiant_eleve");
				String genre = rs.getString("genre");
				String adresse = rs.getString("adresse");
				String section = rs.getString("section");
				String obs = rs.getString("observation_inscription");
				String classe = rs.getString("classe");
				
				Eleves eleve = new Eleves(id_etudiant, nom_etudiant, prenom_etudiant,  date_naissance, lieu_naissance,email_etudiant,identifiant, genre,adresse, section, obs, classe);
			
				eleves.add(eleve);
			}
		} 
		catch (Exception e) {
		throw new DaoException(e.getMessage());
		}
		return eleves;
	}

	@Override
	public List<Eleves> list1() throws DaoException {
		return null;
	}

	@Override
	public Eleves read2(String identifiant) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update2(Eleves obj) throws DaoException {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Update Eleve Set observation_inscription=? Where identifiant_eleve=?";
			
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, obj.getObservation_inscription());
			ps.setString(2, obj.getIdentifiant());
			ps.executeUpdate();
			} 
		catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
		
	}
	
}
