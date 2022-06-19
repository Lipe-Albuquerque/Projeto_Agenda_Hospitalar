package br.com.entra21.modelo2022.principal.modelobase;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Agenda {
	
	private String id;
	private Paciente paciente;
	private Medico medico;
	private String DataAgendamento;
	private String DataCancelamento;
	
	public Agenda() {
		super();
	}

	public Agenda(String id, Paciente paciente, Medico medico, String dataAgendamento, String dataCancelamento) {
		super();
		this.id = id;
		this.paciente = paciente;
		this.medico = medico;
		DataAgendamento = dataAgendamento;
		DataCancelamento = dataCancelamento;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public String getDataAgendamento() {
		return DataAgendamento;
	}

	public void setDataAgendamento(String dataAgendamento) {
		DataAgendamento = dataAgendamento;
	}

	public String getDataCancelamento() {
		return DataCancelamento;
	}

	public void setDataCancelamento(String dataCancelamento) {
		DataCancelamento = dataCancelamento;
	}
	
	public String toString() {
		return "Médico: " + getMedico().getName() + "\n ID Agendamento: " + getId();
	}
	
}