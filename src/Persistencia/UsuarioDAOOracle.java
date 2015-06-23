package Persistencia;

import business.UsuarioDAO;
import business.Usuario;

public class UsuarioDAOOracle implements UsuarioDAO {


	/**
	 * @see Negocio.UsuarioDAO#getUserByID(int)
	 */
	public Usuario getUserByID(int id) {
		return null;
	}


	/**
	 * @see Negocio.UsuarioDAO#getUserByName(java.lang.String)
	 */
	public Usuario getUserByName(String name) {
		return null;
	}


	/**
	 * @see Negocio.UsuarioDAO#insertUser(Negocio.Usuario)
	 * 
	 *  
	 */
	public boolean insertUser(Usuario user) {
		return false;
	}


	/**
	 * @see Negocio.UsuarioDAO#removeUser(Negocio.Usuario)
	 */
	public boolean removeUser(Usuario user) {
		return false;
	}

}
