package business;

import Persistencia.BemDAOException;

public interface BemDAO {

	public abstract Bem getBemByID(int id) throws BemDAOException;

	public abstract boolean insertBem(Bem bem);

	public abstract boolean removeBem(Bem bem);

}
