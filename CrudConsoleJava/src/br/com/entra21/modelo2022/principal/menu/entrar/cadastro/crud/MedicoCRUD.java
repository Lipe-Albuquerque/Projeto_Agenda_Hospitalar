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
		case 2:
			adicionar();
			break;
		case 3:
			exibirDetalhes(buscar(capturarChave()));
			break;
		case 4:
			editar(capturarChave());
			break;
		case 5:
			deletar(capturarChave());
			break;

		default:
			System.out.println("Op��o inv�lida para o menu de " + super.getTitulo());
			break;
		}
		return opcao;
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
		Medico novo = capturarValores();
		if (buscar(novo) == null) {
			lista.put(novo.getName(),novo);
		} else {
			System.out.println("J� existe um registro com CHAVE:" + novo.getName());
		}

	}

	@Override
	public Medico buscar(Medico chave) {
		// TODO Auto-generated method stub
		return lista.get(chave.getName());
	}

	@Override
	public void editar(Medico chave) {
		// TODO Auto-generated method stub
		Medico medicoAtual = buscar(chave);
		if (medicoAtual == null) {
			System.out.println("N�o existe um registro com CHAVE:" + chave.getName());
		} else {
			lista.put(chave.getName(),capturarValores()) ;
			System.out.println("Dados atualizados");
		}
	}

	@Override
	public void deletar(Medico chave) {
		// TODO Auto-generated method stub
		Medico medicoAtual = buscar(chave);
		if (medicoAtual == null) {
			System.out.println("N�o existe um registro com CHAVE:" + chave.getName());
		} else {
			lista.remove(chave.getName());
			System.out.println("Item excluido");
		}
		
	}

	@Override
	public Medico capturarChave() {
		// TODO Auto-generated method stub
		Medico formulario = new Medico();
		System.out.println("Informe a CHAVE"  );
		formulario.setName(super.getEntrada().next().replaceAll("\\p{Punct}", ""));
		return formulario;
		
	}

	@Override
	public Medico capturarValores() {
		// TODO Auto-generated method stub
	Medico formulario = new Medico();
		
		System.out.println("Informe o nome" );
		formulario.setName(super.getEntrada().next());

		System.out.println("Informe o cpf:");
		formulario.setCpf(super.getEntrada().next());
		
		return formulario;
	
	}

	@Override
	public void exibirDetalhes(Medico completo) {
		// TODO Auto-generated method stub
		if(completo==null) {
			System.out.println("N�o � possivel exibir os detalhes, item n�o localizado");
		}else {
			System.out.println(completo.toString()); 
		}
		
	}
	
}
