package br.com.entra21.modelo2022.principal;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import br.com.entra21.modelo2022.principal.menu.entrar.cadastro.crud.PacienteCRUD;
import br.com.entra21.modelo2022.principal.menu.entrar.logado.MenuPrincipal;
import br.com.entra21.modelo2022.principal.modelobase.Paciente;
import br.com.entra21.modelo2022.validador.erro.SenhaIncorretaException;

public class Login {

	static Scanner entrada = new Scanner(System.in);

	public static Paciente logado = null;

	public static void entrar(byte tentativa) {
		if (tentativa == 0) {
			System.out.println("N�o foi possivel realizar o login, todas as tentativas falharam");
			return;
		} else {
			System.out.println((tentativa > 1 ? "Restam " : "Resta ") + tentativa
					+ (tentativa > 1 ? " tentativas" : " tentativa") + " de login:");
		}
		try {
			System.out.println("Informe o CPF do funcionario:");
			Paciente paciente = BancoFicticio.pacientes.get(entrada.next().trim());

			System.out.println("Funcionario encontrado :" + paciente.getName());
			System.out.println("Informe a senha para liberar o acesso:");

			if (!paciente.getSenha().equals(entrada.next())) {
				throw new SenhaIncorretaException();
			} else {
				verificarSenha(paciente);
				return;
			}
		} catch (NullPointerException e) {
			System.out.println("Nenhum funcionario encontrado com esse CPF");
			entrar(--tentativa);
			return;
		} catch (SenhaIncorretaException e) {
			System.out.println(e.getMessage());
			entrar(--tentativa);
			return;
		}

	}

	
	public static void cadastrar(byte tentativa) {

		String cpf;

		if (tentativa == 0) {
			System.out.println("N�o foi possivel realizar o cadastro, todas as tentativas falharam");
			return;
		} else {
			System.out.println((tentativa > 1 ? "Restam " : "Resta ") + tentativa
					+ (tentativa > 1 ? " tentativas" : " tentativa") + " de cadastro:");
		}
		try {
			System.out.println("Informe o CPF do novo funcionario:");
			cpf = entrada.next().trim();
			Paciente paciente = BancoFicticio.pacientes.get(cpf);

			if (paciente != null) {
				throw new SenhaIncorretaException();
			} else {
				paciente = new PacienteCRUD().capturarValores();
				paciente.setCpf(cpf);
				paciente.setSenha(cpf);
				BancoFicticio.pacientes.put(cpf, paciente);
				System.out.println("Funcion�rio cadastrado, por favor realize o login:");
				System.out.println("IMPORTANTE: No primeiro acesso a senha � igual ao CPF e ser� solicitado a mudan�a");
				return;
			}

		} catch (SenhaIncorretaException e) {
			System.out.println(e.getMessage());
			cadastrar(--tentativa);
			return;
		}

	}


	public static void recuperarSenha(byte tentativa) {

		if (tentativa == 0) {
			System.out.println("N�o foi possivel realizar a recupera��o de senha, todas as tentativas falharam");
			return;
		} else {
			System.out.println((tentativa > 1 ? "Restam " : "Resta ") + tentativa
					+ (tentativa > 1 ? " tentativas" : " tentativa") + " de recupera��o de senha:");
		}
		try {
			System.out.println("Informe o CPF do funcionario:");
			Paciente paciente = BancoFicticio.pacientes.get(entrada.next().trim());

			System.out.println("Funcionario encontrado :" + paciente.getName());
			paciente.setSenha(paciente.getDataCadastro().format(DateTimeFormatter.ofPattern("dd/MM/YYYY")));
			BancoFicticio.pacientes.put(paciente.getCpf(), paciente);
			System.out.println("A senha foi atualizada com a data do admiss�o no formato DD/MM/YYYY:");

			System.out.println("Funcion�rio atualizado, por favor realize o login:");

		} catch (NullPointerException e) {
			System.out.println("Nenhum funcionario encontrado com esse CPF");
			recuperarSenha(--tentativa);
			return;
		}
	}

	private static void verificarSenha(Paciente paciente) {

		if (paciente.getSenha().equals(paciente.getCpf()) || paciente.getSenha()
				.equals(paciente.getDataCadastro().format(DateTimeFormatter.ofPattern("dd/MM/YYYY")))) {
			atualizarSenha(paciente);	
			BancoFicticio.pacientes.size();
		} else {
			definirPacienteoLogado(paciente);

			new MenuPrincipal("PRINCIPAL", new ArrayList<String>(Arrays.asList("Crud","Agendar")))
					.executarMenu();

			definirPacienteoLogado(null);
		}

	}

	private static void definirPacienteoLogado(Paciente paciente) {

		if (paciente != null) {
			System.out.println("Bem vindo, " + paciente.getName());
		} else {
			System.out.println("At� a proxima " + paciente.getName() + ", volte sempre que precisar.");
		}
		logado = paciente;

	}

	private static void atualizarSenha(Paciente paciente) {

		System.out.println(
				"Atualize a sua senha, pois n�o � seguro manter a senha igual ao cpf ou com a data de admiss�o:");
		paciente.setSenha(entrada.next());
		verificarSenha(paciente);

	}

	public static void exibirInformacoesSobre() {
		System.out.println("============================== SOBRE ==================================");
		System.out.println("Projeto desenvolvido pela EU-quipe Oliota");
		System.out.println("Objetivo");
		System.out.println(
				"\tServir de modelo para constru��o dos projetos em grupo para os alunos do entra21-2022 (Melhor turma de java)");
		System.out.println(
				"\tEm cada etapa o projeto ser� atualizado e salvo em branches diferentes para manter o historico de evolu��o");
		System.out.println("");
		System.out.println("Escopo");
		System.out.println(
				"\tProjeto para cadastro, relat�rios e regras de negocios envolvendo o assunto GESTOR DE CURSOS");
		System.out.println(
				"\tO catalogo de cursos � oferecido pela institui��o e os clientes optam por adquirir os cursos");
		System.out.println("\tCada curso tem seus detalhes como , data de inicio, carga horaria e valor");
		System.out.println("");
		System.out.println("Vers�es");
		System.out.println("\tV1.0 - Cadastros,relat�rios, 1 regra de neg�cio");
		System.out.println("=======================================================================");

	}

}
