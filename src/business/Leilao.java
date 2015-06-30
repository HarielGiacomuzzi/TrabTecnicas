package business;

import java.util.ArrayList;
import java.util.Date;

public class Leilao {
	private ArrayList<Lance> lances;

	private int id;

	private String tipoLeilao;

	private String tipoLance;

	private Date dataInicio;

	private Date dataFim;

	private int idVendedor;

	private double preco;
	
	public Leilao(int id, String tipoLeilao, String tipoLance, Date dataInicio, Date dataFim, int idVendedor, double preco) {
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

	public String getTipoLeilao() {
		return tipoLeilao;
	}

	public void setTipoLeilao(String tipoLeilao) {
		this.tipoLeilao = tipoLeilao;
	}

	public String getTipoLance() {
		return tipoLance;
	}

	public void setTipoLance(String tipoLance) {
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
