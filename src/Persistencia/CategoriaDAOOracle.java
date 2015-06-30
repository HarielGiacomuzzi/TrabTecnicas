package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import business.Categoria;
import business.CategoriaDAO;

public class CategoriaDAOOracle implements CategoriaDAO {
	private static CategoriaDAO ref;

	/**
	 * @throws CategoriaDAOException 
	 * @see Negocio.CategoriaDAO#getCategoriaByID(int)
	 */
	public Categoria getCategoriaByID(int id) throws CategoriaDAOException {
		try {
            Connection con = new OracleJDBC().getConnection();
            PreparedStatement sta = con.prepareStatement("select * from categorias where id_categoria = ?");
            sta.setInt(1, id);
            ResultSet resultado = sta.executeQuery();
            Categoria c = null;
            if(resultado.next()) {
                int id2 = resultado.getInt("id_categoria");
                String desc = resultado.getString("desc_Categoria");
                c = new Categoria(id2, desc);
            }
            sta.close();
            con.close();
            return c;
        } catch (SQLException ex) {
            throw new CategoriaDAOException(ex.getMessage());
        }
	}

	public List<Categoria> getAllCategorias() throws CategoriaDAOException {
		try {
            Connection con = new OracleJDBC().getConnection();
            PreparedStatement sta = con.prepareStatement("select * from categorias");
            ResultSet resultado = sta.executeQuery();
            LinkedList<Categoria> lst = new LinkedList<Categoria>();
            while(resultado.next()) {
                int id2 = resultado.getInt("id_categoria");
                String desc = resultado.getString("desc_Categoria");
                lst.add(new Categoria(id2, desc));
            }
            sta.close();
            con.close();
            return lst;
        } catch (SQLException ex) {
            throw new CategoriaDAOException(ex.getMessage());
        }
	}
	
	public int getNextId() throws CategoriaDAOException{
		try {
            Connection con = new OracleJDBC().getConnection();
            PreparedStatement sta = con.prepareStatement("select MAX(id_categoria) from Categorias");
            ResultSet resultado = sta.executeQuery();
            int id = 0;
            if(resultado.next()) {
                id = resultado.getInt(1);
            }
            sta.close();
            con.close();
            return id + 1;
        } catch (SQLException ex) {
            throw new CategoriaDAOException(ex.getMessage());
        }
		
	}
	
	@Override
	public boolean insertCategoria(Categoria cat) throws CategoriaDAOException {
		try {
            Connection con = new OracleJDBC().getConnection();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO categorias (id_categoria, desc_Categoria) VALUES (?,?)");
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
            PreparedStatement stmt = con.prepareStatement("delete from categorias where id_categoria = ?");
            stmt.setInt(1, cat.getId());
            int ret = stmt.executeUpdate();
            con.close();
            return (ret>0);
        } catch (SQLException ex) {
            throw new CategoriaDAOException("Falha ao remover.", ex);
        }
	}

	public static CategoriaDAO getInstance() {
		if(ref==null){
			ref = new CategoriaDAOOracle();
		}
		return ref;
	}

}
