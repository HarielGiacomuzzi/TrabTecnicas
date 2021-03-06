package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import business.Bem;
import business.BemDAO;

public class BemDAOOracle implements BemDAO {
	private static BemDAOOracle ref;
	
	public static BemDAOOracle getInstance(){
		if(ref==null){
			ref = new BemDAOOracle();
		}
		return ref;
	}


	/**
	 * @throws BemDAOException 
	 * @see Negocio.BemDAO#getBemByID(int)
	 */
	public Bem getBemByID(int id) throws BemDAOException {
		try {
            Connection con = new OracleJDBC().getConnection();
            PreparedStatement sta = con.prepareStatement("select * from bens where leilao_fk = ?");
            sta.setInt(1, id);
            ResultSet resultado = sta.executeQuery();
            Bem b = null;
            if(resultado.next()) {
                int id1 = resultado.getInt("id_bem");
                String descBreve = resultado.getString("desc_Breve");
                String descCompleta = resultado.getString("desc_Completa");
                String idCategoria = resultado.getString("categoria_fk");
                Double valor = resultado.getDouble("valor");
                int idLeilao = resultado.getInt("leilao_fk");
                b = new Bem(id1,idLeilao, descBreve, descCompleta, idCategoria,valor);
            }
            sta.close();
            con.close();
            return b;
        } catch (SQLException ex) {
            throw new BemDAOException(ex.getMessage());
        }
	}
	
	public List<Bem> getAllBensByID(int id) throws BemDAOException {
		try {
            Connection con = new OracleJDBC().getConnection();
            PreparedStatement sta = con.prepareStatement("select * from bens where leilao_fk = ?");
            sta.setInt(1, id);
            ResultSet resultado = sta.executeQuery();
            LinkedList<Bem> lst = new LinkedList<Bem>();
            while(resultado.next()) {
                int id1 = resultado.getInt("id_bem");
                String descBreve = resultado.getString("desc_Breve");
                String descCompleta = resultado.getString("desc_Completa");
                String idCategoria = resultado.getString("categoria_fk");
                int idLeilao = resultado.getInt("leilao_fk");
                Double valor = resultado.getDouble("valor");
                lst.add(new Bem(id1,idLeilao, descBreve, descCompleta, idCategoria,valor));
            }
            sta.close();
            con.close();
            return lst;
        } catch (SQLException ex) {
            throw new BemDAOException(ex.getMessage());
        }
	}


	public int getNextId() throws BemDAOException{
		try {
            Connection con = new OracleJDBC().getConnection();
            PreparedStatement sta = con.prepareStatement("select MAX(id_bem) from bens");
            ResultSet resultado = sta.executeQuery();
            int id = 0;
            if(resultado.next()) {
                id = resultado.getInt(1);
            }
            sta.close();
            con.close();
            return id + 1;
        } catch (SQLException ex) {
            throw new BemDAOException(ex.getMessage());
        }
		
	}
	
	/**
	 * @throws BemDAOException 
	 * @see Negocio.BemDAO#insertBem(Negocio.Bem)
	 */
	public boolean insertBem(Bem bem) throws BemDAOException {
		try {
            Connection con = new OracleJDBC().getConnection();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO bens (id_bem, Categoria_fk, desc_Breve, desc_Completa , leilao_fk,valor) VALUES (?,?,?,?,?,?)");
            stmt.setInt(1, bem.getId());
            stmt.setString(2, bem.getIdCategoria());
            stmt.setString(3, bem.getDescBreve());
            stmt.setString(4, bem.getDescCompleta());
            stmt.setInt(5, bem.getIdLeilao());
            stmt.setInt(6, bem.getValor().intValue());
            int ret = stmt.executeUpdate();
            con.close();
            return (ret>0);
        } catch (SQLException ex) {
            throw new BemDAOException("Falha ao adicionar.", ex);
        }
	}


	/**
	 * @throws BemDAOException 
	 * @see Negocio.BemDAO#removeBem(Negocio.Bem)
	 */
	public boolean removeBem(Bem bem) throws BemDAOException {
		try {
            Connection con = new OracleJDBC().getConnection();
            PreparedStatement stmt = con.prepareStatement("delete from bens where id_bem = ?");
            stmt.setInt(1, bem.getId());
            int ret = stmt.executeUpdate();
            con.close();
            return (ret>0);
        } catch (SQLException ex) {
            throw new BemDAOException("Falha ao remover.", ex);
        }
	}

}
