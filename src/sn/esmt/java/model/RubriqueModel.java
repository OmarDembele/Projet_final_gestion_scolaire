package sn.esmt.java.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class RubriqueModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;

	private Vector<Object[]> rows = new Vector<Object[]>();
	private List<Rubrique> rubriques = new ArrayList<Rubrique>();
	protected String [] columns = {"Id", "Section", "Nom Rubrique", "classe", "Montant", "date_limite"}; 
	
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

	public void setRub(List<Rubrique> rubs) {
		clear();
		this.rubriques.addAll(rubs);

		for (Rubrique u : rubs) {
			rows.add(new Object[] { 
					u.getId(),
					u.getSection(),
					u.getNom_rubrique(),
					u.getClasse(),
					u.getMontant(),
					u.getDate_limite(),
				});
		}

		fireTableDataChanged();
	}
	
	public void clear() {
		rows.clear();
		rubriques.clear();

		fireTableDataChanged();
	}
	
	public List<Rubrique> getRub() {
		return rubriques;
	}
}
