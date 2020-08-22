package br.com.mgoficina.model;

import java.util.ArrayList;
import java.util.List;

public class Funcionario extends Pessoa {
	
	private String cargo;
	private List<Servico> servicos;
	
	public Funcionario(String nome, String cpf, int idade, char sexo, String cargo) {
		super(nome, cpf, idade, sexo);
		this.cargo = cargo;
		this.servicos = new ArrayList<>();
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}
	
}
