package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import business.UsuarioDAO;
import business.Usuario;

public class UsuarioDAOOracle implements UsuarioDAO {


	/**
	 * @throws UsuarioDAOException 
	 * @see Negocio.UsuarioDAO#getUserByID(int)
	 */
	public Usuario getUserByID(int id) throws UsuarioDAOException {
		try {
            Connection con = new OracleJDBC().getConnection();
            PreparedStatement sta = con.prepareStatement("select * from usuarios where id = ?");
            sta.setInt(1, id);
            ResultSet resultado = sta.executeQuery();
            Usuario u = null;
            if(resultado.next()) {
                String nome = resultado.getString("NOME");
                String cpf = resultado.getString("CPF");
                String cnpj = resultado.getString("CNPJ");
                String email = resultado.getString("EMAIL");
                u = new Usuario(id, nome,cpf,cnpj,email);
            }
            sta.close();
            con.close();
            return u;
        } catch (SQLException ex) {
            throw new UsuarioDAOException(ex.getMessage());
        }
	}


	/**
	 * @throws UsuarioDAOException 
	 * @see Negocio.UsuarioDAO#getUserByName(java.lang.String)
	 */
	public Usuario getUserByName(String name) throws UsuarioDAOException {
		try {
            Connection con = new OracleJDBC().getConnection();
            PreparedStatement sta = con.prepareStatement("select * from usuarios where nome = ?");
            sta.setString(1, name);
            ResultSet resultado = sta.executeQuery();
            Usuario u = null;
            if(resultado.next()) {
                int id = resultado.getInt("ID");
                String cpf = resultado.getString("CPF");
                String cnpj = resultado.getString("CNPJ");
                String email = resultado.getString("EMAIL");
                u = new Usuario(id, name,cpf,cnpj,email);
            }
            sta.close();
            con.close();
            return u;
        } catch (SQLException ex) {
            throw new UsuarioDAOException(ex.getMessage());
        }
	}


	/**
	 * @throws UsuarioDAOException 
	 * @see Negocio.UsuarioDAO#insertUser(Negocio.Usuario)
	 * 
	 *  
	 */
	public boolean insertUser(Usuario user) throws UsuarioDAOException {
		try {
            Connection con = new OracleJDBC().getConnection();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO usuarios (nome, email, cpf, cnpj, id) VALUES (?,?,?,?,?)");
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getCpf());
            stmt.setString(4, user.getCNPJ());
            stmt.setInt(5, user.getId());
            int ret = stmt.executeUpdate();
            con.close();
            return (ret>0);
        } catch (SQLException ex) {
            throw new UsuarioDAOException("Falha ao adicionar.", ex);
        }
	}


	/**
	 * @throws UsuarioDAOException 
	 * @see Negocio.UsuarioDAO#removeUser(Negocio.Usuario)
	 */
	public boolean removeUser(Usuario user) throws UsuarioDAOException {
		try {
            Connection con = new OracleJDBC().getConnection();
            PreparedStatement stmt = con.prepareStatement("delete from usuarios where id = ?");
            stmt.setInt(1, user.getId());
            int ret = stmt.executeUpdate();
            con.close();
            return (ret>0);
        } catch (SQLException ex) {
            throw new UsuarioDAOException("Falha ao adicionar.", ex);
        }
	}

}
