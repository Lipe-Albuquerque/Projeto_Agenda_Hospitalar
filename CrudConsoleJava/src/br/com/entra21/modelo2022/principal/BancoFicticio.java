package br.com.entra21.modelo2022.principal;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import br.com.entra21.modelo2022.principal.modelobase.Medico;
import br.com.entra21.modelo2022.principal.modelobase.Paciente;

public class BancoFicticio {

	public static HashMap<String, Paciente> pacientes = new HashMap<>();

	public static HashMap<String, Medico> medicos = new HashMap<>();

	public static void gerarBancoDados() {
		inicializarMedicos();
		inicializarPacientes();
	}

	private static void inicializarMedicos() {
		medicos.put("Robin Pereira",
				new Medico("Robin Pereira", (byte) 18, "Outro", "916.149.670-75", "Robina Pereira", "Robin Wood",
						"robin_batata123@yahoo.com", "49 98874-6352", "Rua Wood", "100", "88780-000", "Imbituba", "SC",
						"BR", "Dentista", "CRM/SC 698547", LocalDate.of(2022, 03, 04)));
	}

	private static void inicializarPacientes() {
		
	}
}
