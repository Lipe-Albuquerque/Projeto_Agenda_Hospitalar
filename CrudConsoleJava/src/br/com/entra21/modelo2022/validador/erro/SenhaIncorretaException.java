package br.com.entra21.modelo2022.validador.erro;

public class SenhaIncorretaException extends Exception {

	public SenhaIncorretaException() {
		super("A senha informada esta incorreta, tente novamente.");
	}
}
