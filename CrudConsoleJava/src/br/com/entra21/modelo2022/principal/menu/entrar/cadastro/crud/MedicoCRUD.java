package br.com.entra21.modelo2022.principal.menu.entrar.cadastro.crud;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import br.com.entra21.modelo2022.principal.BancoFicticio;
import br.com.entra21.modelo2022.principal.Menu;
import br.com.entra21.modelo2022.principal.modelobase.Medico;

public class MedicoCRUD extends Menu implements ICrud<Medico>{
	private HashMap<String, Medico> lista = BancoFicticio.medicos;
	
	public MedicoCRUD() {
		super("Medicos", opcoes);
	}
	
	@Override
	public byte capturarOpcao() {
		byte opcao = super.capturarOpcao();
		
		switch (opcao) {
		case 1:
			listar(lista);
			break;

		default:
			break;
		}
		return super.capturarOpcao();
	}




	public MedicoCRUD(String titulo, ArrayList<String> opcoes) {
		super(titulo, opcoes);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void listar(HashMap<String, Medico> lista) {
		System.out.println("------------- LISTA " + getTitulo() + "-----------------");
		for (Medico medico : lista.values()) {
			System.out.println("\t" + medico.getName() + " - " + medico.getAge() + " - " + medico.getCrm());
		}
		
		System.out.println("------------- QUANTIDADE (" + lista.size()  + ") --------------");
		
		
	}

	@Override
	public void adicionar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Medico buscar(Medico chave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editar(Medico chave) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(Medico chave) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Medico capturarChave() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Medico capturarValores() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void exibirDetalhes(Medico completo) {
		// TODO Auto-generated method stub
		
	}
	
}
