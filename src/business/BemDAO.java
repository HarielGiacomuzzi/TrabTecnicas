package business;

import java.util.List;

import Persistencia.BemDAOException;

public interface BemDAO {

	public abstract Bem getBemByID(int id) throws BemDAOException;

	public abstract boolean insertBem(Bem bem) throws BemDAOException;

	public abstract boolean removeBem(Bem bem) throws BemDAOException;
	
	public int getNextId() throws BemDAOException;
	
	public abstract List<Bem> getAllBensByID(int id) throws BemDAOException;

}
