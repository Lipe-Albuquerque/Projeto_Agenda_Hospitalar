package br.com.entra21.modelo2022.principal.menu.entrar.cadastro.crud;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import br.com.entra21.modelo2022.principal.BancoFicticio;
import br.com.entra21.modelo2022.principal.Menu;
import br.com.entra21.modelo2022.principal.modelobase.Admin;
import br.com.entra21.modelo2022.principal.modelobase.Medico;

public class AdminCRUD extends Menu implements ICrud<Admin> {

	private HashMap<String, Admin> lista = BancoFicticio.admin;

	public AdminCRUD() {
		super("Admins", opcoes);
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

	public AdminCRUD(String titulo, ArrayList<String> opcoes) {
		super(titulo, opcoes);

	}

	@Override
	public void listar(HashMap<String, Admin> lista) {
		System.out.println("------------- LISTA " + getTitulo() + "-----------------");
		for (Admin admin : lista.values()) {

			System.out.println("\t" + admin.getLogin());

		}

		System.out.println("------------- QUANTIDADE (" + lista.size() + ") --------------");

	}

	@Override
	public void adicionar() {

		Admin novo = capturarValoresAdd();
		if (buscar(novo) == null) {
			lista.put(novo.getLogin(), novo);
		} else {
			System.out.println("J� existe um registro com CHAVE:" + novo.getLogin());
		}

	}

	@Override
	public Admin buscar(Admin chave) {

		return lista.get(chave.getLogin());
	}

	@Override
	public void editar(Admin chave) {

		Admin adminAtual = buscar(chave);
		if (adminAtual == null) {
			System.out.println("N�o existe um registro com CHAVE:" + chave.getLogin());
		} else {
			lista.put(chave.getLogin(), capturarValores());
			System.out.println("Dados atualizados");
		}
	}

	@Override
	public void deletar(Admin chave) {

		Admin adminAtual = buscar(chave);
		if (adminAtual == null) {
			System.out.println("N�o existe um registro com CHAVE:" + chave.getLogin());
		} else {
			lista.remove(chave.getLogin());
			System.out.println("Item excluido");
		}

	}

	@Override
	public Admin capturarChave() {

		Admin formulario = new Admin();
		System.out.println("Informe a CHAVE");
		formulario.setLogin(super.getEntrada().next().replaceAll("\\p{Punct}", ""));
		return formulario;

	}

	public Admin capturarValoresAdd() {

		Admin formulario = new Admin();

		System.out.println("Informe o Nome:");
		formulario.setLogin(super.getEntrada().next());

		System.out.println("Informe a Crm:");
		formulario.setSenha(super.getEntrada().next());

		return formulario;

	}

	@Override
	public Admin capturarValores() {

		Admin formulario = new Admin();

		System.out.println("Informe o novo login:");
		formulario.setLogin(super.getEntrada().next());

		System.out.println("Informe a senha:");
		formulario.setSenha(super.getEntrada().next());

		return formulario;

	}

	@Override
	public void exibirDetalhes(Admin completo) {

		if (completo == null) {
			System.out.println("N�o � possivel exibir os detalhes, item n�o localizado");
		} else {
			System.out.println(completo.toString());
		}

	}

}
