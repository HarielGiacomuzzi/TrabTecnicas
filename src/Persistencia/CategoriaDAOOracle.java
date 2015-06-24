package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import business.Categoria;
import business.CategoriaDAO;

public class CategoriaDAOOracle implements CategoriaDAO {


	/**
	 * @throws CategoriaDAOException 
	 * @see Negocio.CategoriaDAO#getCategoriaByID(int)
	 */
	public Categoria getCategoriaByID(int id) throws CategoriaDAOException {
		try {
            Connection con = new OracleJDBC().getConnection();
            PreparedStatement sta = con.prepareStatement("select * from categorias where id = ?");
            sta.setInt(1, id);
            ResultSet resultado = sta.executeQuery();
            Categoria c = null;
            if(resultado.next()) {
                int id2 = resultado.getInt("id");
                String desc = resultado.getString("descCategoria");
                c = new Categoria(id2, desc);
            }
            sta.close();
            con.close();
            return c;
        } catch (SQLException ex) {
            throw new CategoriaDAOException(ex.getMessage());
        }
	}


	@Override
	public boolean insertCategoria(Categoria cat) throws CategoriaDAOException {
		try {
            Connection con = new OracleJDBC().getConnection();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO categorias (id, descCategoria) VALUES (?,?)");
            stmt.setInt(1, cat.getId());
            stmt.setString(2, cat.getDescCategoria());
            int ret = stmt.executeUpdate();
            con.close();
            return (ret>0);
        } catch (SQLException ex) {
            throw new CategoriaDAOException("Falha ao adicionar.", ex);
        }
	}


	@Override
	public boolean removeCategoria(Categoria cat) throws CategoriaDAOException {
		try {
            Connection con = new OracleJDBC().getConnection();
            PreparedStatement stmt = con.prepareStatement("delete from categorias where id = ?");
            stmt.setInt(1, cat.getId());
            int ret = stmt.executeUpdate();
            con.close();
            return (ret>0);
        } catch (SQLException ex) {
            throw new CategoriaDAOException("Falha ao remover.", ex);
        }
	}

}
