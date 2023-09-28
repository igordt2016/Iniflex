package br.com.projedata.iniflex.controller;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import br.com.projedata.iniflex.model.Funcionario;
import br.com.projedata.iniflex.repository.FuncionarioRepository;
import br.com.projedata.iniflex.services.ApplicationService;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class FuncionarioController {

	ApplicationService appService = new ApplicationService();
	
	private static FuncionarioRepository fr = new FuncionarioRepository();

	File file;
	Workbook workbook;

	DecimalFormat mascaraReal = new DecimalFormat();

	DateTimeFormatter formatter = appService.formatarData();
	
	
	//	public void insertFuncionarios(Connection con) {
	//
	//		Scanner sc = new Scanner(System.in);
	//
	//		String dataString; 
	//		LocalDate data; 
	//
	//		int controle = 1;
	//
	//		StringBuilder sqlIdControle = new StringBuilder();
	//		sqlIdControle.append(" SELECT MAX(ID) ID FROM PESSOA");
	//		PreparedStatement cIdControle;
	//		int id = 0;
	//
	//
	//		StringBuilder sqlInsertPessoa =  new StringBuilder();
	//		sqlInsertPessoa.append(" INSERT INTO PESSOA ");
	//		sqlInsertPessoa.append(" (ID, NOME, DT_NASCIMENTO) ");
	//		sqlInsertPessoa.append(" VALUES(?,?,?) ");
	//		PreparedStatement cInsertPessoa;
	//
	//		StringBuilder sqlInsertFuncionario =  new StringBuilder();
	//		sqlInsertFuncionario.append(" INSERT INTO FUNCIONARIO ");
	//		sqlInsertFuncionario.append(" (ID, SALARIO, FUNCAO) ");
	//		sqlInsertFuncionario.append(" VALUES(?,?,?) ");
	//		PreparedStatement cInsertFunc;
	//		try {
	//			while(controle == 1) {
	//
	//				System.out.println("Deseja Cadastrar Funcionário ? 1 para (SIM)  - Qualquer Caractere para (NÃO)");
	//				controle = sc.nextInt();
	//
	//				if(controle == 1) {
	//
	//					Funcionario f = new Funcionario(null, null);
	//					System.out.println("Nome: ");
	//					f.setName(sc.next());
	//					System.out.println("Data de Nascimento: ");
	//					dataString = sc.next();
	//					data = LocalDate.parse(dataString,formatter);
	//					f.setDtNascimento(data);
	//					System.out.println("Salário: ");
	//					f.setSalario(sc.nextBigDecimal());
	//					System.out.print("Função: ");
	//					f.setFuncao(sc.next());
	//
	//					cIdControle = con.prepareStatement(sqlIdControle.toString());
	//					ResultSet rs = null;
	//
	//					rs = cIdControle.executeQuery();
	//
	//					if (rs.next()) {
	//
	//						id = rs.getInt("ID");
	//
	//						if (id == 0) {
	//
	//							id = 1; 
	//						}else {
	//
	//							id += 1;
	//
	//						}
	//
	//					}else {
	//
	//						id = 1;
	//					}
	//
	//					cInsertPessoa = con.prepareStatement(sqlInsertPessoa.toString()); 
	//					cInsertPessoa.setInt(1, id);
	//					cInsertPessoa.setString(2, f.getName());
	//					cInsertPessoa.setDate(3, java.sql.Date.valueOf(f.getDtNascimento()));
	//					cInsertPessoa .executeUpdate();
	//
	//					cInsertFunc = con.prepareStatement(sqlInsertFuncionario.toString());
	//					cInsertFunc.setInt(1, id);
	//					cInsertFunc.setBigDecimal(2, f.getSalario());
	//					cInsertFunc.setString(3, f.getFuncao());
	//					cInsertFunc.executeUpdate();
	//
	//
	//					System.out.println("Deseja Cadastrar Funcionário Novamente? 1 para (SIM)  - Qualquer Caractere para (NÃO)");
	//					controle = sc.nextInt();
	//				}else {
	//
	//					System.out.println("Operação de Inserção Cancelada.");
	//					break;
	//
	//				}
	//			}
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//		}finally {
	//			sc.close();
	//			System.out.println("Saída.");
	//
	//		}
	//
	//
	//	}

	//	public void getFuncionarios(Connection con) {
	//
	//
	//		StringBuilder sqlGetFuncionarios = new StringBuilder();
	//		sqlGetFuncionarios.append(" SELECT f.id, p.nome, p.dt_nascimento, f.salario, f.funcao ");
	//		sqlGetFuncionarios.append(" FROM PESSOA p, FUNCIONARIO f");
	//		sqlGetFuncionarios.append(" WHERE p.id = f.id");
	//		sqlGetFuncionarios.append(" ORDER BY 1");
	//
	//		Boolean deleted;
	//
	//		try {
	//
	//			statement = con.prepareStatement(sqlGetFuncionarios.toString());
	//
	//			ResultSet rs = null;
	//
	//			rs = statement.executeQuery();
	//
	//			while(rs.next()) {
	//
	//				deleted = false;
	//
	//				if(rs.getString("nome").equals("João")) {
	//
	//					deleteFuncionario(con,rs.getString("nome"));
	//
	//					deleted = true;
	//
	//				}
	//
	//				if (!deleted) {
	//
	//					System.out.println(rs.getString("nome") +" - "+ sdf.format(rs.getDate("dt_nascimento"))+" - "+ mascaraDinheiro(rs.getBigDecimal("salario"),mascaraReal) +" - "+ rs.getString("funcao"));
	//
	//				}
	//
	//			}
	//
	//
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//			System.out.println(e);
	//		}
	//
	//	}

	//	public void deleteFuncionario(Connection con,String nome) {
	//
	//		StringBuilder sqlBuscaId = new StringBuilder();
	//		sqlBuscaId.append(" SELECT F.ID FROM FUNCIONARIO F, PESSOA P ");
	//		sqlBuscaId.append(" WHERE F.ID = P.ID ");
	//		sqlBuscaId.append(" AND P.NOME = ? ");
	//
	//		int id = 0;
	//
	//		StringBuilder sqlDeletaFunc = new StringBuilder();
	//		sqlDeletaFunc.append(" DELETE FROM FUNCIONARIO");
	//		sqlDeletaFunc.append(" WHERE ID = ? ");
	//
	//		PreparedStatement cDeletaFunc;	    
	//
	//		try {
	//
	//			ResultSet rs = null;
	//
	//			statement = con.prepareStatement(sqlBuscaId.toString());
	//			statement.setString(1, nome);
	//
	//			rs =statement.executeQuery();
	//
	//			while(rs.next()) {
	//
	//				id = rs.getInt("ID"); 
	//
	//			}
	//
	//			cDeletaFunc = con.prepareStatement(sqlDeletaFunc.toString());
	//			cDeletaFunc.setInt(1, id);
	//			cDeletaFunc.executeUpdate();
	//
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//		}
	//
	//
	//
	//	}

	public void programa() {

		insereFuncionarios();

		Scanner sc = new Scanner(System.in);
		Scanner scFunc = new Scanner(System.in);
		int i;

		try {
			do{

				appService.menu();
				i = sc.nextInt();

				switch (i) {
				case 1: {
					listaFuncionarios();
					break;
				}
				case 2:{

					listaFuncionarios();

					System.out.println("-Digite o Id do Funcionário a ser deletado-");
					int idFunc = scFunc.nextInt();

					fr.deletarFuncionarioPorID(idFunc);
					break;
				}case 3:{
					fr.deletarFuncionarioJoao("João");
					break;
				}case 4:{
					fr.aumenta10PCentoSalario();
					listaFuncionarios();
					break;
				}case 5:{

					funcionariosMapeadosFuncao();
					break;
				}case 6:{

					funcionariosAgrupadosFuncao();
					break;
				}case 7:{

					listaFuncionariosMesDezDoze();
					break;

				}case 8:{
					funcionarioMaisVelho();
					break;

				}case 9:{

					listaFuncionariosOrdenados();
					break;

				}case 10:{
					
					totalSalarios();
					break;
					
				}case 11:{
					
					quantidadeSalariosMinimos();
					break;
					
				}
				case 12:{
					resetarBD();
					break;
				}case 0:{
					System.out.println("Até a Próxima!");
					System.exit(i);
					break;
				}
				default:
					System.out.println("-Opção Inválida-");
				}


			}while(i !=0);

			if (i == 0) {

				sc.close();
				scFunc.close();

			} 

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}


	}



	public void insereFuncionarios() {

		Double salarioD = null;

		try {
			workbook = Workbook.getWorkbook(new File(System.getProperty("user.dir")+"\\iniflex.xls"));
		} catch (BiffException | IOException e) {
			e.printStackTrace();
		}

		Sheet sheet = workbook.getSheet(0);


		int linhas = sheet.getRows();

		for(int i = 1; i < linhas; i++){

			Funcionario f = new Funcionario(null, null);

			Cell ca = sheet.getCell(0, i);
			Cell cb = sheet.getCell(1, i);
			Cell cc = sheet.getCell(2, i);
			Cell cd = sheet.getCell(3, i);

			salarioD = new Double(cc.getContents().replace(",", "."));

			f.setId(i);
			f.setName(ca.getContents());
			f.setDtNascimento(LocalDate.parse(cb.getContents(),formatter));
			f.setSalario(BigDecimal.valueOf(salarioD));
			f.setFuncao(cd.getContents());

			fr.salvaFuncionario(f);
		}   

		workbook.close();

	}

	public void listaFuncionarios() {

		List<Funcionario> lista = new ArrayList<Funcionario>();

		lista = fr.listarFuncionarios();

		appService.compararId(lista);

		for (Funcionario funcionario : lista) {

			System.out.println("Id: " + funcionario.getId());
			System.out.println("Nome : " + funcionario.getName());
			System.out.println("Data Nascimento : " + funcionario.getDtNascimento().format(formatter));
			System.out.println("Salario : R$ " + appService.mascaraDinheiro(funcionario.getSalario(),mascaraReal));
			System.out.println("Função : " + funcionario.getFuncao());
			System.out.println("--------------------------------------");

		}

	}

	public void listaFuncionariosMesDezDoze() {

		List<Funcionario> lista = new ArrayList<Funcionario>();



		lista = fr.listarFuncionarios();

		for (Funcionario funcionario : lista) {

			if (funcionario.getDtNascimento().getMonth().getValue() == 10 
					|| funcionario.getDtNascimento().getMonth().getValue() == 12) {
				System.out.println("Nome : " + funcionario.getName());
				System.out.println("Data Nascimento : " + funcionario.getDtNascimento().format(formatter));
				System.out.println("Salario : R$ " + appService.mascaraDinheiro(funcionario.getSalario(),mascaraReal));
				System.out.println("Função : " + funcionario.getFuncao());
				System.out.println("--------------------------------------");
			}

		}

	}

	public void funcionarioMaisVelho() {

		List<Funcionario> lista = new ArrayList<Funcionario>();

		lista = listaFuncionariosPorData();

		System.out.println("Nome : " + lista.get(0).getName());
		System.out.println("Data Nascimento : " + lista.get(0).getDtNascimento().format(formatter));
		System.out.println("--------------------------------------");
	}

	public void listaFuncionariosOrdenados() {

		List<Funcionario> lista = new ArrayList<Funcionario>();

		lista = fr.listarFuncionarios();

		appService.compararNome(lista);

		for (Funcionario funcionario : lista) {

			System.out.println("Nome : " + funcionario.getName());
			System.out.println("Data Nascimento : " + funcionario.getDtNascimento().format(formatter));
			System.out.println("Salario : R$ " + appService.mascaraDinheiro(funcionario.getSalario(),mascaraReal));
			System.out.println("Função : " + funcionario.getFuncao());
			System.out.println("--------------------------------------");

		}

	}

	public void funcionariosMapeadosFuncao() {

		List<Funcionario> lista = new ArrayList<Funcionario>();
		lista = fr.listarFuncionarios();
		List<String> nomesFuncionarios = null ;

		String listaFuncS = null;
		Map<String, List<Funcionario>> listaPorFuncao = lista.stream().collect(Collectors.groupingBy(h -> h.getFuncao()));

		for (Entry<String, List<Funcionario>>  h : listaPorFuncao.entrySet()) {

			nomesFuncionarios= new ArrayList<String>();

			for (Funcionario funcionario : lista) {

				if (h.getKey().equalsIgnoreCase(funcionario.getFuncao())) {
					nomesFuncionarios.add(funcionario.getName());
				}

			}

			listaFuncS = nomesFuncionarios.toString().replace("[", "");
			listaFuncS = listaFuncS.replace("]", "");

			System.out.println("Função : " + h.getKey());
			System.out.println("Nome : " + listaFuncS);
			System.out.println("--------------------------------------");
		}

	}

	public void funcionariosAgrupadosFuncao() {

		List<Funcionario> lista = new ArrayList<Funcionario>();
		lista = fr.listarFuncionarios();

		List<String> nomesFuncionarios = null ;
		String listaFuncS = null;

		Scanner sc = new Scanner(System.in);

		appService.listaFuncoes();
		int funcao = sc.nextInt();
		String funcaoS = null;

		Map<String, List<Funcionario>> listaPorFuncao = lista.stream().collect(Collectors.groupingBy(h -> h.getFuncao()));

		for (Entry<String, List<Funcionario>>  h : listaPorFuncao.entrySet()) {
			nomesFuncionarios= new ArrayList<String>();

			for (Funcionario funcionario : lista) {

				if (h.getKey().equals(funcionario.getFuncao())) {
					nomesFuncionarios.add(funcionario.getName());
				}

			}

			funcaoS = appService.buscaFuncao(funcao);

			if (h.getKey().equalsIgnoreCase(funcaoS)) {

				listaFuncS = nomesFuncionarios.toString().replace("[", "");
				listaFuncS = listaFuncS.replace("]", "");

				System.out.println("Função : " + h.getKey());
				System.out.println("Nome : " + listaFuncS);
				System.out.println("--------------------------------------");
				
			}

		}
	}

	public List<Funcionario> listaFuncionariosPorData() {

		List<Funcionario> lista = new ArrayList<Funcionario>();

		lista = fr.listarFuncionarios();
		appService.comparaData(lista);

		return lista;
	}

	public void resetarBD() {

		fr.deletarTodosFuncionarios();
		insereFuncionarios();

	}


	public void totalSalarios() {
		
		BigDecimal totalSalarios = new BigDecimal(0);
		
		List<Funcionario> lista = new ArrayList<Funcionario>();

		lista = fr.listarFuncionarios();
		
		for (Funcionario funcionario : lista) {
				totalSalarios = totalSalarios.add(funcionario.getSalario());
		}
		
		System.out.println("Total dos Salários : R$ " + appService.mascaraDinheiro(totalSalarios,mascaraReal));
		
	}
	
	public void quantidadeSalariosMinimos() {
		

		double qtdSalarios = 0;
		
		List<Funcionario> lista = new ArrayList<Funcionario>();

		lista = fr.listarFuncionarios();
		
		for (Funcionario funcionario : lista) {
			
			qtdSalarios = appService.qtdSalarioMinimo(Double.parseDouble(funcionario.getSalario().toString()));
			
			System.out.println("Nome : " + funcionario.getName());
			System.out.println("Salário : R$ " + appService.mascaraDinheiro(funcionario.getSalario(),mascaraReal));
			System.out.println("Quantidade Salario Mínimo : " + qtdSalarios);
			System.out.println("--------------------------------------");
			
		}
		
	}

}


