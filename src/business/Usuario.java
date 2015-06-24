package business;

public class Usuario {
	
	private int id;
	private String nome;
	private String cpf;
	private String CNPJ;
	private String email;

	public Usuario(int id2, String nome2, String cpf2, String cnpj2,
			String email2) {
		this.nome = nome2;
		this.cpf = cpf2;
		this.CNPJ = cnpj2;
		this.id = id2;
		this.email = email2;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
}
