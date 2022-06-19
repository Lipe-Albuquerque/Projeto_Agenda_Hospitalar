package br.com.entra21.modelo2022.principal.menu.entrar.cadastro.crud;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import br.com.entra21.modelo2022.principal.BancoFicticio;
import br.com.entra21.modelo2022.principal.Menu;
import br.com.entra21.modelo2022.principal.modelobase.Medico;

public class MedicoCRUD extends Menu implements ICrud<Medico> {

	private HashMap<String, Medico> lista = BancoFicticio.medicos;

	public MedicoCRUD() {
		super("Medicos", opcoes);
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
			System.out.println("Op��o inv�lida para o menu de " + super.getTitulo());
			break;
		}
		return opcao;
	}

	public MedicoCRUD(String titulo, ArrayList<String> opcoes) {
		super(titulo, opcoes);

	}

	@Override
	public void listar(HashMap<String, Medico> lista) {
		System.out.println("------------- LISTA " + getTitulo() + "-----------------");
		for (Medico medico : lista.values()) {

			System.out.println("\t" + medico.getName() + " - " + medico.getEspecialidade() + " - " + medico.getCrm());

		}

		System.out.println("------------- QUANTIDADE (" + lista.size() + ") --------------");

	}

	@Override
	public void adicionar() {

		Medico novo = capturarValoresAdd();
		if (buscar(novo) == null) {
			lista.put(novo.getCpf(), novo);
		} else {
			System.out.println("J� existe um registro com CHAVE:" + novo.getName());
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
			System.out.println("N�o existe um registro com CHAVE:" + chave.getName());
		} else {
			lista.put(chave.getCpf(), capturarValores());
			System.out.println("Dados atualizados");
		}
	}

	@Override
	public void deletar(Medico chave) {

		Medico medicoAtual = buscar(chave);
		if (medicoAtual == null) {
			System.out.println("N�o existe um registro com CHAVE:" + chave.getName());
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

		return formulario;

	}

	@Override
	public Medico capturarValores() {
		Scanner input = new Scanner(System.in);
		Medico formulario = buscar(capturarChave());
		byte option;

		do {
			System.out.println("Escolha qual inforção deseja alterar: ");
			System.out.println("0-Retornar");
			System.out.println("1-Nome");
			System.out.println("2-Crm");
			System.out.println("3-Idade");
			System.out.println("4-Sexo");
			System.out.println("5-Cpf");
			System.out.println("6-Nome da mãe");
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
				System.out.println("Informe o Nome da M�e:");
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
				System.out.println("Informe o N�mero da Casa:");
				formulario.setNumberAddress(super.getEntrada().next());
				break;
			case 12:
				System.out.println("Informe o C�digo Postal");
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
				System.out.println("Informe o Pa�s:");
				formulario.setCountry(super.getEntrada().next());

				break;

			default:
				System.out.println("Digite uma opção valida!");
				break;
			}
		} while (option != 0);
		return formulario;

	}

	@Override
	public void exibirDetalhes(Medico completo) {

		if (completo == null) {
			System.out.println("N�o � possivel exibir os detalhes, item n�o localizado");
		} else {
			System.out.println(completo.toString());
		}

	}

}
