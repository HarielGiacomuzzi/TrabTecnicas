package business;

import java.util.Date;
import java.util.List;

import Persistencia.BemDAOException;
import Persistencia.BemDAOOracle;
import Persistencia.LeilaoDAOException;
import Persistencia.LeilaoDAOOracle;
import Persistencia.UsuarioDAOException;
import Persistencia.UsuarioDAOOracle;

public class LeilaoFachada {
	static LeilaoFachada leilao;
	private UsuarioDAO usuarioDao;
	private LeilaoDAO leilaoDao;
	private BemDAO bemDao;
	private int IDUsuarioLogado;
	
	
	private LeilaoFachada(){
		usuarioDao = UsuarioDAOOracle.getInstance();
		leilaoDao = LeilaoDAOOracle.getInstance();
		bemDao = BemDAOOracle.getInstance();
	}
	
	public static LeilaoFachada getInstance(){
		if(leilao == null){
			leilao = new LeilaoFachada();
		}
		return leilao;
	}
	
	public String getNomeUsuarioLogado() throws FachadaException{
		try{
		Usuario user = usuarioDao.getUserByID(IDUsuarioLogado);
		return user.getNome();
		} catch(UsuarioDAOException e){
			throw new FachadaException(e.getMessage());
		}
	}
	
	public List<Usuario> getAllUsers() {
		return null;
	}

	public Usuario insertUsuario(String nome, String cpf, String cnpj, String email,String senha) throws FachadaException {
		/*Inserir validações */
		
		try{
			int id = usuarioDao.getNextId();
			Usuario user = new Usuario(id, nome,cpf,cnpj,email,senha);
			boolean ok = usuarioDao.insertUser(user);
			if(ok){
				/*INSERIR aviso aos listeners, se implementarmos isso*/
				return user;
			}
			return null;
		} catch(UsuarioDAOException e){
			/*INSERIR throw de Exceção da camada de negócio*/
			throw new FachadaException(e.getMessage());
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
			/*INSERIR throw de Exceção da camada de negócio*/
			return null;
			
		}
	}
	
	public Bem insertBem(int idLeilao, String descBreve, String descCompleta, int idCategoria){
		try{
		int id = bemDao.getNextId();
		Bem bem = new Bem(id,idLeilao,descBreve,descCompleta,idCategoria);
		
		boolean ok = bemDao.insertBem(bem);
		
		if(ok){
			return bem;
		}
		return null;
		
		} catch(BemDAOException e){
			return null;
		}
		
	}
	
	public boolean efetuaLogin(String email, String senha) throws FachadaException{
		try{
			int id = usuarioDao.validaLogin(email, senha);
			if(id==0)return false;
			IDUsuarioLogado = id;
			return true;
			
		} catch(UsuarioDAOException e){
			throw new FachadaException(e.getMessage());
		}
	}
	
	

}
