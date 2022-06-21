package br.com.entra21.modelo2022.principal.modelobase;

import br.com.entra21.modelo2022.principal.Turno;

public class Medico extends Pessoa {
	private String especialidade;
	private String crm;
	private Turno turno;
	private Turno turnoFinal;

	public Medico() {
		super();

	}

	public Medico(String nome, byte idade, String cpf) {
		super(nome, idade, cpf);

	}

	public Medico(String especialidade, String crm, Turno turno, Turno turnoFinal) {
		super();
		this.especialidade = especialidade;
		this.crm = crm;
		this.turno = turno;
		this.turnoFinal = turnoFinal;
	}

	public Medico(String name, byte age, String sex, String cpf, String nameMother, String nameFather, String email,
			String telephone, String streetAddress, String numberAddress, String zipCode, String city, String state,
			String country, String especialidade, String crm, Turno turno, Turno turnoFinal) {
		super(name, age, sex, cpf, nameMother, nameFather, email, telephone, streetAddress, numberAddress, zipCode,
				city, state, country);
		this.especialidade = especialidade;
		this.crm = crm;
		this.turno = turno;
		this.turnoFinal = turnoFinal;
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

	public Turno getTurno() {
		return turno;
	}

	public Turno getTurnoFinal() {
		return turnoFinal;
	}

	public void setTurnoFinal(Turno turnoFinal) {
		this.turnoFinal = turnoFinal;
	}

	public void setTurno(Turno string) {
		this.turno = string;

	}

	@Override
	public String toString() {
		return getName() + "\n Idade: " + getAge() + ":\n Especialidade: " + getEspecialidade() + "\n Crm: " + getCrm()
				+ "\n Turno: " + getTurno().getTURNO() + " até " + getTurnoFinal().getTURNO() + "\n Cpf: " + getCpf()
				+ "\n E-mail: " + getEmail() + "\n Sexo: " + getSex() + "\n Nome da mae: " + getNameMother()
				+ "\n Nome do pai: " + getNameFather() + "\n Telefone: " + getTelephone() + "\n Codigo Postal: "
				+ getZipCode() + "\n Cidade: " + getCity() + "\n Estado: " + getState() + "\n Pais: " + getCountry();
	}

}
