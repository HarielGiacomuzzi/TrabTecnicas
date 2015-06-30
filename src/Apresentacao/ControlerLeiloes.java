package Apresentacao;

import business.LeilaoFachada;

import java.util.LinkedList;
import java.util.List;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.ListModel;
import javax.swing.table.*;

import business.Bem;
import business.Leilao;
import business.Usuario;

public class ControlerLeiloes {
	LeilaoFachada leilaoFachada;
	JFrame frame;
	private DefaultTableModel modelo;
	Double total;
	
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
	public void insertBem(int i) {
			WindowBemInsert insertBem = new WindowBemInsert();
			insertBem.setIdLeilao(i);
			insertBem.setBack(frame);
			insertBem.setVisible(true);
			frame.setVisible(false);
	}
	public ListModel getListBens(int i) {
		leilaoFachada = LeilaoFachada.getInstance();
		total = 0.0;
		DefaultListModel<String> model = new DefaultListModel<String>();
		LinkedList<Bem> lst = leilaoFachada.getBens(i);
		if (lst != null){
			for(Bem b : lst){
					model.addElement(b.getDescBreve());
					total += b.getValor();
			}
		}
		return model;
	}

}
