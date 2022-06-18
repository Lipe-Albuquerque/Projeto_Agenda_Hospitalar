package br.com.entra21.modelo2022.principal.modelobase;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Paciente extends Pessoa {

	private String patology;
	private LocalDate dataCadastro;
	private LocalDateTime dataAtualizada;
	private String password;

	public String getPatologia() {
		return patology;
	}

	public void setPatologia(String patologia) {
		this.patology = patologia;
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
		return password;
	}

	public void setSenha(String senha) {
		this.password = senha;
	}

	public Paciente() {
	}

	public Paciente(String patologia, LocalDate dataCadastro, LocalDateTime dataAtualizada, String senha) {
		super();
		this.patology = patologia;
		this.dataCadastro = dataCadastro;
		this.dataAtualizada = dataAtualizada;
		this.password = senha;
	}

	public Paciente(String name, byte age, String sex, String cpf, String nameMother, String nameFather, String email,
			String telephone, String streetAddress, String numberAddress, String zipCode, String city, String state,
			String country, String patologia, LocalDate dataCadastro, LocalDateTime dataAtualizada, String senha) {
		super(name, age, sex, cpf, nameMother, nameFather, email, telephone, streetAddress, numberAddress, zipCode,
				city, state, country);
		this.patology = patologia;
		this.dataCadastro = dataCadastro;
		this.dataAtualizada = dataAtualizada;
		this.password = senha;
	}

	public String toString() {
		return getName() + ":\n Patologia: " + getPatologia() + "\n Data de Cadastro: " + dataCadastro
				+ "\n Data de Atualizacao:" + dataAtualizada + "\n Cpf: " + getCpf();
	}

}
