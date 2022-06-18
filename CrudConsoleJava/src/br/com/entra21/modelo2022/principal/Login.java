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
			System.out.println("Nao foi possivel realizar o login, todas as tentativas falharam");
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
			System.out.println("Nao foi possivel realizar o cadastro, todas as tentativas falharam");
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
					+ (tentativa > 1 ? " tentativas" : " tentativa") + " de recuperaï¿½ï¿½o de senha:");
		}
		try {
			System.out.println("Informe o CPF do paciente:");
			Paciente paciente = BancoFicticio.pacientes.get(entrada.next().trim());

			System.out.println("Funcionario encontrado :" + paciente.getName());
			paciente.setSenha(paciente.getDataCadastro().format(DateTimeFormatter.ofPattern("dd/MM/YYYY")));
			BancoFicticio.pacientes.put(paciente.getCpf(), paciente);
			System.out.println("A senha foi atualizada com a data do admissï¿½o no formato DD/MM/YYYY:");

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
		paciente.setSenha(entrada.next());
		verificarSenha(paciente);

	}

	public static void exibirInformacoesSobre() {
		System.out.println("============================== SOBRE ==================================");
		System.out.println(
				"A iniciativa é facilitar o agendamento de consultas médicas para o paciente com profissionais de diversas áreas da sáude.\n"
						+ "Teremos dois perfis inicialmente, o Paciente e o Médico (que pode ser qualquer profissional da área da saúde). Para usar o programa, basta realizar o cadastro, informando dados comuns como nome, CPF (para o profissional da saúde, será necessário também o número de CRM, CRE, CRO ou CRP por exemplo ), endereço por exemplo.\n"
						+ "Ambos os perfis poderão fazer cadastro e login na plataforma. Os pacientes poderão procurar qual médico estará disponível no horário que estes necessitam, eles podererão ver seus próprios agendamentos , alterar suas datas e horários, trocar de profissional ou mesmo desmarcar uma consulta. Já o médico, poderá compartilhar agendas e dias disponíveis para atendimento aos pacentes, visualizar seus atendimentos do dia e desmarcar uma consulta pré agendada.");
		System.out.println("=======================================================================");

	}

}
