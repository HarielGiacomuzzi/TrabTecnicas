package Apresentacao;

import business.FachadaException;
import business.LeilaoFachada;
import business.Categoria;
import business.Bem;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;

public class ControlerBens {
	LeilaoFachada leilaoFachada;
	JFrame frame;
	String categorias[];
	
	public ControlerBens(){
		leilaoFachada = LeilaoFachada.getInstance();
	}
	

	public ControlerBens(WindowBemInsert windowBemInsert) {
		this.frame = windowBemInsert;
	}


	public boolean insertBem(int idLeilao, String descBreve, String descCompleta, String string, double valor) {
		leilaoFachada = LeilaoFachada.getInstance();
		Bem bem = leilaoFachada.insertBem(idLeilao, descBreve, descCompleta, string, valor);
		if(bem!=null){
			return true;
		}
		return false;
	}

	public void removeBem(int id) {

	}

	public List<Bem> getBens() {
		return null;
	}


	public void previousWindow(JFrame backTo) {
		this.frame.setVisible(false);
		backTo.setVisible(true);
	}

}
