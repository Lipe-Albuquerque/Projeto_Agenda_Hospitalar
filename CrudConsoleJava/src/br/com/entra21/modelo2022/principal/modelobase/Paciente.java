package br.com.entra21.modelo2022.principal.modelobase;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Paciente extends Pessoa {

	private String patologia;
	private LocalDateTime dataCadastro;
	private LocalDateTime dataAtualizada;
	private String senha;

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Paciente(String cpf, String password) {

	}

	public Paciente() {

	}

	

	public Paciente(String name, byte age, String sex, String cpf, String nameMother, String nameFather, String email,
			String telephone, String streetAddress, String numberAddress, String zipCode, String city, String state,
			String country) {
		super(name, age, sex, cpf, nameMother, nameFather, email, telephone, streetAddress, numberAddress, zipCode, city, state,
				country);
		
	}

	public Paciente(String patologia, LocalDateTime dataCadastro, LocalDateTime dataAtualizada) {
		super();
		this.patologia = patologia;
		this.dataCadastro = dataCadastro;
		this.dataAtualizada = dataAtualizada;
	}

	public Paciente(String nome, byte idade, String senha) {
		super(nome, idade, senha);
		this.senha = senha;
		this.dataCadastro = LocalDateTime.now();
	}

	public Paciente(String string, byte b, String string2, String string3, String string4, String string5,
			String string6, String string7, String string8, String string9, String string10, String string11,
			String string12, String string13, String string14, LocalDate of, LocalDateTime now) {
	
	}

	public String getPatologia() {
		return patologia;
	}

	public void setPatologia(String patologia) {
		this.patologia = patologia;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public LocalDateTime getDataAtualizada() {
		return dataAtualizada;
	}

	public void setDataAtualizada(LocalDateTime dataAtualizada) {
		this.dataAtualizada = dataAtualizada;
	}

	public String toString() {
		return getName() + ":\n Patologia: " + getPatologia() + "\n Data de Cadastro: " + dataCadastro
				+ "\n Data de Atualiza��o:" + dataAtualizada + "\n Cpf: " + getCpf();
	}

}
