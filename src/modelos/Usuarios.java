package modelos;

public class Usuarios {
	private String nome, email, senha;
	private int id;

	public Usuarios(String nome, String email, String senha) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public Usuarios(int id, String email, String senha, String nome) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.id = id;
	}

	public Usuarios() {
		// TODO Auto-generated constructor stub
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
		
}
