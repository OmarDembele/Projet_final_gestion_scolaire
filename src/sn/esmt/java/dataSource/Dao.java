package sn.esmt.java.dataSource;

import java.util.List;
import sn.esmt.java.exception.DaoException;


public interface Dao<T> {
	
	public void create (T obj) throws DaoException;
	
	public T read(int id) throws DaoException;
	
	public T read2(String identifiant) throws DaoException;
	
	public void update (T obj) throws DaoException;
	
	public void update2 (T obj) throws DaoException;
	
	public void delete (int id) throws DaoException;
	
	public List<T> list() throws DaoException;
	
	public List<T> list1() throws DaoException;
	
	
}
