package br.com.entra21.modelo2022.principal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	private static Scanner input = new Scanner(System.in);
	private static ArrayList<String> options;
	// TODO 01 Logica - Constantes
	private static final byte LIMITE_TENTATIVA = 3;

	public static void main(String[] args) {

		BancoFicticio.gerarBancoDados();
		// TODO 01 Logica - Variaveis
		byte option;
		//TODO 01 Logica - do/while
		do {
			System.out.println(gerarMenu());
			try {
				option = input.nextByte();
			} catch (InputMismatchException e) {
				option = -2;
				input = new Scanner(System.in);
			}
			// TODO 01 Logica - Switch case
			switch (option) {
			case 0:
				System.out.println("Ate a proxima!");
				break;
			case 1:
				Login.entrar(LIMITE_TENTATIVA);
				break;
			case 2:
				Login.cadastrar(LIMITE_TENTATIVA);
				break;
			case 3:
				Login.exibirInformacoesSobre();
				break;
			default:
				System.out.println("Escolha uma opcao valida");
				break;
			}
		} while (option != 0);
		System.out.println("Volte logo...");

	}

	private static String gerarMenu() {
		if (options == null) {
			options = new ArrayList<>(Arrays.asList("Entrar", "Cadastrar", "Sobre o programa"));
		}
		// funcao que gera o menu
		String menu = "|------------------ Bem vindo ao programa de agenda hospitalar ------------------| ";
		menu += "\n Escolha uma opcao:";
		menu += "\n\t0 - Sair ";

		// TODO 01 Logica - For
		for (int option = 0; option < options.size(); option++) {
			menu += "\n\t" + (option + 1) + " - " + options.get(option);
		}

		menu += "\n|--------------------------------------------------------------------------------|";

		return menu;

	}

}
