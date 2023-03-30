package sn.esmt.java.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;



public class UserModel extends AbstractTableModel {
	
	
	private static final long serialVersionUID = 1L;

	private Vector<Object[]> rows = new Vector<Object[]>();
	private List<Personne> personnes = new ArrayList<Personne>();
	protected String [] columns = {"Id", "rôle", "nom" , "prenom", "email","numéro","login", "password"}; 
	
	/**
	 * 
	 */
	@Override	
	public int getColumnCount() {
		return columns.length;
	}

	@Override
	public int getRowCount() {
		return rows.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {		
		Object [] obj = rows.get(rowIndex);
		return obj[columnIndex];
	}
	
	@Override
	public String getColumnName(int arg0) {
		return columns[arg0];
	}

	public void setUsers(List<Personne> user) {
		clear();

		this.personnes.addAll(user);

		for (Personne u : user) {
			rows.add(new Object[] { u.getId(),u.getRole(),u.getNom(),u.getPrenom(),u.getEmail(),u.getNuméro(), u.getLogin(), u.getPassword()});
		}

		fireTableDataChanged();
	}
	
	public void clear() {
		rows.clear();
		personnes.clear();

		fireTableDataChanged();
	}
	
	public List<Personne> getUsers() {
		return personnes;
	}

}
