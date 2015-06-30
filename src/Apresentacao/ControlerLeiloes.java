package Apresentacao;

import business.LeilaoFachada;
import java.util.List;
import java.util.Date;
import business.Leilao;
import business.Usuario;

public class ControlerLeiloes {
	LeilaoFachada leilaoFachada;
	
	public ControlerLeiloes(){
		leilaoFachada = LeilaoFachada.getInstance();
	}
	public List<Leilao> getLeiloes() {
		return null;
	}
	
	public int getIdUsuarioLogado(){
		return leilaoFachada.getIDUsuarioLogado();
	}

	public boolean insertLeilao(String tipoLeilao, String tipoLance, Date inicio, Date fim, int vendedorID, double preco) {
		Leilao leilao = leilaoFachada.insertLeilao(tipoLeilao,tipoLance,inicio,fim,vendedorID,preco);
		if(leilao != null){
			return true;
		}
		return false;
	}

	public void removeLeilao(int id) {

	}

}
