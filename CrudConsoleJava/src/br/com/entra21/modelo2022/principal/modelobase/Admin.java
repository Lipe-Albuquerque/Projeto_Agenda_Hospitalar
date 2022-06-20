package br.com.entra21.modelo2022.principal.modelobase;

public class Admin {
	private String login;
	private String senha;
	public Admin(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
	}
	
	public Admin() {
		
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
