package business;

import java.util.List;

public interface LanceDAO {

	public abstract Lance getLanceByID(int id);

	public abstract List<Lance> getLanceByLeilao(Leilao leilao);

	public abstract boolean insertLance(Lance lance);

	public abstract boolean removeLance(Lance lance);

}
