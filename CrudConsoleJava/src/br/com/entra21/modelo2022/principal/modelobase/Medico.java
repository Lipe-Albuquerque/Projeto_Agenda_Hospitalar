package br.com.entra21.modelo2022.principal.modelobase;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;

public class Medico extends Pessoa {
	String especialidade;
	String crm;
	private LocalDate turno;

	public Medico() {
		super();
	}

	public Medico(String name, byte age, String sex, String cpf, String nameMother, String nameFather, String email,
			String telephone, String streetAddress, String numberAddress, String zipCode, String city, String state,
			String country, String especialidade, String crm, LocalDate localDate) {
		super(name, age, sex, cpf, nameMother, nameFather, email, telephone, streetAddress, numberAddress, zipCode,
				city, state, country);
		this.especialidade = especialidade;
		this.crm = crm;
		this.turno = localDate;

	}

	public Medico(String especialidade, String crm, LocalDate turno) {

		super();
		this.especialidade = especialidade;
		this.crm = crm;
		this.turno = turno;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public LocalDate getTurno() {
		return turno;
	}

	public void setTurno(LocalDate turno) {
		this.turno = turno;
	}

}