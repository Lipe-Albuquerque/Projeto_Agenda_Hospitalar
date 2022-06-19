package br.com.entra21.modelo2022.principal.menu.entrar.logado;

import java.util.ArrayList;
import java.util.Arrays;

import br.com.entra21.modelo2022.principal.Menu;
import br.com.entra21.modelo2022.principal.menu.entrar.cadastro.MenuCadastro;


public class MenuPrincipal extends Menu {

	public MenuPrincipal(String titulo, ArrayList<String> opcoes) {
		super(titulo, opcoes); 
	}
	
	@Override
	public byte capturarOpcao() {

		byte opcao = super.capturarOpcao();
		switch (opcao) {
		case 1: 

			new MenuCadastro("CADASTROS", new ArrayList<String>(Arrays.asList("Medico", "Paciente", "Agendar"))).executarMenu(); 
			break;
		case 2:
		//	new Menu
		default:
			System.out.println("Op��o inv�lida para o menu de " + super.getTitulo());
			break;
		}
		return opcao;
	}



}
