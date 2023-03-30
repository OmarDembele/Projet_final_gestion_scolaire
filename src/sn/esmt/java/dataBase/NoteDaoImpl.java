package sn.esmt.java.dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import sn.esmt.java.dataSource.Dao;
import sn.esmt.java.exception.DaoException;
import sn.esmt.java.model.Notes;

public class NoteDaoImpl implements Dao<Notes>{

	@Override
	public void create(Notes obj) throws DaoException {
		try(Connection connection = DBManager.getConnection()){
			String query = "Insert into Notes(id_note, identifiant_eleve ,nom_eleve, prenom_eleve, valeur_note, module, classe, cycle, coeff) values(?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement ps =connection.prepareStatement(query);
			ps.setInt(1, (int)obj.getId_note());
			ps.setString(2, obj.getIdentifiant());
			ps.setString(3, obj.getNom());
			ps.setString(4, obj.getPrenom());
			ps.setDouble(5, (double) obj.getValeur_note());
			ps.setString(6, obj.getModule());
			ps.setString(7, obj.getClasse());
			ps.setString(8, obj.getCycle());
			ps.setInt(9, (int) obj.getCoeff());
			ps.executeUpdate();
		}catch(Exception e) {
			throw new DaoException(e.getMessage());
		}

		
	}

	@Override
	public Notes read(int id) throws DaoException {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * From Notes where id_note=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.first()) {
				int id_note = rs.getInt("id_note");
				String identifiant = rs.getString("identifiant_eleve");
				String nom = rs.getString("nom_eleve");
				String prenom = rs.getString("prenom_eleve");
				double value = rs.getDouble("valeur_note");
				String module = rs.getString("module");
				String classe = rs.getString("classe");
				String cycle = rs.getString("cycle");
				int coeff = rs.getInt("coeff");
				Notes note = new Notes(id_note,identifiant, nom, prenom, value, module, classe,cycle, coeff);
				return note;
			}
		}
		catch (Exception e) {
			throw new DaoException(e.getMessage());
			}
		return null;
	}

	@Override
	public void update(Notes obj) throws DaoException {
		try (Connection connection = DBManager.getConnection()) {
			String query = "Update Notes Set identifiant_eleve=?, nom_eleve=?, prenom_eleve=?, valeur_note=?, module=?, classe=?, cycle=?, coeff=? Where id_note=?";
			
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(9, (int)obj.getId_note());
			ps.setString(1, obj.getIdentifiant());
			ps.setString(2, obj.getNom());
			ps.setString(3, obj.getPrenom());
			ps.setDouble(4, (double) obj.getValeur_note());
			ps.setString(5, obj.getModule());
			ps.setString(6, obj.getClasse());
			ps.setString(7, obj.getCycle());
			ps.setInt(8, (int) obj.getCoeff());
			ps.executeUpdate();
			} 
		catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
		
	}

	@Override
	public void delete(int id) throws DaoException {
		try(Connection connection = DBManager.getConnection()){
			String query="Delete From Notes where id_note=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			}
		catch (Exception e) {
			throw new DaoException(e.getMessage());
		}	
		
	}

	@Override
	public List<Notes> list() throws DaoException {
		List<Notes> notes = new ArrayList<>();
		try (Connection connection = DBManager.getConnection()) {
			String query = "Select * From Notes";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int id_note = rs.getInt("id_note");
				String identifiant = rs.getString("identifiant_eleve");
				String nom = rs.getString("nom_eleve");
				String prenom = rs.getString("prenom_eleve");
				double value = rs.getDouble("valeur_note");
				String module = rs.getString("module");
				String classe = rs.getString("classe");
				String cycle = rs.getString("cycle");
				int coeff = rs.getInt("coeff");
				Notes note = new Notes(id_note, identifiant, nom, prenom, value, module, classe, cycle, coeff);
				notes.add(note);
			}
		} 
		catch (Exception e) {
		throw new DaoException(e.getMessage());
		}
		return notes;
	}

	@Override
	public List<Notes> list1() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Notes read2(String identifiant) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update2(Notes obj) throws DaoException {
		// TODO Auto-generated method stub
		
	}

}
