package br.com.entra21.modelo2022.principal;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	private Scanner entrada;
	private String titulo;
	private ArrayList<String> opcoes;

	public Menu(String titulo, ArrayList<String> opcoes) {
		super();
		this.entrada = new Scanner(System.in);
		this.titulo = titulo;
		this.opcoes = opcoes;
	}

	public void executarMenu() {
		do {
			System.out.println("=========>   MENU " + this.titulo + "   <==================");
			System.out.println("-1 = Encerrar programa");
			System.out.println(" 0 = Voltar");

			if (opcoes != null && !opcoes.isEmpty()) {
				for (int contador = 0; contador < opcoes.size(); contador++) {
					System.out.println(" " + (contador + 1) + " = " + opcoes.get(contador));
				}
			} else {
				System.out.println("Nao ha itens especificos para esse menu???");
			}

		} while (capturarOpcao() != 0);
	}

	public byte capturarOpcao() {
		byte opcao;
		opcao = entrada.nextByte();

		switch (opcao) {

		case -1:
			System.exit(-1);
			break;
		case 0:
			System.out.println("Menu " + this.titulo + " finalizado");
			break;
		}
		return opcao;
	}

	public String getTitulo() {
		return titulo;
	}

	public Scanner getEntrada() {
		return entrada;
	}
}
