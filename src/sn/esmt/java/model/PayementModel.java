package sn.esmt.java.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class PayementModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	
	private Vector<Object[]> rows = new Vector<Object[]>();
	private List<Payement> payements = new ArrayList<Payement>();
	protected String [] columns = {"Id", "Identifiant", "Nom", "Prenom", "classe", "Montant Scolarite", "Numero recue", "date payement", "Montant Inscription", "Observation"}; 
	
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

	public void setPayements(List<Payement> payement) {
		clear ();
		this.payements.addAll(payement);
		for (Payement pay : payement ) {
			rows.add( new Object [] {
					pay.getId(),
					pay.getIdentifiant(),
					pay.getNom(), 
					pay.getPrenom(), 
					pay.getClasse(),
					pay.getMontant_scolarite(),
					pay.getNumero_recue(),
					pay.getDate_paiement(),
					pay.getMontant_inscription(),
					pay.getObservation(),
			});
		}

		fireTableDataChanged();
	}

	
	public void clear () {
		rows.clear();
		payements.clear();
		
		fireTableDataChanged();
	}
	
	public List<Payement> getPayements() { 
		return payements; 
	}

}
