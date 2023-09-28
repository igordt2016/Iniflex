package br.com.projedata.iniflex.repository;

import java.util.List;

import br.com.projedata.iniflex.model.Funcionario;

public interface IFuncionarioRepository {


		public boolean salvaFuncionario(Funcionario funcionario);
		public boolean deletarFuncionarioPorID(long id);
		public boolean aumenta10PCentoSalario();
		public List<Funcionario> listarFuncionarios();
		public boolean deletarTodosFuncionarios();
		public boolean deletarFuncionarioJoao(String nome);
		
	
}
