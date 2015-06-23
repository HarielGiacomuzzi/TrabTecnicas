package Persistencia;

import business.LanceDAO;
import business.Lance;
import java.util.List;
import business.Leilao;

public class LanceDAOOracle implements LanceDAO {


	/**
	 * @see Negocio.LanceDAO#getLanceByID(int)
	 */
	public Lance getLanceByID(int id) {
		return null;
	}


	/**
	 * @see Negocio.LanceDAO#getLanceByLeilao(Negocio.Leilao)
	 */
	public List<Lance> getLanceByLeilao(Leilao leilao) {
		return null;
	}


	/**
	 * @see Negocio.LanceDAO#insertLance(Negocio.Lance)
	 */
	public boolean insertLance(Lance lance) {
		return false;
	}


	/**
	 * @see Negocio.LanceDAO#removeLance(Negocio.Lance)
	 */
	public boolean removeLance(Lance lance) {
		return false;
	}

}
