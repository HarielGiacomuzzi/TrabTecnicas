package business;

import java.util.Date;

public class Lance {
	
	private int Id;

	private Date Data;

	private double Valor;

	private int idLeilao;

	private int idUsuario;
	
	public Lance(int id, Date data, double valor, int idLeilao, int idUsuario) {
		this.Id = id;
		this.Data = data;
		this.Valor = valor;
		this.idLeilao = idLeilao;
		this.idUsuario = idUsuario;
	}
	

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Date getData() {
		return Data;
	}

	public void setData(Date data) {
		Data = data;
	}

	public double getValor() {
		return Valor;
	}

	public void setValor(double valor) {
		Valor = valor;
	}

	public int getIdLeilao() {
		return idLeilao;
	}

	public void setIdLeilao(int idLeilao) {
		this.idLeilao = idLeilao;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

}
