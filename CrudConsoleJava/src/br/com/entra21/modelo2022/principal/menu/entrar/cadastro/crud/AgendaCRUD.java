package br.com.entra21.modelo2022.principal.menu.entrar.cadastro.crud;

import java.util.ArrayList;
import java.util.HashMap;

import br.com.entra21.modelo2022.principal.BancoFicticio;
import br.com.entra21.modelo2022.principal.Menu;
import br.com.entra21.modelo2022.principal.modelobase.Agenda;
import br.com.entra21.modelo2022.principal.modelobase.Medico;
import br.com.entra21.modelo2022.principal.modelobase.Paciente;

public class AgendaCRUD extends Menu implements ICrud<Agenda> {

	private HashMap<String, Medico> listaMedico = BancoFicticio.medicos;
	private HashMap<String, Agenda> lista = BancoFicticio.agendas;

	public AgendaCRUD() {
		super("Agendas", opcoes);
	}

	public byte capturarOpcao() {
		byte opcao = super.capturarOpcao();

		switch (opcao) {

		case 0:
			System.out.println("Voltando ao menu Cadastro...");
			break;
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
			System.out.println("Opï¿½ï¿½o invï¿½lida para o menu de " + super.getTitulo());
			break;

		}

		return opcao;
	}

	public AgendaCRUD(String titulo, ArrayList<String> opcoes) {
		super(titulo, opcoes);

	}

	@Override
	public void listar(HashMap<String, Agenda> lista) {
		System.out.println("------------- LISTA " + getTitulo() + "-----------------");

		for (Agenda agenda : lista.values()) {
			System.out.println("\t" + agenda.getId() + " - " + agenda.getPaciente().getName() + " - "
					+ agenda.getDataAgendamento() + " - " + agenda.getMedico().getName());
		}

		System.out.println("------------- QUANTIDADE (" + lista.size() + ") --------------");

	}

	@Override
	public void adicionar() {
		Agenda agenda = capturarValores();
		if (buscar(agenda) == null) {
			lista.put(agenda.getId(), agenda);
		} else {
			System.out.println("Já existe um registro com essa CHAVE: " + agenda.getId());
		}
	}

	@Override
	public Agenda buscar(Agenda chave) {
		return lista.get(chave.getId());
	}

	@Override
	public void editar(Agenda chave) {
		Agenda agendaAtual = buscar(chave);
		if (agendaAtual == null) {
			System.out.println("Não existe um registro com essa CHAVE: " + agendaAtual.getId());
		} else {
			lista.put(chave.getId(), capturarValores());
			System.out.println("Dados Atualizados");
		}
	}

	@Override
	public void deletar(Agenda chave) {
		Agenda agendaAtual = buscar(chave);
		if (agendaAtual == null) {
			System.out.println("Não existe um registro com essa CHAVE: " + agendaAtual.getId());
		} else {
			lista.remove(chave.getId());
			System.out.println("Item excluido");
		}
	}

	@Override
	public Agenda capturarChave() {
		Agenda agenda = new Agenda();
		System.out.println("Informe a CHAVE: ");
		agenda.setId(super.getEntrada().next().replaceAll("\\p{Punct}", ""));

		return agenda;
	}

	@Override
	public Agenda capturarValores() {

		Agenda agenda = new Agenda();

		System.out.println("Informe o ID: ");
		agenda.setId(super.getEntrada().next());

		System.out.println("Informe o Médico : ");
		System.out.println(listaMedico.size());
		for (Medico medico : listaMedico.values()) {
			System.out.println("  " + medico.getName());

		}
		// System.out.println("Informe a data do Agendamento: ");
		// agenda.set(super.getEntrada().next());

		return agenda;
	}


	
	@Override
	public void exibirDetalhes(Agenda completo) {

		if (completo == null) {
			System.out.println("Não é possível exibir os detalhes, item não localizado");
		} else {
			System.out.println(completo.toString());
		}

	}

}
