package br.com.entra21.modelo2022.principal.menu.entrar.cadastro.crud;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

//TODO 03 Java Avancado - Interface e Generics
public interface ICrud<M> {
	
	ArrayList<String> opcoes = new ArrayList<String>(
			Arrays.asList("Listar", "Adicionar", "Buscar", "Editar", "Deletar"));

	public void listar(HashMap<String, M> lista);

	public void adicionar();

	public M buscar(M chave);

	public void editar(M chave);

	public void deletar(M chave);

	public M capturarChave();

	public M capturarValores();

	public void exibirDetalhes(M completo);
}
