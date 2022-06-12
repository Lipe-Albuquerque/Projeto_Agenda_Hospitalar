package br.com.entra21.modelo2022.principal.menu.entrar.cadastro;

import java.util.ArrayList;
import java.util.Arrays;

import br.com.entra21.modelo2022.principal.Menu;
import br.com.entra21.modelo2022.principal.menu.entrar.cadastro.crud.MedicoCRUD;


public class MenuCadastro extends Menu{

	public MenuCadastro(String titulo, ArrayList<String> opcoes) {
		super(titulo, opcoes);
		
	}
	
	public byte capturarOpcao() {
		byte opcao = super.capturarOpcao();

		switch (opcao) {
		case 1:
			new MedicoCRUD().executarMenu();
			break;

		case 2:

			break;

		default:
			break;
		}
		return opcao;
	}
	
	
	
}
