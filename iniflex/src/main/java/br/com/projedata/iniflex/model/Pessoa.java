package br.com.projedata.iniflex.model;

import java.time.LocalDate;

public class Pessoa {

	private String name;
	private LocalDate dtNascimento;



	public Pessoa(String name, LocalDate dtNascimento) {
		super();
		this.name = name;
		this.dtNascimento = dtNascimento;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(LocalDate dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

}
