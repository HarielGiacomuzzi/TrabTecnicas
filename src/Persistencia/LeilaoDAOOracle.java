package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import business.Leilao;
import business.LeilaoDAO;

public class LeilaoDAOOracle implements LeilaoDAO {
	private static LeilaoDAOOracle ref;
	
	public static LeilaoDAOOracle getInstance(){
		if(ref == null){
			ref = new LeilaoDAOOracle();
		}
		return ref;
	}

	/**
	 * @throws LeilaoDAOException 
	 * @see Negocio.LeilaoDAO#getLeilaoByID(int)
	 */
	public Leilao getLeilaoByID(int id) throws LeilaoDAOException {
		try {
            Connection con = new OracleJDBC().getConnection();
            PreparedStatement sta = con.prepareStatement("select * from leilao where id = ?");
            sta.setInt(1, id);
            ResultSet resultado = sta.executeQuery();
            Leilao l = null;
            if(resultado.next()) {
                int id2 = resultado.getInt("id_leilao");
                String tipoLeilao = resultado.getString("tipo_leilao");
                String tipoLance = resultado.getString("tipo_lance");
                Date dataInicio = resultado.getDate("data_inicio");
                Date dataFim = resultado.getDate("data_fim");
                int idVendedor = resultado.getInt("vendedor_fk");
                double preco = resultado.getDouble("preco");
                
                l = new Leilao(id2, tipoLeilao,tipoLance,dataInicio,dataFim,idVendedor,preco);
            }
            sta.close();
            con.close();
            return l;
        } catch (SQLException ex) {
            throw new LeilaoDAOException(ex.getMessage());
        }
	}


	public int getNextId() throws LeilaoDAOException{
		try {
            Connection con = new OracleJDBC().getConnection();
            PreparedStatement sta = con.prepareStatement("select MAX(id_leilao) from leilao");
            ResultSet resultado = sta.executeQuery();
            int id = 0;
            if(resultado.next()) {
                id = resultado.getInt(1);
            }
            sta.close();
            con.close();
            return id + 1;
        } catch (SQLException ex) {
            throw new LeilaoDAOException(ex.getMessage());
        }
		
	}
	
	/**
	 * @throws LeilaoDAOException 
	 * @see Negocio.LeilaoDAO#insertLeilao(Negocio.Leilao)
	 */
	public boolean insertLeilao(Leilao leilao) throws LeilaoDAOException {
		try {
            Connection con = new OracleJDBC().getConnection();            
            PreparedStatement stmt = con.prepareStatement("INSERT INTO leilao (id_leilao, tipo_leilao, tipo_lance, data_inicio, data_fim, vendedor_fk , preco ) VALUES (?,?,?,?,?,?,?)");
            stmt.setInt(1, leilao.getId());
            stmt.setString(2, leilao.getTipoLeilao()+"");
            stmt.setString(3, leilao.getTipoLance()+"");
            stmt.setDate(4, (java.sql.Date) leilao.getDataInicio());
            stmt.setDate(5, (java.sql.Date) leilao.getDataFim());
            stmt.setInt(5, leilao.getIdVendedor());
            stmt.setDouble(5, leilao.getPreco());
            int ret = stmt.executeUpdate();
            con.close();
            return (ret>0);
        } catch (SQLException ex) {
            throw new LeilaoDAOException("Falha ao adicionar.", ex);
        }
	}


	/**
	 * @throws LeilaoDAOException 
	 * @see Negocio.LeilaoDAO#removeLeilao(Negocio.Leilao)
	 */
	public boolean removeLeilao(Leilao leilao) throws LeilaoDAOException {
		try {
            Connection con = new OracleJDBC().getConnection();
            PreparedStatement stmt = con.prepareStatement("delete from leilao where id = ?");
            stmt.setInt(1, leilao.getId());
            int ret = stmt.executeUpdate();
            con.close();
            return (ret>0);
        } catch (SQLException ex) {
            throw new LeilaoDAOException("Falha ao remover.", ex);
        }
	}

}
