package br.com.entra21.modelo2022.validador.erro;
//TODO 03 Java Avancado - Exceções
public class PacienteExistenteException extends Exception{
	public PacienteExistenteException() {
		super("\"Nao e possivel utilizar esse CPF, pois ja esta em uso.");
	}

}
