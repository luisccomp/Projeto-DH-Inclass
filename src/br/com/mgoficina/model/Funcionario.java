package br.com.mgoficina.model;

public class Funcionario extends Pessoa{
	
	
	private String cargo;

	public Funcionario(Long id, String nome, String cpf, int idade, char sexo, String cargo) {
		super(id, nome, cpf, idade, sexo);
		this.cargo = cargo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	
	
	
}
