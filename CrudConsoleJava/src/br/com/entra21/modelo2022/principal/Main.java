package br.com.entra21.modelo2022.principal;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.entra21.modelo2022.principal.menu.entrar.MenuEntrar;

public class Main {
	private static Scanner input = new Scanner(System.in);
	private static ArrayList<String> options;
	private static final byte LIMITE_TENTATIVA = 3;

	public static void main(String[] args) {

		BancoFicticio.gerarBancoDados();

		byte option;
		do {
			System.out.println(gerarMenu());
			try {
				option = input.nextByte();
			} catch (InputMismatchException e) {
				option = -2;
				input = new Scanner(System.in);
			}
			switch (option) {
			case 0:
				System.out.println("At� a proxima!");
				break;
			case 1:
				Login.entrar(LIMITE_TENTATIVA);
				break;
			case 2:
				Login.cadastrar(LIMITE_TENTATIVA);
				break;
			
			default:
				System.out.println("Escolha uma op��o v�lida");
				break;
			}
		} while (option != 0);
		System.out.println("Volte logo...");

	}

	private static String gerarMenu() {
		if (options == null) {
			options = new ArrayList<>(Arrays.asList("Entrar", "Cadastrar", "Sobre o programa"));
		}

		String menu = "|---------- Bem vindo ao programa de agenda hospitalar | ";
		menu += "\n\t0 - Sair ";

		for (int option = 0; option < options.size(); option++) {
			menu += "\n\t" + (option + 1) + " - " + options.get(option);
		}

		menu += "\n|------------------------------------------------------------|";
		menu += "\n\t Escolha uma opcao ";
		menu += "\n|------------------------------------------------------------|\n";

		return menu;
		
	}

}
