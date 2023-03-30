package sn.esmt.java.dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sn.esmt.java.dataSource.Dao;
import sn.esmt.java.exception.DaoException;
import sn.esmt.java.model.Rubrique;

public class RubriqueDaoImpl implements Dao <Rubrique> {

	@Override
	public void create(Rubrique obj) throws DaoException {
		try (Connection connection = DBManager.getConnection()){
			
			String query = "Insert into Rubrique (id, section, nom_rubrique, classe, montant, date_limite) values (?, ?, ?, ?, ?, ?)";	
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1,obj.getId());
			ps.setString(2, obj.getSection());
			ps.setString(3,obj.getNom_rubrique());
			ps.setString(4,obj.getClasse());
			ps.setDouble(5,obj.getMontant());
			ps.setString(6, obj.getDate_limite());
	
			
			ps.executeUpdate();
			
		}catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
		
	}
	@Override
	public void update(Rubrique obj) throws DaoException {
		
			try (Connection connection = DBManager.getConnection()){
			String query = "Update Rubrique Set section=?, nom_rubrique=?, classe=?, montant=?, date_limite=? Where id=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(6,obj.getId());
			ps.setString(1, obj.getSection());
			ps.setString(2,obj.getNom_rubrique());
			ps.setString(3,obj.getClasse());
			ps.setDouble(4,obj.getMontant());
			ps.setString(5, obj.getDate_limite());
			
			ps.executeUpdate();
			
		}catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
		
	}
	
	@Override
	public void delete(int id) throws DaoException {
		try (Connection connection = DBManager.getConnection()){
			
			
			String query = "Delete From Rubrique Where id=?";
	
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
	}
	
	
	@Override
	public Rubrique read(int id) throws DaoException {
		try (Connection connection = DBManager.getConnection()){
			
			String query = "Select * from Rubrique where id=?";	
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.first()) {
				String section = rs.getString("section");
				String nom = rs.getString("nom_rubrique");
				String classe = rs.getString("classe");
				Double scolarite= rs.getDouble("montant");
				String date= rs.getString("date_limite");
				
				Rubrique u1= new Rubrique (section,nom,classe,scolarite,date);
				return u1;
			}
		
			
		}catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
		return null;
	}

	

	

	@Override
	public List<Rubrique> list() throws DaoException {
		List<Rubrique> r1 = new ArrayList<>();
		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * from Rubrique";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String section = rs.getString("section");
				String nom = rs.getString("nom_rubrique");
				String classe = rs.getString("classe");
				Double scolarite= rs.getDouble("montant");
				String date= rs.getString("date_limite");
				
				Rubrique u = new Rubrique(id, section, nom, classe, scolarite, date);
				r1.add(u);
			}
		} catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
		return r1;
	}

	@Override
	public List<Rubrique> list1() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Rubrique read2(String identifiant) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void update2(Rubrique obj) throws DaoException {
		// TODO Auto-generated method stub
		
	}
}	
	
