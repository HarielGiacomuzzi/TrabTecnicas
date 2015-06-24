package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import business.BemDAO;
import business.Bem;
import business.Usuario;

public class BemDAOOracle implements BemDAO {


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
                b = new Bem(id1, descBreve, descCompleta, idCategoria);
            }
            sta.close();
            con.close();
            return b;
        } catch (SQLException ex) {
            throw new BemDAOException(ex.getMessage());
        }
	}


	/**
	 * @see Negocio.BemDAO#insertBem(Negocio.Bem)
	 */
	public boolean insertBem(Bem bem) {
		return false;
	}


	/**
	 * @see Negocio.BemDAO#removeBem(Negocio.Bem)
	 */
	public boolean removeBem(Bem bem) {
		return false;
	}

}
