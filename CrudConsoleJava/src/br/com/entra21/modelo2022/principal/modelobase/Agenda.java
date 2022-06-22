package br.com.entra21.modelo2022.principal.modelobase;

public class Agenda {

	private int id;
	private Paciente paciente;
	private Medico medico;
	private String DataAgendamento;
	private String DataCancelamento;

	public Agenda() {
		super();
	}

	public Agenda(int id, Paciente paciente, Medico medico, String dataAgendamento, String dataCancelamento) {
		super();
		this.id = id;
		this.paciente = paciente;
		this.medico = medico;
		DataAgendamento = dataAgendamento;
		DataCancelamento = dataCancelamento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
		return "Medico: " + getMedico().getName() + "\nPaciente: " + getPaciente() + "\nID Agendamento: " + getId()
				+ " na data de: " + getDataAgendamento();
	}

}