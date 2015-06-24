package business;

import Persistencia.LeilaoDAOException;

public interface LeilaoDAO {

	public abstract Leilao getLeilaoByID(int id) throws LeilaoDAOException;

	public abstract boolean insertLeilao(Leilao leilao) throws LeilaoDAOException;

	public abstract boolean removeLeilao(Leilao leilao) throws LeilaoDAOException;

}
