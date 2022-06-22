package br.com.entra21.modelo2022.principal;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	private Scanner input;
	private String title;
	private ArrayList<String> option;

	public Menu(String titulo, ArrayList<String> opcoes) {
		super();
		this.input = new Scanner(System.in);
		this.title = titulo;
		this.option = opcoes;
	}

	public void executarMenu() {
		do {
			System.out.println("|----------------------------- MENU " + this.title + " -----------------------------------|");
			System.out.println("\n|--------------------------------------------------------------------------------|");
			System.out.println("-1 = Encerrar programa");
			System.out.println(" 0 = Voltar");

			if (option != null && !option.isEmpty()) {
				// TODO 01 Logica - Operadores de incremento e decremento
				for (int contador = 0; contador < option.size(); contador++) {
					System.out.println(" " + (contador + 1) + " = " + option.get(contador));
				}
			} else {
				System.out.println("Nao ha itens especificos para esse menu???");
			}

			// TODO 01 Logica - Operadores de igualdade
		} while (capturarOpcao() != 0);
	}
	
	public void executarMenuPrincipal() {
		do {
			System.out.println("|---------------------------- MENU " + this.title + " ------------------------------------|");
			System.out.println("\n|--------------------------------------------------------------------------------|");
			System.out.println(" 0 = Encerrar programa");

			if (option != null && !option.isEmpty()) {
				for (int contador = 0; contador < option.size(); contador++) {
					System.out.println(" " + (contador + 1) + " = " + option.get(contador));
				}
			} else {
				System.out.println("Nao ha itens especificos para esse menu???");
			}

		} while (capturarOpcao() != 0);
	}

	public byte capturarOpcao() {
		byte opcao;
		opcao = input.nextByte();

		switch (opcao) {

		case -1:
			System.exit(-1);
			break;
		case 0:
			System.out.println("Menu " + this.title + " finalizado");
			break;
		}
		return opcao;
	}

	public String getTitulo() {
		return title;
	}

	public Scanner getEntrada() {
		return input;
	}
}
