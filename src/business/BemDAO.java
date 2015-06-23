package business;

public interface BemDAO {

	public abstract Bem getBemByID(int id);

	public abstract boolean insertBem(Bem bem);

	public abstract boolean removeBem(Bem bem);

}
