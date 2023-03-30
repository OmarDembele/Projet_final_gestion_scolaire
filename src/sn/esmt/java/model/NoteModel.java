package sn.esmt.java.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class NoteModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	
	private Vector<Object[]> rows3 = new Vector<Object[]>();
	private List<Notes> notes = new ArrayList<Notes>();
	protected String [] columns = {"id_note", "Identifiant_eleve", "Nom", "Prenom", "Cycle", "Classe", "Module", "Valeur_note", "Coeff"}; 
	
	@Override	
	public int getColumnCount() {
		return columns.length;
	}

	@Override
	public int getRowCount() {
		return rows3.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {		
		Object [] obj = rows3.get(rowIndex);
		return obj[columnIndex];
	}
	
	@Override
	public String getColumnName(int arg0) {
		return columns[arg0];
	}

	public void setNotes(List<Notes> notes) {
		clear();
		this.notes.addAll(notes);
		for (Notes note : notes ) {
			rows3.add( new Object [] {
					note.getId_note(),
					note.getIdentifiant(),
					note.getNom(), 
					note.getPrenom(), 
					note.getCycle(),
					note.getClasse(),
					note.getModule(),
					note.getValeur_note(),
					note.getCoeff(),
					
			});
		}
		fireTableDataChanged();
	}

	
	public void clear () {
		rows3.clear();
		notes.clear();
		
		fireTableDataChanged();
	}
	
	public List<Notes> getNotes() { 
		return notes; 
	}
	


}
