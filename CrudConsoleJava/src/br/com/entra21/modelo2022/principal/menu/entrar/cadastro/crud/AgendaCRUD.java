package br.com.entra21.modelo2022.principal.menu.entrar.cadastro.crud;

import java.util.ArrayList;
import java.util.HashMap;

import br.com.entra21.modelo2022.principal.Menu;
import br.com.entra21.modelo2022.principal.modelobase.Agenda;


public class AgendaCRUD extends Menu implements ICrud<Agenda>{
	


	public AgendaCRUD(String titulo, ArrayList<String> opcoes) {
		super(titulo, opcoes);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void listar(HashMap<String, Agenda> lista) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void adicionar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Agenda buscar(Agenda chave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editar(Agenda chave) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(Agenda chave) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Agenda capturarChave() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Agenda capturarValores() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void exibirDetalhes(Agenda completo) {
		// TODO Auto-generated method stub
		
	}

	

}
