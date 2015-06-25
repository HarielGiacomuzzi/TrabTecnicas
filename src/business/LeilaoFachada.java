package business;

import java.util.List;

import Persistencia.UsuarioDAOException;
import Persistencia.UsuarioDAOOracle;

public class LeilaoFachada {
	UsuarioDAOOracle usuarioDao;
	
	public LeilaoFachada(){
		usuarioDao = UsuarioDAOOracle.getInstance();
	}
	
	public List<Usuario> getAllUsers() {
		return null;
	}

	public Usuario insertUsuario(String nome, String cpf, String cnpj, String email) {
		/*Inserir validações */
		int id = 1; /*INSERIR LOGICA DO ID AQUI*/
		Usuario user = new Usuario(id, nome,cpf,cnpj,email);
		
		try{
			boolean ok = usuarioDao.insertUser(user);
			if(ok){
				/*INSERIR aviso aos listeners, se implementarmos isso*/
				return user;
			}
			return null;
		} catch(UsuarioDAOException e){
			/*INSERIR throw de Exceção da camada de negócio*/
			return null;
		}
	}
	
	

}
