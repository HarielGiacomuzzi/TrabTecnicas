package Apresentacao;

import business.LeilaoFachada;
import business.Usuario;
import java.util.List;

public class ControlerUsuarios {
	LeilaoFachada leilao;
	
	public ControlerUsuarios(){
		leilao = new LeilaoFachada();
	}

	public List<Usuario> getUsuarios() {
		return null;
	}

	public void insertUsuario(String nome, String cpf, String cnpj, String email) {
		
	}

	public void removeUser(int id) {

	}

}
