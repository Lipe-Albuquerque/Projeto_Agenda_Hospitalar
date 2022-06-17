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
			String country) {
		super(name, age, sex, cpf, nameMother, nameFather, email, telephone, streetAddress, numberAddress, zipCode, city, state,
				country);
	
	}



	public Medico(String nome, byte idade, String cpf) {
		super(nome, idade, cpf);
		// TODO Auto-generated constructor stub
	}



	public Medico(String especialidade, String crm, LocalDate turno) {

		super();
		this.especialidade = especialidade;
		this.crm = crm;
		this.turno = turno;
	}

	public Medico(String string, byte b, String string2, String string3, String string4, String string5, String string6,
			String string7, String string8, String string9, String string10, String string11, String string12,
			String string13, String string14, String string15, LocalDate of) {
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return getName()+":\n especialidade: " + especialidade + "\n crm: " + crm + "\n turno: " + turno + "\n Cpf: "+ getCpf()  ;
	}
	
	

}
