package br.com.mgoficina.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {

	private List<Veiculo> veiculos;
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
		veiculos = new ArrayList<>();
	}

	public Cliente(Long id, String nome, String cpf, int idade, char sexo) {
		super(id, nome, cpf, idade, sexo);
		// TODO Auto-generated constructor stub
		veiculos = new ArrayList<>();
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	@Override
	public String toString() {
		return "Cliente [veiculos=" + veiculos + ", nome=" + nome + ", cpf=" + cpf + ", idade=" + idade + ", sexo="
				+ sexo + ", id=" + id + "]";
	}
	
}
