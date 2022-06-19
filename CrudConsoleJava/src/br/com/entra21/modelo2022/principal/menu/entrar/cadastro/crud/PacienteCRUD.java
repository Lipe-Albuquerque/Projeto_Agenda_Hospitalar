package br.com.entra21.modelo2022.principal.menu.entrar.cadastro.crud;

import static br.com.entra21.modelo2022.principal.menu.entrar.cadastro.crud.ICrud.opcoes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import br.com.entra21.modelo2022.principal.BancoFicticio;
import br.com.entra21.modelo2022.principal.Menu;
import br.com.entra21.modelo2022.principal.modelobase.Medico;
import br.com.entra21.modelo2022.principal.modelobase.Paciente;
import br.com.entra21.modelo2022.principal.modelobase.Pessoa;

public class PacienteCRUD extends Menu implements ICrud<Paciente> {

	private HashMap<String, Paciente> lista = BancoFicticio.pacientes;

	public PacienteCRUD() {
		super("Pacientes", opcoes);
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

	public PacienteCRUD(String titulo, ArrayList<String> opcoes) {
		super(titulo, opcoes);
	}

	@Override
	public void listar(HashMap<String, Paciente> lista) {
		System.out.println("------------- LISTA " + getTitulo() + "-----------------");
		for (Paciente paciente : lista.values()) {

			System.out.println("\t" + paciente.getName() + " - " + paciente.getPatologia() + " - " + paciente.getCpf());

		}

		System.out.println("------------- QUANTIDADE (" + lista.size() + ") --------------");
	}

	@Override
	public void adicionar() {
		Paciente novo = capturarValores();
		if (buscar(novo) == null) {
			lista.put(novo.getCpf(), novo);
		} else {
			System.out.println("J� existe um registro com CHAVE:" + novo.getName());

		}
	}

	@Override
	public Paciente buscar(Paciente chave) {
		return lista.get(chave.getCpf());

	}

	@Override
	public void editar(Paciente chave) {
		Paciente PacienteAtual = buscar(chave);
		if (PacienteAtual == null) {
			System.out.println("N�o existe um registro com CHAVE:" + chave.getCpf());
		} else {
			lista.put(chave.getCpf(), capturarValores());
			System.out.println("Dados atualizados");
		}

	}

	@Override
	public void deletar(Paciente chave) {

		Paciente PacienteAtual = buscar(chave);
		if (PacienteAtual == null) {
			System.out.println("N�o existe um registro com CHAVE:" + chave.getCpf());
		} else {
			lista.remove(chave.getCpf());
			System.out.println("Item excluido");
		}

	}

	@Override
	public Paciente capturarChave() {
		Paciente paciente = new Paciente();
		System.out.println("Informe a CHAVE");
		paciente.setCpf(super.getEntrada().next().replaceAll("\\p{Punct}", ""));
		return paciente;

	}

	@Override
	public Paciente capturarValores() {

		Paciente paciente = new Paciente();

		System.out.println("Informe o Nome:");
		paciente.setName(super.getEntrada().next());

		System.out.println("Informe a senha");
		paciente.setSenha(super.getEntrada().next());
		System.out.println("Informe a Patologia:");
		paciente.setPatologia(super.getEntrada().next());

		System.out.println("Informe o Idade:");
		paciente.setAge(super.getEntrada().nextByte());

		System.out.println("Informe o Sexo:");
		paciente.setSex(super.getEntrada().next());

		System.out.println("Informe o Nome da M�e:");
		paciente.setNameMother(super.getEntrada().next());

		System.out.println("Informe o Nome do Pai:");
		paciente.setNameFather(super.getEntrada().next());

		System.out.println("Informe o e-mail:");
		paciente.setEmail(super.getEntrada().next());

		System.out.println("Informe o Telefone:");
		paciente.setTelephone(super.getEntrada().next());

		System.out.println("Informe o Nome da Rua:");
		paciente.setStreetAddress(super.getEntrada().next());

		System.out.println("Informe o N�mero da Casa:");
		paciente.setNumberAddress(super.getEntrada().next());

		System.out.println("Informe o C�digo Postal");
		paciente.setZipCode(super.getEntrada().next());

		System.out.println("Informe a Cidade:");
		paciente.setCity(super.getEntrada().next());

		System.out.println("Informe o Estado:");
		paciente.setState(super.getEntrada().next());

		System.out.println("Informe o Pa�s:");
		paciente.setCountry(super.getEntrada().next());

		return paciente;

	}

	@Override
	public void exibirDetalhes(Paciente completo) {
		if (completo == null) {
			System.out.println("N�o foi possivel exibir os detalhes, item n�o localizado");
		} else {
			System.out.println(completo.toString());
		}

	}

}
