package br.com.entra21.modelo2022.principal.modelobase;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;

public class Medico extends Pessoa {
	private String especialidade;
	private String crm;
	private String turno;

	public Medico() {
		super();

	}

	public Medico(String nome, byte idade, String cpf) {
		super(nome, idade, cpf);
	
	}

	public Medico(String especialidade, String crm, String turno) {
		super();
		this.especialidade = especialidade;
		this.crm = crm;
		this.turno = turno;
	}

	public Medico(String name, byte age, String sex, String cpf, String nameMother, String nameFather, String email,
			String telephone, String streetAddress, String numberAddress, String zipCode, String city, String state,
			String country, String especialidade, String crm, String turno) {
		super(name, age, sex, cpf, nameMother, nameFather, email, telephone, streetAddress, numberAddress, zipCode,
				city, state, country);
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

	public String getTurno() {
		return turno;
	}

	public void setTurno(String string) {
		this.turno = string;
	}

	@Override
	public String toString() {
		return getName() + ":\n especialidade: " + getEspecialidade() + "\n crm: " + getCrm() + "\n turno: " + getTurno()+ "\n Cpf: "
				+ getCpf();
	}

}
