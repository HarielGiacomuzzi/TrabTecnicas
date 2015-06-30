package business;

import Persistencia.LeilaoDAOException;
import java.util.List;

public interface LeilaoDAO {

	public abstract Leilao getLeilaoByID(int id) throws LeilaoDAOException;

	public abstract boolean insertLeilao(Leilao leilao) throws LeilaoDAOException;

	public abstract boolean removeLeilao(Leilao leilao) throws LeilaoDAOException;
	
	public abstract int getNextId() throws LeilaoDAOException;
	
	public abstract List<Leilao> getLeiloes() throws LeilaoDAOException;

}
