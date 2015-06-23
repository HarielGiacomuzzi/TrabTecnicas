package business;

public interface UsuarioDAO {

	public abstract Usuario getUserByID(int id);

	public abstract Usuario getUserByName(String name);

	public abstract boolean insertUser(Usuario user);

	public abstract boolean removeUser(Usuario user);

}
