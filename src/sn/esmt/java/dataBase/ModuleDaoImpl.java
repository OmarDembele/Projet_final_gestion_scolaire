package sn.esmt.java.dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import sn.esmt.java.model.Module;

import java.util.List;
import sn.esmt.java.dataSource.Dao;
import sn.esmt.java.exception.DaoException;

public class ModuleDaoImpl implements Dao<Module>{

	@Override
	public void create(Module obj) throws DaoException {
		try(Connection connection = DBManager.getConnection()){
			String query = "Insert into Module(id_module, nom_module ,coeff) values(?,?,?)";
			
			PreparedStatement ps =connection.prepareStatement(query);
			ps.setInt(1, (int)obj.getId_module());
			ps.setString(2, obj.getNom_module());
			ps.setInt(3, (int) obj.getCoeff());
			ps.executeUpdate();
		}catch(Exception e) {
			throw new DaoException(e.getMessage());
		}
		
	}

	@Override
	public Module read(int id) throws DaoException {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * From Module where id_module=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.first()) {
				int id_module = rs.getInt("id_module");
				String nom = rs.getString("nom_module");
				int coeff = rs.getInt("coeff");
				Module module = new Module(id_module,nom,coeff);
				return module;
			}
		}
		catch (Exception e) {
			throw new DaoException(e.getMessage());
			}
		return null;
	}

	@Override
	public void update(Module obj) throws DaoException {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Update Module Set id_module=?, nom_module=?, coeff=? Where id_module=?";
			
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, (int)obj.getId_module());
			ps.setString(2, obj.getNom_module());
			ps.setInt(3, (int) obj.getCoeff());
			ps.executeUpdate();
			} 
		catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
		
	}

	@Override
	public void delete(int id) throws DaoException {
		try(Connection connection = DBManager.getConnection()){
			String query="Delete From Module where id_module=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			}
		catch (Exception e) {
			throw new DaoException(e.getMessage());
		}	
		
	}

	@Override
	public List<Module> list() throws DaoException {
		List<Module> modules = new ArrayList<>();
		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * From Module";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int id_module = rs.getInt("id_module");
				String nom_module = rs.getString("nom_module");
				int coeff = rs.getInt("coeff");
				
				
				Module module = new Module(id_module,nom_module, coeff);
				modules.add(module);
			}
		} 
		catch (Exception e) {
		throw new DaoException(e.getMessage());
		}
		return modules;
	}

	@Override
	public List<Module> list1() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Module read2(String identifiant) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update2(Module obj) throws DaoException {
		// TODO Auto-generated method stub
		
	}

}
