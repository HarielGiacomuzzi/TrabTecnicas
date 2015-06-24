package business;

import Persistencia.CategoriaDAOException;

public interface CategoriaDAO {

	public abstract Categoria getCategoriaByID(int id) throws CategoriaDAOException;

	public abstract boolean insertCategoria(Categoria cat) throws CategoriaDAOException;

	public abstract boolean removeCategoria(Categoria cat) throws CategoriaDAOException;

}
