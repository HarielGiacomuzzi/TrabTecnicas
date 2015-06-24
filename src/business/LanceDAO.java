package business;

import java.util.List;

import Persistencia.LanceDAOException;

public interface LanceDAO {

	public abstract Lance getLanceByID(int id) throws LanceDAOException;

	public abstract List<Lance> getLanceByLeilao(Leilao leilao) throws LanceDAOException;

	public abstract boolean insertLance(Lance lance) throws LanceDAOException;

	public abstract boolean removeLance(Lance lance) throws LanceDAOException;

}
