package br.com.entra21.modelo2022.principal.menu.entrar.cadastro.crud;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import br.com.entra21.modelo2022.principal.BancoFicticio;
import br.com.entra21.modelo2022.principal.Menu;
import br.com.entra21.modelo2022.principal.modelobase.Medico;


public class MedicoCRUD extends Menu implements ICrud<Medico>{
	
	private HashMap<String, Medico> lista = BancoFicticio.medicos;
	
	public MedicoCRUD() {
		super("Medicos", opcoes);
	}
	
	
	@Override
	public byte capturarOpcao() {
		byte opcao = super.capturarOpcao();
		
		switch (opcao) {
		case 1:
			listar(lista);
			break;
		case 2:
			adicionar();
			break;
		case 3:
			exibirDetalhes(buscar(capturarChave()));
			break;
		case 4:
			editar(capturarChave());
			break;
		case 5:
			deletar(capturarChave());
			break;

		default:
			System.out.println("Op��o inv�lida para o menu de " + super.getTitulo());
			break;
		}
		return opcao;
	}




	public MedicoCRUD(String titulo, ArrayList<String> opcoes) {
		super(titulo, opcoes);
		
	}

	@Override
	public void listar(HashMap<String, Medico> lista) {
		System.out.println("------------- LISTA " + getTitulo() + "-----------------");
		for (Medico medico : lista.values()) {
			System.out.println("\t" + medico.getCpf() + " - " + medico.getAge() + " - " +  medico.getName());
		}
		
		System.out.println("------------- QUANTIDADE (" + lista.size()  + ") --------------");
		
		
	}

	@Override
	public void adicionar() {
		
		Medico novo = capturarValores();
		if (buscar(novo) == null) {
			lista.put(novo.getName(),novo);
		} else {
			System.out.println("J� existe um registro com CHAVE:" + novo.getName());
		}

	}

	@Override
	public Medico buscar(Medico chave) {

		return lista.get(chave.getCpf());
	}

	@Override
	public void editar(Medico chave) {

		Medico medicoAtual = buscar(chave);
		if (medicoAtual == null) {
			System.out.println("N�o existe um registro com CHAVE:" + chave.getName());
		} else {
			lista.put(chave.getName(),capturarValores()) ;
			System.out.println("Dados atualizados");
		}
	}

	@Override
	public void deletar(Medico chave) {

		Medico medicoAtual = buscar(chave);
		if (medicoAtual == null) {
			System.out.println("N�o existe um registro com CHAVE:" + chave.getName());
		} else {
			lista.remove(chave.getName());
			System.out.println("Item excluido");
		}
		
	}

	@Override
	public Medico capturarChave() {

		Medico formulario = new Medico();
		System.out.println("Informe a CHAVE"  );
		formulario.setName(super.getEntrada().next().replaceAll("\\p{Punct}", ""));
		return formulario;
		
	}

	@Override
	public Medico capturarValores() {

	Medico formulario = new Medico();
		
	

	System.out.println("Informe o Nome:");
	formulario.setName(super.getEntrada().next());

	System.out.println("Informe a Crm:");
	formulario.setCrm(super.getEntrada().next());

	System.out.println("Informe o Idade:");
	formulario.setAge(super.getEntrada().nextByte());

	System.out.println("Informe o Sexo:");
	formulario.setSex(super.getEntrada().next());

	System.out.println("Informe o Cpf:");
	formulario.setCpf(super.getEntrada().next());

	System.out.println("Informe o Nome da M�e:");
	formulario.setNameMother(super.getEntrada().next());

	System.out.println("Informe o Nome do Pai:");
	formulario.setNameFather(super.getEntrada().next());

	System.out.println("Informe o e-mail:");
	formulario.setEmail(super.getEntrada().next());

	System.out.println("Informe o Telefone:");
	formulario.setTelephone(super.getEntrada().next());

	System.out.println("Informe o Nome da Rua:");
	formulario.setStreetAddress(super.getEntrada().next());

	System.out.println("Informe o N�mero da Casa:");
	formulario.setNumberAddress(super.getEntrada().next());

	System.out.println("Informe o C�digo Postal");
	formulario.setZipCode(super.getEntrada().next());

	System.out.println("Informe a Cidade:");
	formulario.setCity(super.getEntrada().next());

	System.out.println("Informe o Estado:");
	formulario.setState(super.getEntrada().next());

	System.out.println("Informe o Pa�s:");
	formulario.setCountry(super.getEntrada().next());

	
		
		return formulario;
	
	}

	@Override
	public void exibirDetalhes(Medico completo) {

		if(completo==null) {
			System.out.println("N�o � possivel exibir os detalhes, item n�o localizado");
		}else {
			System.out.println(completo.toString()); 
		}
		
	}
	
}
