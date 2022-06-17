package br.com.entra21.modelo2022.validador.erro;

public class PacienteExistenteException extends Exception{
	public PacienteExistenteException() {
		super("\"N�o � possivel utilizar esse CPF, pois j� esta em uso.");
	}

}
