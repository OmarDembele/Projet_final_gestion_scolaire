package sn.esmt.java.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class EleveModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	
	private Vector<Object[]> rows = new Vector<Object[]>();
	private List<Eleves> etudiants = new ArrayList<Eleves>();
	protected String [] columns = {"Id", "Nom", "Prenom", 
			"Date_naissance", "Lieu_naissance", "Email", "Indentifiant", "Genre", "Adresse", "Section",
			"Observation_inscription", "Classe"}; 
	
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

	public void setEtudiants(List<Eleves> etudiants) {
		clear ();
		this.etudiants.addAll(etudiants);
		for (Eleves etudiant : etudiants ) {
			rows.add( new Object [] {
					etudiant.getId_etudiant(),
					etudiant.getNom_etudiant(), 
					etudiant.getPrenom_etudiant(), 
					etudiant.getDate_naissance(),
					etudiant.getLieu_naissance(),
					etudiant.getEmail_etudiant(),
					etudiant.getIdentifiant(),
					etudiant.getGenre(),
					etudiant.getAdresse(),
					etudiant.getSection(),
					etudiant.getObservation_inscription(),
					etudiant.getClasse(),
			});
		}

		fireTableDataChanged();
	}

	
	public void clear () {
		rows.clear();
		etudiants.clear();
		
		fireTableDataChanged();
	}
	
	public List<Eleves> getEtudiants() { 
		return etudiants; 
	}
}
