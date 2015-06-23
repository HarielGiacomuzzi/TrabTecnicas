package Persistencia;

import business.LeilaoDAO;
import business.Leilao;

public class LeilaoDAOOracle implements LeilaoDAO {


	/**
	 * @see Negocio.LeilaoDAO#getLeilaoByID(int)
	 */
	public Leilao getLeilaoByID(int id) {
		return null;
	}


	/**
	 * @see Negocio.LeilaoDAO#insertLeilao(Negocio.Leilao)
	 */
	public boolean insertLeilao(Leilao leilao) {
		return false;
	}


	/**
	 * @see Negocio.LeilaoDAO#removeLeilao(Negocio.Leilao)
	 */
	public boolean removeLeilao(Leilao leilao) {
		return false;
	}

}
