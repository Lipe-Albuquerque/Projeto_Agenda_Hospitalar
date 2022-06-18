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

	static Scanner input = new Scanner(System.in);

	public static Paciente logado = null;

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
			Paciente paciente = BancoFicticio.pacientes.get(input.next().trim());

			System.out.println("Funcionario encontrado :" + paciente.getName());
			System.out.println("Informe a senha para liberar o acesso:");

			if (!paciente.getSenha().equals(input.next())) {
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
			System.out.println("Nao foi possivel realizar o cadastro, todas as tentativas falharam");
			return;
		} else {
			System.out.println((tentativa > 1 ? "Restam " : "Resta ") + tentativa
					+ (tentativa > 1 ? " tentativas" : " tentativa") + " de cadastro:");
		}
		try {
			System.out.println("Informe o CPF do novo funcionario:");
			cpf = input.next().trim();
			Paciente paciente = BancoFicticio.pacientes.get(cpf);

			if (paciente != null) {
				throw new SenhaIncorretaException();
			} else {
				paciente = new PacienteCRUD().capturarValores();
				paciente.setCpf(cpf);
				paciente.setSenha(cpf);
				BancoFicticio.pacientes.put(cpf, paciente);
				System.out.println("Funcionariorio cadastrado, por favor realize o login:");
				System.out.println(
						"IMPORTANTE: No primeiro acesso a senha e igual ao CPF e sera solicitado a mudanca");
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
			System.out.println("Nao foi possivel realizar a recuperacao de senha, todas as tentativas falharam");
			return;
		} else {
			System.out.println((tentativa > 1 ? "Restam " : "Resta ") + tentativa
					+ (tentativa > 1 ? " tentativas" : " tentativa") + " de recupera��o de senha:");
		}
		try {
			System.out.println("Informe o CPF do paciente:");
			Paciente paciente = BancoFicticio.pacientes.get(input.next().trim());

			System.out.println("Funcionario encontrado :" + paciente.getName());
			paciente.setSenha(paciente.getDataCadastro().format(DateTimeFormatter.ofPattern("dd/MM/YYYY")));
			BancoFicticio.pacientes.put(paciente.getCpf(), paciente);
			System.out.println("A senha foi atualizada com a data do admiss�o no formato DD/MM/YYYY:");

			System.out.println("Paciente atualizado, por favor realize o login:");

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

			new MenuPrincipal("PRINCIPAL", new ArrayList<String>(Arrays.asList("Crud", "Agendar"))).executarMenu();

			definirPacienteoLogado(null);
		}

	}

	private static void definirPacienteoLogado(Paciente paciente) {

		if (paciente != null) {
			System.out.println("Bem vindo, " + paciente.getName());
		} else {
			System.out.println("Ate a proxima " + paciente.getName() + ", volte sempre que precisar.");
		}
		logado = paciente;

	}

	private static void atualizarSenha(Paciente paciente) {

		System.out.println(
				"Atualize a sua senha");
		paciente.setSenha(input.next());
		verificarSenha(paciente);

	}

	public static void exibirInformacoesSobre() {
		System.out.println("============================== SOBRE ==================================");
		System.out.println(
				"A iniciativa � facilitar o agendamento de consultas m�dicas para o paciente com profissionais de diversas �reas da s�ude.\n"
						+ "Teremos dois perfis inicialmente, o Paciente e o M�dico (que pode ser qualquer profissional da �rea da sa�de). Para usar o programa, basta realizar o cadastro, informando dados comuns como nome, CPF (para o profissional da sa�de, ser� necess�rio tamb�m o n�mero de CRM, CRE, CRO ou CRP por exemplo ), endere�o por exemplo.\n"
						+ "Ambos os perfis poder�o fazer cadastro e login na plataforma. Os pacientes poder�o procurar qual m�dico estar� dispon�vel no hor�rio que estes necessitam, eles poderer�o ver seus pr�prios agendamentos , alterar suas datas e hor�rios, trocar de profissional ou mesmo desmarcar uma consulta. J� o m�dico, poder� compartilhar agendas e dias dispon�veis para atendimento aos pacentes, visualizar seus atendimentos do dia e desmarcar uma consulta pr� agendada.");
		System.out.println("=======================================================================");

	}

}
