package business;

public class Categoria {

	private int id;

	private String descCategoria;

	public Categoria(int id, String desc) {
		this.id = id;
		this.descCategoria = desc;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescCategoria() {
		return descCategoria;
	}

	public void setDescCategoria(String descCategoria) {
		this.descCategoria = descCategoria;
	}

}
