package br.com.entra21.modelo2022.principal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import br.com.entra21.modelo2022.principal.menu.entrar.cadastro.crud.AdminCRUD;
import br.com.entra21.modelo2022.principal.menu.entrar.logado.MenuPrincipal;
import br.com.entra21.modelo2022.principal.modelobase.Admin;
import br.com.entra21.modelo2022.validador.erro.SenhaIncorretaException;

public class Login {

	static Scanner input = new Scanner(System.in);

	public static Admin logado = null;
	
	// TODO 01 Logica - Funcao com parametro e retorno
	public static void entrar(byte tentativa) {
		
		// TODO 01 Logica - Condicionais ( if e else )
		if (tentativa == 0) {
			System.out.println("Nao foi possivel realizar o login, todas as tentativas falharam");
			return;
		} else {
			System.out.println((tentativa > 1 ? "Restam " : "Resta ") + tentativa
					+ (tentativa > 1 ? " tentativas" : " tentativa") + " de login:");
		}
		// TODO 03 Java Avancado - Tratamento de erros e excecoes
		try {
			System.out.println("Informe o login do usuario:");
			Admin admin = BancoFicticio.admin.get(input.next().trim());

			System.out.println("Usuario encontrado : " + admin.getLogin());
			System.out.println("Informe a senha para liberar o acesso:");

			if (!admin.getSenha().equals(input.next())) {
				throw new SenhaIncorretaException();
			} else {
				verificarSenha(admin);
				return;
			}
		} catch (NullPointerException e) {
			System.out.println("Nenhum usuario encontrado com esse login");
			entrar(--tentativa);
			return;
		} catch (SenhaIncorretaException e) {
			System.out.println(e.getMessage());
			entrar(--tentativa);
			return;
		}

	}

	public static void cadastrar(byte tentativa) {

		String login;
		String senha;
		if (tentativa == 0) {
			System.out.println("Nao foi possivel realizar o cadastro, todas as tentativas falharam");
			return;
		} else {
			System.out.println((tentativa > 1 ? "Restam " : "Resta ") + tentativa
					+ (tentativa > 1 ? " tentativas" : " tentativa") + " de cadastro:");
		}
		try {
			System.out.println("Informe o login do novo usuario:");
			login = input.next().trim();
			Admin admin = BancoFicticio.admin.get(login);

			if (admin != null) {
				throw new SenhaIncorretaException();
			} else {

				admin = new AdminCRUD().capturarValores();
				admin.setLogin(login);
				System.out.println("Informe a senha:");
				senha = input.next();
				admin.setSenha(senha);

				BancoFicticio.admin.put(login, admin);
			}

			System.out.println("Usuario cadastrado, por favor realize o login!");
//			System.out.println("IMPORTANTE: No primeiro acesso a senha e igual ao CPF e sera solicitado a mudanca");
			return;

		} catch (SenhaIncorretaException e) {
			System.out.println(e.getMessage());
			cadastrar(--tentativa);
			return;
		}

	}

	public static void recuperarSenha(byte tentativa) {

		if (tentativa == 0) {
			System.out.println("Nao foi possivel realizar a recuperacao de senha, todas as tentativas falharam");
			return;
		} else {
			System.out.println((tentativa > 1 ? "Restam " : "Resta ") + tentativa
					+ (tentativa > 1 ? " tentativas" : " tentativa") + " de recuperacao de senha:");
		}
		try {
			System.out.println("Informe o login do admin:");
			Admin admin = BancoFicticio.admin.get(input.next().trim());

			System.out.println("Usuario encontrado :" + admin.getLogin());
			BancoFicticio.admin.put(admin.getLogin(), admin);
			System.out.println("A senha foi atualizada");

			System.out.println("Admin atualizado, por favor realize o login:");

		} catch (NullPointerException e) {
			System.out.println("Nenhum Usuario encontrado com esse CPF");
			recuperarSenha(--tentativa);
			return;
		}
	}

	public static void verificarSenha(Admin admin) {

		definirAdminoLogado(admin);

		new MenuPrincipal("PRINCIPAL", new ArrayList<String>(Arrays.asList("Crud"))).executarMenuPrincipal();

		definirAdminoLogado(null);
	}

	public static void definirAdminoLogado(Admin admin) {

		if (admin != null) {

			System.out.println("\nBem vindo, " + admin.getLogin());
		} else {
			System.out.println("Ate a proxima " + admin.getLogin() + ", volte sempre que precisar.");
		}
		logado = admin;

	}

	// TODO 01 Logica - Funcao com parametro
	private static void atualizarSenha(Admin admin) {

		System.out.println("Atualize a sua senha");
		admin.setSenha(input.next());
		verificarSenha(admin);

	}
	// TODO 01 Logica - Funcao sem parametro e sem retorno 
	public static void exibirInformacoesSobre() {
		System.out.println("|---------------------------------- SOBRE ---------------------------------------|");
		System.out.println("A iniciativa é facilitar o agendamento de consultas médicas para o paciente \n"
						 + "com profissionais de diversas áreas da sáude.\n"
						 + "Teremos três perfis inicialmente, o Paciente, o Médico - que pode ser qualquer\n"
						 + "profissional da área da saúde - e o Admin.\n"
						 + "Para usar o programa, basta realizar o cadastro, informando dados comuns como\n"
						 + "nome,CPF (para o profissional da saúde,será necessário também o número de CRM,\n"
						 + "CRE, CRO ou CRP por exemplo ), endereço por exemplo.\n"
						 + "Ambos os perfis poderão fazer cadastro e login na plataforma. Os pacientes poderão\n"
						 + "procurar qual médico estará disponível no horário que estes necessitam, eles \n"
						 + "podererão ver seus próprios agendamentos , alterar suas datas e horários,trocar de\n"
						 + "profissional ou mesmo desmarcar uma consulta. \n"
						 + "Já o médico, poderá compartilhar agendas e dias disponíveis para atendimento aos \n"
						 + "pacientes, visualizar seus atendimentos do dia e desmarcar uma consulta pré agendada.");

		System.out.println("\n|--------------------------------------------------------------------------------|\n");

	}

}
