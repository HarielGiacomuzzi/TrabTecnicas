package business;

public class Bem {

	public Bem(int id1, String descBreve2, String descCompleta2,
			int idCategoria2) {
		this.id = id1;
		this.descBreve = descBreve2;
		this.descCompleta = descCompleta2;
		this.idCategoria = idCategoria2;
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

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	private int id;

	private String descBreve;

	private String descCompleta;

	private int idCategoria;

}
