package br.com.entra21.modelo2022.principal.menu.entrar.cadastro;

import java.util.ArrayList;
import java.util.Arrays;

import br.com.entra21.modelo2022.principal.Menu;
import br.com.entra21.modelo2022.principal.menu.entrar.cadastro.crud.AgendaCRUD;
import br.com.entra21.modelo2022.principal.menu.entrar.cadastro.crud.MedicoCRUD;
import br.com.entra21.modelo2022.principal.menu.entrar.cadastro.crud.PacienteCRUD;


public class MenuCadastro extends Menu{

	public MenuCadastro(String titulo, ArrayList<String> opcoes) {
		super(titulo, opcoes);
		
	}
	@Override
	public byte capturarOpcao() {
		byte opcao = super.capturarOpcao();

		switch (opcao) {
		case 1:
			new MedicoCRUD().executarMenu();
			break;

		case 2:
			new PacienteCRUD().executarMenu();
			break;
			
		case 3:
			new AgendaCRUD().executarMenu();
			break;

		default:
			break;
		}
		return opcao;
	}
	
	
	
}
