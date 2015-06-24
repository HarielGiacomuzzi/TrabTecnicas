package business;

import Persistencia.UsuarioDAOException;

public interface UsuarioDAO {

	public abstract Usuario getUserByID(int id) throws UsuarioDAOException;

	public abstract Usuario getUserByName(String name) throws UsuarioDAOException;

	public abstract boolean insertUser(Usuario user) throws UsuarioDAOException;

	public abstract boolean removeUser(Usuario user) throws UsuarioDAOException;

}
