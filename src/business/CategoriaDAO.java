package business;

public interface CategoriaDAO {

	public abstract boolean getCategoriaByID(int id);

	public abstract boolean insertBem(Bem bem);

	public abstract boolean removeBem(Bem bem);

}
