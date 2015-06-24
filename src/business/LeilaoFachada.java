package business;

import java.util.List;
import Persistencia.UsuarioDAOOracle;

public class LeilaoFachada {
	UsuarioDAOOracle usuarioDao;
	
	public LeilaoFachada(){
		usuarioDao = UsuarioDAOOracle.getInstance();
	}
	
	public List<Usuario> getAllUsers() {
		return null;
	}

	public boolean insertUsuario(Usuario usuario) {
		return false;
	}
	
	

}
