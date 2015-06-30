package Apresentacao;

import business.LeilaoFachada;

import java.util.List;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.table.*;
import business.Leilao;
import business.Usuario;
import Apresentacao.MainWindow;

public class ControlerLeiloes {
	LeilaoFachada leilaoFachada;
	JFrame frame;
	private DefaultTableModel modelo;
	
	public ControlerLeiloes(){
		leilaoFachada = LeilaoFachada.getInstance();
		modelo = new DefaultTableModel();
		
	}
	public ControlerLeiloes(JFrame windowLeilaoInsert) {
		this.frame = windowLeilaoInsert;
	}
	public List<Leilao> getLeiloes() {
		return null;
	}
	
	public DefaultTableModel getLeiloesTableModel(){
		modelo.addColumn("ID");
		modelo.addColumn("Vendedor");
		modelo.addColumn("Status");
		List<Leilao> lista;
		
		try{
		lista = leilaoFachada.getLeiloes();
			for(Leilao l: lista){
				String nome = leilaoFachada.getNomeByID(l.getIdVendedor());
				String status = l.getStatus();
				modelo.addRow(new Object[]{l.getId(),nome,status});
			}
			
		} catch(Exception ex){
			ex.printStackTrace();
		}
		
		return modelo;
	}
	
	public DefaultTableModel getUpdatedLeiloesTableModel(){
		if (modelo.getRowCount() > 0) {
	         for (int i = modelo.getRowCount() - 1; i > -1; i--) {
	             modelo.removeRow(i);
	         }
	     }
		List<Leilao> lista;		
		try{
		lista = leilaoFachada.getLeiloes();
			for(Leilao l: lista){
				String nome = leilaoFachada.getNomeByID(l.getIdVendedor());
				String status = l.getStatus();
				modelo.addRow(new Object[]{l.getId(),nome,status});
			}
			
		} catch(Exception ex){
			ex.printStackTrace();
		}
		
		return modelo;
	}
	
	

	public void removeLeilao(int id) {

	}
	
	public void backToPrevious(JFrame previousWindow) {
		previousWindow.setVisible(true);
		this.frame.setVisible(false);
	}

	public boolean insertLeilao(String tipoLeilao, String tipoLance, Date inicio, Date fim, int vendedorID, double preco) {
		leilaoFachada = LeilaoFachada.getInstance();
		Leilao leilao = leilaoFachada.insertLeilao(tipoLeilao,tipoLance,inicio,fim,vendedorID,preco);
		if(leilao != null){
			return true;
		}
		return false;
	}

}
