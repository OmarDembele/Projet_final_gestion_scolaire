package sn.esmt.java.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class ModuleModel extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Vector<Object[]> rows3 = new Vector<Object[]>();
	private List<Module> modules = new ArrayList<Module>();
	protected String [] columns = {"id", "nom Module", "Coefficient"}; 
		

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

	public void setModule(List<Module> module) {
		clear();
		this.modules.addAll(module);
		for (Module mod : module ) {
			rows3.add( new Object [] {
					mod.getId_module(),
					mod.getNom_module(),
					mod.getCoeff()
			});
		}
		fireTableDataChanged();
	}

	
	public void clear () {
		rows3.clear();
		modules.clear();
		
		fireTableDataChanged();
	}
	
	public List<Module> getModules() { 
		return modules; 
	}
	

}
