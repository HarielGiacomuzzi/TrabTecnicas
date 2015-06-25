package Apresentacao;
import Persistencia.BemDAOException;
import Persistencia.BemDAOOracle;
import Persistencia.CategoriaDAOException;
import Persistencia.CategoriaDAOOracle;
import Persistencia.LanceDAOException;
import Persistencia.LanceDAOOracle;
import Persistencia.LeilaoDAOException;
import Persistencia.LeilaoDAOOracle;
import Persistencia.OracleJDBC;
import Persistencia.UsuarioDAOException;
import Persistencia.UsuarioDAOOracle;


public class mainTestingApp {

	public static void main(String[] args) {
		BemDAOOracle u = new BemDAOOracle();
		try {
			System.out.println(u.getNextId());
		} catch (BemDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
