package business;

public interface LeilaoDAO {

	public abstract Leilao getLeilaoByID(int id);

	public abstract boolean insertLeilao(Leilao leilao);

	public abstract boolean removeLeilao(Leilao leilao);

}
