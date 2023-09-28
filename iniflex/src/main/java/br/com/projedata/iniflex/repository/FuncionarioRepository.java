package br.com.projedata.iniflex.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.projedata.iniflex.model.Funcionario;

public class FuncionarioRepository implements IFuncionarioRepository{

	List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();

	@Override
	public boolean salvaFuncionario(Funcionario funcionario) {

		try {

			listaFuncionarios.add(funcionario);

		} catch (Exception e) {
			return false;
		}

		return true;
	}
	
	@Override
	public boolean deletarFuncionarioPorID(long id) {

		for (int i = 0; i < listaFuncionarios.size(); i++) {
			Funcionario funcionario = listaFuncionarios.get(i);

			if (funcionario.getId() == id) {

				listaFuncionarios.remove(i);
				
			}

		}

		return false;
	}
	
	@Override
	public boolean aumenta10PCentoSalario() {

		for (int i = 0; i < listaFuncionarios.size(); i++) {
			Funcionario funcionario = listaFuncionarios.get(i);
			funcionario.setSalario(funcionario.getSalario().add(funcionario.getSalario().multiply(new BigDecimal(0.1))));

		}

		return false;
	}
	
	@Override
	public boolean deletarTodosFuncionarios() {


		listaFuncionarios.removeAll(listaFuncionarios);


		return false;
	}
	
	@Override
	public boolean deletarFuncionarioJoao(String nome) {

		for (int i = 0; i < listaFuncionarios.size(); i++) {
			Funcionario funcionario = listaFuncionarios.get(i);

			if (funcionario.getName().equals(nome)) {

				listaFuncionarios.remove(i);
				
			}

		}

		return false;
	}
	
	@Override
	public List<Funcionario> listarFuncionarios() {
		// TODO Auto-generated method stub
		return this.listaFuncionarios;
	}
	
}
