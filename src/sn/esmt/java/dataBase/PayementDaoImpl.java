package sn.esmt.java.dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import sn.esmt.java.dataSource.Dao;
import sn.esmt.java.exception.DaoException;
import sn.esmt.java.model.Payement;

public class PayementDaoImpl implements Dao <Payement> {

	@Override
	public void create(Payement obj) throws DaoException {
		try (Connection connection = DBManager.getConnection()){
			
			String query = "Insert into Paiement (id, identifiant, nom, prenom, classe, montant_scolarite, numero_recue, date_paiement, montant_inscription, observation_inscription) values (?, ?, ?, ?, ?, ?,?,?,?,?)";	
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1,obj.getId());
			ps.setString(2, obj.getIdentifiant());
			ps.setString(3,obj.getNom());
			ps.setString(4,obj.getPrenom());
			ps.setString(5,obj.getClasse());
			ps.setDouble(6, obj.getMontant_scolarite());
			ps.setString(7, obj.getNumero_recue());
			ps.setString(8, obj.getDate_paiement());
			ps.setDouble(9, obj.getMontant_inscription());
			ps.setString(10, obj.getObservation());
			ps.executeUpdate();
			
		}catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
		
	}
	@Override
	public void update(Payement obj) throws DaoException {
		
			try (Connection connection = DBManager.getConnection()){
			String query = "Update Paiement Set identifiant=?, nom=?, prenom=?, classe=?, montant_scolarite=?, numero_recue=?, date_paiement=?, montant_inscription=?, observation_inscription=? Where id=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(10, obj.getId());
			ps.setString(1, obj.getIdentifiant());
			ps.setString(2,obj.getNom());
			ps.setString(3,obj.getPrenom());
			ps.setString(4,obj.getClasse());
			ps.setDouble(5, obj.getMontant_scolarite());
			ps.setString(6, obj.getNumero_recue());
			ps.setString(7, obj.getDate_paiement());
			ps.setDouble(8, obj.getMontant_inscription());
			ps.setString(9, obj.getObservation());
			
			ps.executeUpdate();
			
		}catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
		
	}
	
	@Override
	public void delete(int id) throws DaoException {
		try (Connection connection = DBManager.getConnection()){
			
			
			String query = "Delete From Paiement Where id=?";
	
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
	}
	
	
	@Override
	public Payement read(int id) throws DaoException {
		try (Connection connection = DBManager.getConnection()){
			
			String query = "Select * from Paiement where id=?";	
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.first()) {
				String identifiant = rs.getString("identifiant");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String classe = rs.getString("classe");
				Double montant_scol = rs.getDouble("montant_scolarite");
				String num = rs.getString("numero_recue");
				String date = rs.getString("date_paiement");
				Double ins= rs.getDouble("montant_inscription");
				String obs= rs.getString("observation_inscription");
				
				Payement payer = new Payement(identifiant, nom, prenom, classe, montant_scol, num, date, ins, obs);
				return payer;
			}
		
			
		}catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
		return null;
	}

	

	

	@Override
	public List<Payement> list() throws DaoException {
		List<Payement> pay = new ArrayList<>();
		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * from Paiement";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String identifiant = rs.getString("identifiant");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String classe = rs.getString("classe");
				Double montant_scol = rs.getDouble("montant_scolarite");
				String num = rs.getString("numero_recue");
				String date = rs.getString("date_paiement");
				Double ins= rs.getDouble("montant_inscription");
				String obs= rs.getString("observation_inscription");
				
				Payement payer = new Payement(id,identifiant, nom, prenom, classe, montant_scol, num, date, ins, obs);
				pay.add(payer);
			}
		} catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
		return pay;
	}

	@Override
	public List<Payement> list1() throws DaoException {
		return null;
	}
	
	
	@Override
	public Payement read2(String identifiant) throws DaoException {
		try (Connection connection = DBManager.getConnection()){	
			String query = "Select * from Paiement where identifiant=?";	
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, identifiant);
			ResultSet rs = ps.executeQuery();
			if(rs.first()) {
				String identifiant1 = rs.getString("identifiant");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String classe = rs.getString("classe");
				Double montant_scol = rs.getDouble("montant_scolarite");
				String num = rs.getString("numero_recue");
				String date = rs.getString("date_paiement");
				Double ins= rs.getDouble("montant_inscription");
				String obs= rs.getString("observation_inscription");
				
				Payement payer = new Payement(identifiant1, nom, prenom, classe, montant_scol, num, date, ins, obs);
				return payer;
			}
		}catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
		return null;
	}
	@Override
	public void update2(Payement obj) throws DaoException {
		try (Connection connection = DBManager.getConnection()){
			String query = "Update Paiement Set observation_inscription=? Where id=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(2,obj.getId());
			ps.setString(1, obj.getObservation());
			
			ps.executeUpdate();
			
		}catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
		
		
	}

}
