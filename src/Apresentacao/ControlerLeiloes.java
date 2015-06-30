package Apresentacao;

import business.LeilaoFachada;

import java.util.List;
import java.util.Date;

import javax.swing.JFrame;

import business.Leilao;
import business.Usuario;

public class ControlerLeiloes {
	LeilaoFachada leilaoFachada;
	JFrame frame;
	
	public ControlerLeiloes(){
		leilaoFachada = LeilaoFachada.getInstance();
	}
	public ControlerLeiloes(JFrame windowLeilaoInsert) {
		this.frame = windowLeilaoInsert;
	}
	public List<Leilao> getLeiloes() {
		return null;
	}

	public void removeLeilao(int id) {

	}
	
	public void backToPrevious(JFrame previousWindow) {
		previousWindow.setVisible(true);
		this.frame.setVisible(false);
	}


	public boolean insertLeilao(String tipoLeilao, String tipoLance, Date inicio, Date fim, int vendedorID, double preco) {
		Leilao leilao = leilaoFachada.insertLeilao(tipoLeilao,tipoLance,inicio,fim,vendedorID,preco);
		if(leilao != null){
			return true;
		}
		return false;
	}

}
