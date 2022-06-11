package br.com.entra21.modelo2022.principal.modelobase;

import java.time.LocalDateTime;

public class Paciente extends Pessoa {

	private String patologia;
	private LocalDateTime dataCadastro;
	private LocalDateTime dataAtualizada;

	public Paciente() {

	}

	public Paciente(String patologia, LocalDateTime dataCadastro, LocalDateTime dataAtualizada) {
		super();
		this.patologia = patologia;
		this.dataCadastro = dataCadastro;
		this.dataAtualizada = dataAtualizada;
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

}
