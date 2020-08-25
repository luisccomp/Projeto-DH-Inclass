package br.com.mgoficina.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {
	
	private List<Veiculo> veiculos;

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
	
}
