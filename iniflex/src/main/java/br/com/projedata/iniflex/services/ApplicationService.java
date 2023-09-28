package br.com.projedata.iniflex.services;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import br.com.projedata.iniflex.model.Funcionario;

public class ApplicationService {

	DecimalFormat mascaraReal = new DecimalFormat();

	public DateTimeFormatter formatarData() {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", new Locale("pt", "BR"));

		return formatter;

	}

	public String mascaraDinheiro(BigDecimal valor, DecimalFormat moeda){

		final Locale BRAZIL = new Locale("pt","BR");
		final DecimalFormatSymbols REAL = new DecimalFormatSymbols(BRAZIL);
		mascaraReal = new DecimalFormat("###,###,##0.00",REAL);


		return moeda.format(valor);
	}

	public void menu() {

		System.out.println("****************************************");
		System.out.println("-Selecione uma opção-");
		System.out.println("1- Listar Funcionários");
		System.out.println("2- Deletar funcionário por Id");
		System.out.println("3- Deletar João");
		System.out.println("4- Aumentar 10% do Salário");
		System.out.println("5- Agrupamento de Funções Mapeadas");
		System.out.println("6- Agrupamento de Funcionários por Função");
		System.out.println("7- Nascidos no mês 10 e 12	");
		System.out.println("8- Funcionário Mais Velho");
		System.out.println("9- Funcionarios em Ordem Alfabética");
		System.out.println("10- Total dos Salários");
		System.out.println("11- Quantidade de Salários Mínimos(Base R$1212,00)");
		System.out.println("12- Resetar BD");
		System.out.println("0- Sair");
		System.out.println("****************************************");

	}

	public void listaFuncoes() {

		System.out.println("****************************************");
		System.out.println("-Selecione uma Função-");
		System.out.println("1- Operador");
		System.out.println("2- Coordenador");
		System.out.println("3- Diretor");
		System.out.println("4- Recepcionista");
		System.out.println("5- Contador");
		System.out.println("6- Gerente");
		System.out.println("7- Eletricista");
		System.out.println("****************************************");

	}

	public String buscaFuncao(int funcao) {

		String buscaFuncao = null;

		if (funcao == 1) {
			buscaFuncao = "Operador";
		}else if (funcao == 2) {
			buscaFuncao = "Coordenador";
		}else if (funcao == 3) {
			buscaFuncao = "Diretor";
		}else if (funcao == 4) {
			buscaFuncao = "Recepcionista";
		}else if (funcao == 5) {
			buscaFuncao = "Contador";
		}else if (funcao == 6) {
			buscaFuncao = "Gerente";
		}else if (funcao == 7) {
			buscaFuncao = "Eletricista";
		}

		return buscaFuncao;

	}
	
	public void compararId(List<Funcionario> lista) {
	
	Comparator<Funcionario> compararID = new Comparator<Funcionario>() {

		@Override
		public int compare(Funcionario f1, Funcionario f2) {
			// TODO Auto-generated method stub
			return Integer.compare(f1.getId(), f2.getId());
		}};
	
		Collections.sort(lista,compararID);
	}
	
	public void compararNome(List<Funcionario> lista) {
	
	Comparator<Funcionario> compararNomeFuncionario = new Comparator<Funcionario>() {

		@Override
		public int compare(Funcionario f1, Funcionario f2) {
			// TODO Auto-generated method stub
			return f1.getName().compareTo(f2.getName());
		}};
		
		Collections.sort(lista,compararNomeFuncionario);
	}
	
	public void comparaData(List<Funcionario> lista) {
		
		
		Comparator<Funcionario> compararData = new Comparator<Funcionario>() {

			@Override
			public int compare(Funcionario f1, Funcionario f2) {
				// TODO Auto-generated method stub
				return f1.getDtNascimento().compareTo(f2.getDtNascimento());
			}};
			
			Collections.sort(lista,compararData);
		
	}
	
	public double qtdSalarioMinimo(double salario) {

		double qtdSalario = salario/1212;
		
		return qtdSalario;
		
	}
	
}
