package business;

import java.util.Date;
import java.util.List;

import Persistencia.LeilaoDAOException;
import Persistencia.LeilaoDAOOracle;
import Persistencia.UsuarioDAOException;
import Persistencia.UsuarioDAOOracle;

public class LeilaoFachada {
	UsuarioDAOOracle usuarioDao;
	LeilaoDAOOracle leilaoDao;
	
	public LeilaoFachada(){
		usuarioDao = UsuarioDAOOracle.getInstance();
		leilaoDao = LeilaoDAOOracle.getInstance();
	}
	
	public List<Usuario> getAllUsers() {
		return null;
	}

	public Usuario insertUsuario(String nome, String cpf, String cnpj, String email) {
		/*Inserir valida��es */
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
			/*INSERIR throw de Exce��o da camada de neg�cio*/
			return null;
		}
	}
	
	public Leilao insertLeilao(char tipoLeilao, char tipoLance, Date inicio, Date fim, Usuario vendedor, double preco){
		int id = 1; /*INSERIR LOGIDA DO ID*/
		Leilao leilao = new Leilao(id,tipoLeilao,tipoLance,inicio,fim,vendedor.getId(),preco);
		
		try{
			boolean ok = leilaoDao.insertLeilao(leilao);
			if(ok){
				return leilao;
			}
			return null;
		} catch(LeilaoDAOException e){
			/*INSERIR throw de Exce��o da camada de neg�cio*/
			return null;
			
		}
	}
	
	

}
