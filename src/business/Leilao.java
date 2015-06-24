package business;

import java.util.ArrayList;
import java.util.Date;

public class Leilao {
	private ArrayList<Lance> lances;

	private int id;

	private char tipoLeilao;

	private char tipoLance;

	private Date dataInicio;

	private Date dataFim;

	private int idVendedor;

	private double preco;
	
	public Leilao(int id, char tipoLeilao, char tipoLance, Date dataInicio, Date dataFim, int idVendedor, double preco) {
		this.id = id;
		this.tipoLeilao = tipoLeilao;
		this.tipoLance = tipoLance;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.idVendedor = idVendedor;
		this.preco = preco;
	}
	
	
	public ArrayList<Lance> getLances() {
		return lances;
	}

	public void setLances(ArrayList<Lance> lances) {
		this.lances = lances;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public char getTipoLeilao() {
		return tipoLeilao;
	}

	public void setTipoLeilao(char tipoLeilao) {
		this.tipoLeilao = tipoLeilao;
	}

	public char getTipoLance() {
		return tipoLance;
	}

	public void setTipoLance(char tipoLance) {
		this.tipoLance = tipoLance;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public int getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(int idVendedor) {
		this.idVendedor = idVendedor;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public void addLance(){
		
	}

}
