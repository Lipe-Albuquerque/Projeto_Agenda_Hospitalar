package br.com.entra21.modelo2022.principal.menu.entrar.cadastro.crud;

import java.util.ArrayList;
import java.util.HashMap;

import br.com.entra21.modelo2022.principal.BancoFicticio;
import br.com.entra21.modelo2022.principal.Login;
import br.com.entra21.modelo2022.principal.Menu;
import br.com.entra21.modelo2022.principal.modelobase.Agenda;
import br.com.entra21.modelo2022.principal.modelobase.Medico;
import br.com.entra21.modelo2022.principal.modelobase.Paciente;

public class AgendaCRUD extends Menu implements ICrud<Agenda> {
	private HashMap<String, Paciente> listaPaciente = BancoFicticio.pacientes;
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
			System.out.println("Op��o inv�lida para o menu de " + super.getTitulo());
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
			lista.put(String.valueOf(agenda.getId()), agenda);
		} else {
			System.out.println("J� existe um registro com essa CHAVE: " + agenda.getId());
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
			System.out.println("N�o existe um registro com essa CHAVE: " + agendaAtual.getId());
		} else {
			lista.put(String.valueOf(chave.getId()), capturarValores());
			System.out.println("Dados Atualizados");
		}
	}

	@Override
	public void deletar(Agenda chave) {
		Agenda agendaAtual = buscar(chave);
		if (agendaAtual == null) {
			System.out.println("N�o existe um registro com essa CHAVE: " + agendaAtual.getId());
		} else {
			lista.remove(chave.getId());
			System.out.println("Item excluido");
		}
	}

	@Override
	public Agenda capturarChave() {
		Agenda agenda = new Agenda();
		System.out.println("Informe a CHAVE: ");
		agenda.setId(super.getEntrada().nextInt());

		return agenda;
	}

	public Medico capturarChaveMedico() {
		Medico agenda = new Medico();
		System.out.println("Informe o cpf: ");
		agenda.setCpf(super.getEntrada().next().replaceAll("\\p{Punct}", ""));

		return agenda;
	}

	@Override
	public Agenda capturarValores() {

		Agenda agenda = new Agenda();

		if (agenda.getId() < lista.size()) {
			agenda.setId(lista.size() + 1);
		} else {

		}
		listarMedico(listaMedico);

		agenda.setMedico(buscarMedico(capturarChaveMedico()));

		System.out.println("Informe a data do Agendamento: ");
		agenda.setDataAgendamento(super.getEntrada().next());

		return agenda;
	}

	@Override
	public void exibirDetalhes(Agenda completo) {

		if (completo == null) {
			System.out.println("N�o � poss�vel exibir os detalhes, item n�o localizado");
		} else {
			System.out.println(completo.toString());
		}

	}

	public void listarMedico(HashMap<String, Medico> listaMedico) {
		System.out.println("------------- LISTA " + getTitulo() + "-----------------");
		for (Medico medico : listaMedico.values()) {

			System.out.println("\t" + medico.getCpf() + " - " + medico.getName() + " - " + medico.getEspecialidade());

		}

		System.out.println("------------- QUANTIDADE (" + listaMedico.size() + ") --------------");

	}

	public Medico buscarMedico(Medico chave) {
		return listaMedico.get(chave.getCpf());
	}

}
