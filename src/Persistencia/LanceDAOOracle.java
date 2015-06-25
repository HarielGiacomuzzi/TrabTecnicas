package Persistencia;

import business.LanceDAO;
import business.Lance;
import business.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import business.Leilao;

public class LanceDAOOracle implements LanceDAO {


	/**
	 * @throws LanceDAOException 
	 * @see Negocio.LanceDAO#getLanceByID(int)
	 */
	public Lance getLanceByID(int id) throws LanceDAOException {
		try {
            Connection con = new OracleJDBC().getConnection();
            PreparedStatement sta = con.prepareStatement("select * from lances where id = ?");
            sta.setInt(1, id);
            ResultSet resultado = sta.executeQuery();
            Lance l = null;
            if(resultado.next()) {
                int id2 = resultado.getInt("id");
                Date data = resultado.getDate("data");
                double valor = resultado.getDouble("valor");
                int idleilao = resultado.getInt("idLeilao");
                int idUser = resultado.getInt("idUser");
                l = new Lance(id2, data,valor,idleilao,idUser);
            }
            sta.close();
            con.close();
            return l;
        } catch (SQLException ex) {
            throw new LanceDAOException(ex.getMessage());
        }
	}

	public int getNextId() throws LanceDAOException{
		try {
            Connection con = new OracleJDBC().getConnection();
            PreparedStatement sta = con.prepareStatement("select MAX(id_lance) from LANCEs");
            ResultSet resultado = sta.executeQuery();
            int id = 0;
            if(resultado.next()) {
                id = resultado.getInt(1);
            }
            sta.close();
            con.close();
            return id + 1;
        } catch (SQLException ex) {
            throw new LanceDAOException(ex.getMessage());
        }
		
	}
	
	/**
	 * @throws LanceDAOException 
	 * @see Negocio.LanceDAO#getLanceByLeilao(Negocio.Leilao)
	 */
	public List<Lance> getLanceByLeilao(Leilao leilao) throws LanceDAOException {
		try {
            Connection con = new OracleJDBC().getConnection();
            PreparedStatement sta = con.prepareStatement("select * from lances where idLeilao = ?");
            sta.setInt(1, leilao.getId());
            List<Lance> aux = new LinkedList<Lance>(null);
            ResultSet resultado = sta.executeQuery();
            Lance l = null;
            while(resultado.next()) {
                int id2 = resultado.getInt("id");
                Date data = resultado.getDate("data");
                double valor = resultado.getDouble("valor");
                int idleilao = resultado.getInt("idLeilao");
                int idUser = resultado.getInt("idUser");
                l = new Lance(id2, data,valor,idleilao,idUser);
                aux.add(l);
            }
            sta.close();
            con.close();
            return aux;
        } catch (SQLException ex) {
            throw new LanceDAOException(ex.getMessage());
        }
	}


	/**
	 * @throws LanceDAOException 
	 * @see Negocio.LanceDAO#insertLance(Negocio.Lance)
	 */
	public boolean insertLance(Lance lance) throws LanceDAOException {
		try {
            Connection con = new OracleJDBC().getConnection();
            PreparedStatement stmt = con.prepareStatement("INSERT INTO lances (id, data, valor, idLeilao, idUsuario) VALUES (?,?,?,?,?)");  
            stmt.setInt(1, lance.getId());
            stmt.setDate(2, (java.sql.Date) lance.getData());
            stmt.setDouble(3, lance.getValor());
            stmt.setInt(4, lance.getIdLeilao());
            stmt.setInt(5, lance.getIdUsuario());
            int ret = stmt.executeUpdate();
            con.close();
            return (ret>0);
        } catch (SQLException ex) {
            throw new LanceDAOException("Falha ao adicionar.", ex);
        }
	}


	/**
	 * @throws LanceDAOException 
	 * @see Negocio.LanceDAO#removeLance(Negocio.Lance)
	 */
	public boolean removeLance(Lance lance) throws LanceDAOException {
		try {
            Connection con = new OracleJDBC().getConnection();
            PreparedStatement stmt = con.prepareStatement("delete from lances where id = ?");
            stmt.setInt(1, lance.getId());
            int ret = stmt.executeUpdate();
            con.close();
            return (ret>0);
        } catch (SQLException ex) {
            throw new LanceDAOException("Falha ao remover.", ex);
        }
	}

}
