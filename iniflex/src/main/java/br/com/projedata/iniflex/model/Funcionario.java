package br.com.projedata.iniflex.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;

public class Funcionario extends Pessoa implements Comparator<Funcionario>{

	public Funcionario(String name, LocalDate dtNascimento) {
		super(name, dtNascimento);
		// TODO Auto-generated constructor stub
	}
	private int id;
	private BigDecimal salario;
	private String funcao;


	public BigDecimal getSalario() {
		return salario;
	}
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public int compare(Funcionario o1, Funcionario o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}
}
