package business;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import business.Bem;
import Persistencia.BemDAOException;
import Persistencia.BemDAOOracle;
import Persistencia.CategoriaDAOException;
import Persistencia.CategoriaDAOOracle;
import Persistencia.LeilaoDAOException;
import Persistencia.LeilaoDAOOracle;
import Persistencia.UsuarioDAOException;
import Persistencia.UsuarioDAOOracle;

public class LeilaoFachada {
	static LeilaoFachada leilao;
	private UsuarioDAO usuarioDao;
	private LeilaoDAO leilaoDao;
	private CategoriaDAO categoriaDao;
	private BemDAO bemDao;
	private int IDUsuarioLogado;
	
	
	private LeilaoFachada(){
		usuarioDao = UsuarioDAOOracle.getInstance();
		leilaoDao = LeilaoDAOOracle.getInstance();
		bemDao = BemDAOOracle.getInstance();
		categoriaDao = CategoriaDAOOracle.getInstance();
	}
	
	public static LeilaoFachada getInstance(){
		if(leilao == null){
			leilao = new LeilaoFachada();
		}
		return leilao;
	}
	
	public List<Categoria> getCategorias() throws FachadaException{
		try{
		return categoriaDao.getAllCategorias();
		}
		catch(CategoriaDAOException ex){
			throw new FachadaException(ex.getMessage());
		}
	}
	
	public List<Leilao> getLeiloes() throws FachadaException{
		try{
		return leilaoDao.getLeiloes();
		}
		catch(LeilaoDAOException ex){
			throw new FachadaException(ex.getMessage());
		}
	}
	
	public Leilao getLeilaoByID(int idLeilao) throws FachadaException{
		try{
			return leilaoDao.getLeilaoByID(idLeilao);
		}
		catch(LeilaoDAOException ex){
			throw new FachadaException(ex.getMessage());
		}
	}
	
	public String getNomeUsuarioLogado() throws FachadaException{
		try{
		Usuario user = usuarioDao.getUserByID(IDUsuarioLogado);
		return user.getNome();
		} catch(UsuarioDAOException e){
			throw new FachadaException(e.getMessage());
		}
	}
	
	public String getNomeByID(int id) throws FachadaException{
		try{
		Usuario user = usuarioDao.getUserByID(id);
		return user.getNome();
		} catch(UsuarioDAOException e){
			throw new FachadaException(e.getMessage());
		}
	}
	
	public int getIDUsuarioLogado(){
		return IDUsuarioLogado;
	}
	
	public List<Usuario> getAllUsers() {
		return null;
	}

	public Usuario insertUsuario(String nome, String cpf, String cnpj, String email,String senha) throws FachadaException {
		/*Inserir valida��es */
		
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
			/*INSERIR throw de Exce��o da camada de neg�cio*/
			throw new FachadaException(e.getMessage());
		}
	}
	
	public Leilao insertLeilao(String tipoLeilao, String tipoLance, Date inicio, Date fim, int vendedorID, double preco){
		int id = 1;
		try {
			id = leilaoDao.getNextId();
		} catch (LeilaoDAOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Leilao leilao = new Leilao(id,tipoLeilao,tipoLance,inicio,fim,vendedorID,preco);
		
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
	
	public Bem insertBem(int idLeilao, String descBreve, String descCompleta, String string, double valor){
		try{
		int id = bemDao.getNextId();
		Bem bem = new Bem(id, idLeilao, descBreve, descCompleta, string,valor);
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

	public LinkedList<Bem> getBens(int i) {
		try {
			return (LinkedList<Bem>) bemDao.getAllBensByID(i);
		} catch (BemDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	

}
