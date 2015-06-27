package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
            PreparedStatement sta = con.prepareStatement("select * from bens where id = ?");
            sta.setInt(1, id);
            ResultSet resultado = sta.executeQuery();
            Bem b = null;
            if(resultado.next()) {
                int id1 = resultado.getInt("id");
                String descBreve = resultado.getString("descBreve");
                String descCompleta = resultado.getString("descCompleta");
                int idCategoria = resultado.getInt("idCategoria");
                int idLeilao = resultado.getInt("idLeilao");
                b = new Bem(id1,idLeilao, descBreve, descCompleta, idCategoria);
            }
            sta.close();
            con.close();
            return b;
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
            PreparedStatement stmt = con.prepareStatement("INSERT INTO bens (id, idCategoria, descBreve, descCompleta) VALUES (?,?,?,?)");
            stmt.setInt(1, bem.getId());
            stmt.setInt(2, bem.getIdCategoria());
            stmt.setString(3, bem.getDescBreve());
            stmt.setString(4, bem.getDescCompleta());
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
            PreparedStatement stmt = con.prepareStatement("delete from bens where id = ?");
            stmt.setInt(1, bem.getId());
            int ret = stmt.executeUpdate();
            con.close();
            return (ret>0);
        } catch (SQLException ex) {
            throw new BemDAOException("Falha ao remover.", ex);
        }
	}

}
