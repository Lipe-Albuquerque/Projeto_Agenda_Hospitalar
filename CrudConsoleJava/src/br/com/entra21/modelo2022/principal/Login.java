package br.com.entra21.modelo2022.principal;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import br.com.entra21.modelo2022.principal.menu.entrar.cadastro.crud.AdminCRUD;
import br.com.entra21.modelo2022.principal.menu.entrar.cadastro.crud.PacienteCRUD;
import br.com.entra21.modelo2022.principal.menu.entrar.logado.MenuPrincipal;
import br.com.entra21.modelo2022.principal.modelobase.Admin;
import br.com.entra21.modelo2022.principal.modelobase.Paciente;
import br.com.entra21.modelo2022.validador.erro.SenhaIncorretaException;

public class Login {

	static Scanner input = new Scanner(System.in);

	public static Admin logado = null;

	public static void entrar(byte tentativa) {
		if (tentativa == 0) {
			System.out.println("Nao foi possivel realizar o login, todas as tentativas falharam");
			return;
		} else {
			System.out.println((tentativa > 1 ? "Restam " : "Resta ") + tentativa
					+ (tentativa > 1 ? " tentativas" : " tentativa") + " de login:");
		}
		try {
			System.out.println("Informe o CPF do funcionario:");
			Admin admin = BancoFicticio.admin.get(input.next().trim());

			System.out.println("Funcionario encontrado :" + admin.getLogin());
			System.out.println("Informe a senha para liberar o acesso:");

			if (!admin.getSenha().equals(input.next())) {
				throw new SenhaIncorretaException();
			} else {
				verificarSenha(admin);
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
			System.out.println("Informe o login do novo funcionario:");
			login = input.next().trim();
			Admin admin = BancoFicticio.admin.get(login);

			if (admin != null) {
				throw new SenhaIncorretaException();
			} else {
				admin = new AdminCRUD().capturarValores();
				admin.setLogin(login);
				BancoFicticio.admin.put(login, admin);
			}

			System.out.println("Funcionariorio cadastrado, por favor realize o login:");
			System.out.println("IMPORTANTE: No primeiro acesso a senha e igual ao CPF e sera solicitado a mudanca");
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
					+ (tentativa > 1 ? " tentativas" : " tentativa") + " de recupera��o de senha:");
		}
		try {
			System.out.println("Informe o login do admin:");
			Admin admin = BancoFicticio.admin.get(input.next().trim());

			System.out.println("Funcionario encontrado :" + admin.getLogin());
			BancoFicticio.admin.put(admin.getLogin(), admin);
			System.out.println("A senha foi atualizada");

			System.out.println("Admin atualizado, por favor realize o login:");

		} catch (NullPointerException e) {
			System.out.println("Nenhum funcionario encontrado com esse CPF");
			recuperarSenha(--tentativa);
			return;
		}
	}

	public static void verificarSenha(Admin admin) {

		definirAdminoLogado(admin);

		new MenuPrincipal("PRINCIPAL", new ArrayList<String>(Arrays.asList("Crud", "Agendar"))).executarMenu();

		definirAdminoLogado(null);
	}

	public static void definirAdminoLogado(Admin admin) {

		if (admin != null) {
			System.out.println("Bem vindo, " + admin.getLogin());
		} else {
			System.out.println("Ate a proxima " + admin.getLogin() + ", volte sempre que precisar.");
		}
		logado = admin;

	}

	private static void atualizarSenha(Admin admin) {

		System.out.println("Atualize a sua senha");
		admin.setSenha(input.next());
		verificarSenha(admin);

	}

	public static void exibirInformacoesSobre() {
		System.out.println("============================== SOBRE ==================================");
		System.out.println(
				"A iniciativa � facilitar o agendamento de consultas m�dicas para o paciente com profissionais de diversas �reas da s�ude.\n"
						+ "Teremos treis perfis inicialmente, o Paciente e o M�dico (que pode ser qualquer profissional da �rea da sa�de). Para usar o programa, basta realizar o cadastro, informando dados comuns como nome, CPF (para o profissional da sa�de, ser� necess�rio tamb�m o n�mero de CRM, CRE, CRO ou CRP por exemplo ), endere�o por exemplo.\n"
						+ "Ambos os perfis poder�o fazer cadastro e login na plataforma. Os pacientes poder�o procurar qual m�dico estar� dispon�vel no hor�rio que estes necessitam, eles poderer�o ver seus pr�prios agendamentos , alterar suas datas e hor�rios, trocar de profissional ou mesmo desmarcar uma consulta. J� o m�dico, poder� compartilhar agendas e dias dispon�veis para atendimento aos pacentes, visualizar seus atendimentos do dia e desmarcar uma consulta pr� agendada.");
		System.out.println("=======================================================================");

	}

}
