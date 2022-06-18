package br.com.entra21.modelo2022.principal.modelobase;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Paciente extends Pessoa {

	private String patologia;
	private LocalDate dataCadastro;
	private LocalDateTime dataAtualizada;
	private String senha;

	public String getPatologia() {
		return patologia;
	}

	public void setPatologia(String patologia) {
		this.patologia = patologia;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public LocalDateTime getDataAtualizada() {
		return dataAtualizada;
	}

	public void setDataAtualizada(LocalDateTime dataAtualizada) {
		this.dataAtualizada = dataAtualizada;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Paciente() {
	}

	public Paciente(String patologia, LocalDate dataCadastro, LocalDateTime dataAtualizada, String senha) {
		super();
		this.patologia = patologia;
		this.dataCadastro = dataCadastro;
		this.dataAtualizada = dataAtualizada;
		this.senha = senha;
	}

	public Paciente(String name, byte age, String sex, String cpf, String nameMother, String nameFather, String email,
			String telephone, String streetAddress, String numberAddress, String zipCode, String city, String state,
			String country, String patologia, LocalDate dataCadastro, LocalDateTime dataAtualizada, String senha) {
		super(name, age, sex, cpf, nameMother, nameFather, email, telephone, streetAddress, numberAddress, zipCode,
				city, state, country);
		this.patologia = patologia;
		this.dataCadastro = dataCadastro;
		this.dataAtualizada = dataAtualizada;
		this.senha = senha;
	}

	public String toString() {
		return getName() + ":\n Patologia: " + getPatologia() + "\n Data de Cadastro: " + dataCadastro
				+ "\n Data de Atualizacao:" + dataAtualizada + "\n Cpf: " + getCpf();
	}

}
