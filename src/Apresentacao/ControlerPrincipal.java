package Apresentacao;

import javax.swing.JFrame;

import business.LeilaoFachada;

public class ControlerPrincipal {
	
	private JFrame frame;
	
	public ControlerPrincipal(JFrame window) {
		this.frame = window;
	}

	public void InsertLeilao() {
		WindowLeilaoInsert inserLeilao = new WindowLeilaoInsert();
		inserLeilao.setBack(frame);
		inserLeilao.setVisible(true);
		frame.setVisible(false);
	}

	public void insertBens() {
		WindowBemInsert insertBem = new WindowBemInsert();
		insertBem.setBack(frame);
		insertBem.setVisible(true);
		frame.setVisible(false);
	}

	public void ViewLeilao() {
		WindowLeilaoView insertBem = new WindowLeilaoView();
		insertBem.setBack(frame);
		insertBem.setVisible(true);
		frame.setVisible(false);
	}
	
	public void ViewDetalheLeilao(int idLeilao){
		WindowLeilaoDetalhe viewLeilao = new WindowLeilaoDetalhe(idLeilao);
		viewLeilao.setBack(frame);
		viewLeilao.setVisible(true);
		frame.setVisible(false);
	}

}
