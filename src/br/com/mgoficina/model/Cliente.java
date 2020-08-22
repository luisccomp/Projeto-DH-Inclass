package br.com.mgoficina.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {
	
	private Long id;
	
	private List<Veiculo> veiculos;

	public Cliente(String nome, String cpf, int idade, char sexo) {
		super(nome, cpf, idade, sexo);
		this.veiculos = new ArrayList<>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
	
}
