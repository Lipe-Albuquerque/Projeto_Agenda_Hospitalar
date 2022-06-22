package br.com.entra21.modelo2022.principal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import br.com.entra21.modelo2022.principal.anotacoes.ClassesDescontinuadas;
import br.com.entra21.modelo2022.principal.anotacoes.Lembrete;
import br.com.entra21.modelo2022.principal.modelobase.Admin;
import br.com.entra21.modelo2022.principal.modelobase.Agenda;
import br.com.entra21.modelo2022.principal.modelobase.Medico;
import br.com.entra21.modelo2022.principal.modelobase.Paciente;


public class BancoFicticio {
	
	@ClassesDescontinuadas
	
	@Lembrete

	//TODO 03 Java Avancado - HashMap
	public static HashMap<String, Paciente> pacientes = new HashMap<>();

	public static HashMap<String, Agenda> agendas = new HashMap<>();

	public static HashMap<String, Medico> medicos = new HashMap<>();

	public static HashMap<String, Admin> admin = new HashMap<>();

	public static void gerarBancoDados() {
		inicializarMedicos();
		inicializarPacientes();
		inicializarAgenda();
		inicializarAdmin();

	}

	private static void inicializarAgenda() {

		Agenda agenda1 = new Agenda();
		agenda1.setId(1);
		agenda1.setMedico(medicos.get("91614967075"));
		agenda1.setPaciente(pacientes.get("89712348963"));
		agenda1.setDataAgendamento(LocalDate.of(2022, 02, 20).format(DateTimeFormatter.ofPattern("dd/MM/YYYY")));
		agendas.put(String.valueOf(agenda1.getId()), agenda1);

		Agenda agenda2 = new Agenda();
		agenda2.setId(4);
		agenda2.setMedico(medicos.get("89712348963"));
		agenda2.setPaciente(pacientes.get("12345678996"));
		agenda2.setDataAgendamento(LocalDate.of(2022, 11, 05).format(DateTimeFormatter.ofPattern("dd/MM/YYYY")));
		agendas.put(String.valueOf(agenda2.getId()), agenda2);

	}

	private static void inicializarMedicos() {
		// TODO 01 Logica - Comentarios
		// medico Imbituba
		medicos.put("91614967075",
				new Medico("Robin Pereira", (byte) 18, "Outro", "916.149.670-75", "Robina Pereira", "Robin Wood",
						"robin_batata123@yahoo.com", "49 98874-6352", "Rua Wood", "100", "88780-000", "Imbituba", "SC",
						"BR", "Dentista", "CRM/SC 698547", Turno.MANHA, Turno.MANHAFINAL));

		// medico Smallville
		medicos.put("02323689645",
				new Medico("Clark Kent", (byte) 35, "Masculino", "023.236.896-45", "Martha Kent", "Jonathan Kent",
						"clarkinho_56@gmail.com", " 47 98852-9633", "Rua dos El", "1569", "56600-006", "Smallville",
						"SC", "BR", "Oftalmologista", "CRM/SC 698512", Turno.TARDE, Turno.TARDEFINAL));

		// medico Joa�aba
		medicos.put("89712348963",
				new Medico("Diana Prince", (byte) 35, "Feminino", "897.123.489-63", "Hipolita Prince", "Zeus Prince",
						"diana_prince@gmail.com", " 48 98854-7888", "Av das Pedras", "78", "89600-000", "Joa�aba",
						"SC", "BR", "Neurologista", "CRM/SC 123489", Turno.NOITE, Turno.NOITEFINAL));

	}

	private static void inicializarPacientes() {
		// pacientes de Imbituba

		pacientes.put("89712348963",
				new Paciente("Steve Rogers", (byte) 29, "Masculino", "897.123.489-63", "Sarah Rogers", "Joseph Rogers",
						"steve.rogers@yahoo.com", "47 98965-5263", "Av das Americas", "407", "88780-000", "Imbituba",
						"SC", "BR", "dor", LocalDate.of(2022, 12, 30), LocalDateTime.now(), "senha"));

		pacientes.put("02315615962",
				new Paciente("Peter Parker", (byte) 21, "Masculino", "023.156.159-62", "Mary Parker", "Richard Parker",
						"peter.parker@gmail.com", " 47 98563-4541", "Rua dos Limoeiros", "569", "88780-000", "Imbituba",
						"SC", "BR", "Limpeza dentaria", LocalDate.of(2022, 12, 30), LocalDateTime.now(), "senha"));

		// pacientes de Smallville
		pacientes.put("12356315985",
				new Paciente("Anthony Stark", (byte) 58, "Masculino", "123.563.159-85", "Maria Stark", "Howard Stark",
						"iron_man@gmail.com", " 48 98845-2274", "Av da F�", "123", "56600-006", "Smallville", "SC",
						"BR", "Troca de lentes", LocalDate.of(2022, 12, 30), LocalDateTime.now(), "senha"));

		pacientes.put("12345678996",
				new Paciente("Natasha Romanoff", (byte) 32, "Feminino", "123.456.789-96", "Melina Vostokoff",
						"Alexei Shostakov", "black_widowahoo.com", " 47 99656-8987", "Rua das Flores", "99",
						"56600-006", "Smallville", "SC", "BR", "Dores fortes de cabe�a", LocalDate.of(2022, 12, 30),
						LocalDateTime.now(), "senha"));

		// pacientes de Joacaba
		pacientes.put("02356369896",
				new Paciente("Thor Odinson", (byte) 33, "Masculino", "023.563.698.96", "Joro", "Odin",
						"thunder_god@gmail.com", " 47 98874-6323", "Av Mjolnir", "1903", "89600-000", "Joacaba", "SC",
						"BR", "Enxaqueca", LocalDate.of(2022, 12, 30), LocalDateTime.now(), "senha"));

		pacientes.put("02310255885",
				new Paciente("Wanda Maximoff", (byte) 28, "Feminino", "023.102.558-85", "Magda Maximoff",
						"Erik Lehnsherr", "scarlet_witch@gmail.com", "49 98847-1002", "Av Vision", "456", "89600-000",
						"Joacaba", "SC", "BR", "Exames de rotina", LocalDate.of(2022, 12, 30), LocalDateTime.now(),
						"senha"));

	}

	public static void inicializarAdmin() {

		Admin filipe = new Admin();
		Admin ariana = new Admin();
		Admin thiago = new Admin();
		Admin adm = new Admin();
		Admin a = new Admin();
		
		filipe.setLogin("batatinha");
		filipe.setSenha("laranjinha");
		admin.put(filipe.getLogin(), filipe);

		ariana.setLogin("princesa");
		ariana.setSenha("pudimmm");
		admin.put(ariana.getLogin(), ariana);

		thiago.setLogin("tainha");
		thiago.setSenha("pureza");
		admin.put(thiago.getLogin(), thiago);
		
		adm.setLogin("admin");
		adm.setSenha("admin");
		admin.put(adm.getLogin(), adm);
		
		a.setLogin("a");
		a.setSenha("a");
		admin.put(a.getLogin(), a);
		
		

	}

}
