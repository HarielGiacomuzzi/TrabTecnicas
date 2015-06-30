package business;

public class Bem {

	public Bem(int id1, int idLeilao, String descBreve2, String descCompleta2,
			String string, double valor) {
		this.id = id1;
		this.descBreve = descBreve2;
		this.descCompleta = descCompleta2;
		this.idCategoria = string;
		this.idLeilao = idLeilao;
		this.valor = valor;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescBreve() {
		return descBreve;
	}

	public void setDescBreve(String descBreve) {
		this.descBreve = descBreve;
	}

	public String getDescCompleta() {
		return descCompleta;
	}

	public void setDescCompleta(String descCompleta) {
		this.descCompleta = descCompleta;
	}

	public String getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(String idCategoria) {
		this.idCategoria = idCategoria;
	}
	
	public int getIdLeilao(){
		return idLeilao;
	}

	private int id;

	private String descBreve;

	private String descCompleta;

	private String idCategoria;
	
	private int idLeilao;

	private double valor;
	
	public Double getValor() {
		return this.valor;
	}

}
