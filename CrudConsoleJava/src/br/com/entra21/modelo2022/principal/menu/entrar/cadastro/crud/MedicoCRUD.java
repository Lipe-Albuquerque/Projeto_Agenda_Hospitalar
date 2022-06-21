package br.com.entra21.modelo2022.principal.menu.entrar.cadastro.crud;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import br.com.entra21.modelo2022.principal.BancoFicticio;
import br.com.entra21.modelo2022.principal.Menu;
import br.com.entra21.modelo2022.principal.Turno;
import br.com.entra21.modelo2022.principal.modelobase.Medico;

public class MedicoCRUD extends Menu implements ICrud<Medico> {

	private HashMap<String, Medico> lista = BancoFicticio.medicos;

	public MedicoCRUD() {
		super("  Medicos", opcoes);
	}

	@Override
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
			System.out.println("Opcao invalida para o menu de " + super.getTitulo());
			break;
		}
		return opcao;
	}

	public MedicoCRUD(String titulo, ArrayList<String> opcoes) {
		super(titulo, opcoes);

	}

	@Override
	public void listar(HashMap<String, Medico> lista) {
		System.out.println("|------------------------------ LISTA " + getTitulo() + " ----------------------------------|");
		System.out.println("\n|---------------------------------------------------------------------------------|");
		for (Medico medico : lista.values()) {

			System.out.println("\t" + medico.getName() + " - " + medico.getEspecialidade() + " - " + medico.getCpf());

		}
		System.out.println("|------------------------------- QUANTIDADE (" + lista.size() + ") ---------------------------------|");
		System.out.println("|--------------------------------------------------------------------------------|\n");

	}

	@Override
	public void adicionar() {

		Medico novo = capturarValoresAdd();
		if (buscar(novo) == null) {
			lista.put(novo.getCpf(), novo);
		} else {
			System.out.println("Ja existe um registro com CHAVE:" + novo.getName());
		}

	}

	@Override
	public Medico buscar(Medico chave) {

		return lista.get(chave.getCpf());
	}

	@Override
	public void editar(Medico chave) {

		Medico medicoAtual = buscar(chave);
		if (medicoAtual == null) {
			System.out.println("Nao existe um registro com CHAVE:" + chave.getName());
		} else {
			lista.put(chave.getCpf(), capturarValores());
			System.out.println("Dados atualizados");
		}
	}

	@Override
	public void deletar(Medico chave) {

		Medico medicoAtual = buscar(chave);
		if (medicoAtual == null) {
			System.out.println("Nao existe um registro com CHAVE:" + chave.getName());
		} else {
			lista.remove(chave.getCpf());
			System.out.println("Item excluido");
		}

	}

	@Override
	public Medico capturarChave() {

		Medico formulario = new Medico();
		System.out.println("Informe a CHAVE");
		formulario.setCpf(super.getEntrada().next().replaceAll("\\p{Punct}", ""));
		return formulario;

	}

	public Medico capturarValoresAdd() {
		Scanner input = new Scanner(System.in);
		byte option;
		Medico formulario = new Medico();

		System.out.println("Informe o Nome:");
		formulario.setName(super.getEntrada().next());

		System.out.println("Informe a Crm:");
		formulario.setCrm(super.getEntrada().next());

		System.out.println("Informe o Idade:");
		formulario.setAge(super.getEntrada().nextByte());

		System.out.println("Informe o Sexo:");
		formulario.setSex(super.getEntrada().next());

		System.out.println("Informe o Cpf:");
		formulario.setCpf(super.getEntrada().next());

		System.out.println("Informe a especialidade");

		formulario.setEspecialidade(super.getEntrada().next());

		System.out.println("Informe o seu turno");
		System.out.println("1 - Tuno da manha: " + Turno.MANHA.getTURNO() + " " + Turno.MANHAFINAL.getTURNO());
		System.out.println("2 - Tuno da tarde: " + Turno.TARDE.getTURNO() + " " + Turno.TARDEFINAL.getTURNO());
		System.out.println("3 - Tuno da noite: " + Turno.NOITE.getTURNO() + " " + Turno.NOITEFINAL.getTURNO());
		option = input.nextByte();
		do {
			switch (option) {
			case 1:
				System.out.println("Turno da manha selecionado!");
				formulario.setTurno(Turno.MANHA);
				formulario.setTurnoFinal(Turno.MANHAFINAL);
				break;
			case 2:
				System.out.println("Turno da tarde selecionado!");
				formulario.setTurno(Turno.TARDE);
				formulario.setTurnoFinal(Turno.TARDEFINAL);
				break;
			case 3:
				System.out.println("Turno da noite selecionado!");
				formulario.setTurno(Turno.NOITE);
				formulario.setTurnoFinal(Turno.NOITEFINAL);
				break;

			default:
				System.out.println("Selecione uma opcao valida");
				break;

			}
		} while (option == -200);
		return formulario;

	}

	@Override
	public Medico capturarValores() {
		Scanner input = new Scanner(System.in);
		Medico formulario = buscar(capturarChave());
		byte option;
		do {
			System.out.println("Escolha qual informacao deseja alterar: ");
			System.out.println("0-Retornar");
			System.out.println("1-Nome");
			System.out.println("2-Crm");
			System.out.println("3-Idade");
			System.out.println("4-Sexo");
			System.out.println("5-Cpf");
			System.out.println("6-Nome da mae");
			System.out.println("7-Nome do pai");
			System.out.println("8-e-mail");
			System.out.println("9-Telefone");
			System.out.println("10-Nome da rua");
			System.out.println("11-Numero da casa");
			System.out.println("12-Codigo Postal");
			System.out.println("13-Cidade");
			System.out.println("14-Estado");
			System.out.println("15-Pais");
			option = input.nextByte();

			switch (option) {
			case 0:
				break;

			case 1:
				System.out.println("Informe o novo Nome:");
				formulario.setName(super.getEntrada().next());
				break;
			case 2:
				System.out.println("Informe a Crm:");
				formulario.setCrm(super.getEntrada().next());
				break;
			case 3:
				System.out.println("Informe o Idade:");
				formulario.setAge(super.getEntrada().nextByte());
				break;
			case 4:
				System.out.println("Informe o Sexo:");
				formulario.setSex(super.getEntrada().next());
				break;
			case 5:
				System.out.println("Informe o Cpf:");
				formulario.setCpf(super.getEntrada().next());
				break;
			case 6:
				System.out.println("Informe o Nome da Mae:");
				formulario.setNameMother(super.getEntrada().next());
				break;
			case 7:
				System.out.println("Informe o Nome do Pai:");
				formulario.setNameFather(super.getEntrada().next());
				break;
			case 8:
				System.out.println("Informe o e-mail:");
				formulario.setEmail(super.getEntrada().next());
				break;
			case 9:
				System.out.println("Informe o Telefone:");
				formulario.setTelephone(super.getEntrada().next());
				break;
			case 10:
				System.out.println("Informe o Nome da Rua:");
				formulario.setStreetAddress(super.getEntrada().next());
				break;
			case 11:
				System.out.println("Informe o Numero da Casa:");
				formulario.setNumberAddress(super.getEntrada().next());
				break;
			case 12:
				System.out.println("Informe o Codigo Postal");
				formulario.setZipCode(super.getEntrada().next());
				break;
			case 13:
				System.out.println("Informe a Cidade:");
				formulario.setCity(super.getEntrada().next());
				break;
			case 14:
				System.out.println("Informe o Estado:");
				formulario.setState(super.getEntrada().next());
				break;
			case 15:
				System.out.println("Informe o Pais:");
				formulario.setCountry(super.getEntrada().next());

				break;

			default:
				System.out.println("Digite uma opcao valida!");
				break;
			}
		} while (option != 0);
		return formulario;

	}

	@Override
	public void exibirDetalhes(Medico completo) {

		if (completo == null) {
			System.out.println("Nao foi possivel exibir os detalhes, item nao localizado");
		} else {
			System.out.println(completo.toString());
		}

	}

}
