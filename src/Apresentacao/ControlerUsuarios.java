package Apresentacao;

import business.FachadaException;
import business.LeilaoFachada;
import business.Usuario;

import java.util.List;

import javax.swing.JOptionPane;

public class ControlerUsuarios {
	LeilaoFachada leilao;
	
	public ControlerUsuarios(){
		leilao = new LeilaoFachada();
	}

	public List<Usuario> getUsuarios() {
		return null;
	}

	public boolean insertUsuario(String nome, String cpf, String cnpj, String email, String senha) {
		try{
		Usuario user = leilao.insertUsuario(nome, cpf,cnpj,email,senha);
		if(user != null){
			return true;
		}
		return false;
		} catch (FachadaException e){
			JOptionPane.showMessageDialog(null, e.getMessage());
			return false;
		}
	}

	public void removeUser(int id) {

	}

}
