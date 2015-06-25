package Apresentacao;

import business.LeilaoFachada;
import java.util.List;
import java.util.Date;
import business.Leilao;
import business.Usuario;

public class ControlerLeiloes {
	LeilaoFachada leilaoFachada;
	
	public ControlerLeiloes(){
		leilaoFachada = new LeilaoFachada();
	}
	public List<Leilao> getLeiloes() {
		return null;
	}

	public boolean insertLeilao(char tipoLeilao, char tipoLance, Date inicio, Date fim, Usuario vendedor, double preco) {
		Leilao leilao = leilaoFachada.insertLeilao(tipoLeilao,tipoLance,inicio,fim,vendedor,preco);
		if(leilao != null){
			return true;
		}
		return false;
	}

	public void removeLeilao(int id) {

	}

}
