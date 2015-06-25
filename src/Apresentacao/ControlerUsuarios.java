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

	public boolean insertUsuario(String nome, String cpf, String cnpj, String email) {
		Usuario user = leilao.insertUsuario(nome, cpf,cnpj,email);
		if(user != null){
			return true;
		}
		return false;
	}

	public void removeUser(int id) {

	}

}
