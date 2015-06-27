package Apresentacao;

import business.LeilaoFachada;
import business.Categoria;
import business.Bem;
import java.util.List;

public class ControlerBens {
	LeilaoFachada leilaoFachada;
	
	public ControlerBens(){
		leilaoFachada = new LeilaoFachada();
	}
	

	public boolean insertBem(int idLeilao, String descBreve, String descCompleta, int idCategoria) {
		Bem bem = leilaoFachada.insertBem(idLeilao, descBreve, descCompleta, idCategoria);
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

}
