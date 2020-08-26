package br.com.mgoficina.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cliente extends Pessoa{
	
	
	private List<Veiculo> veiculos = new ArrayList<>();
	
	public Cliente(Long id, String nome, String cpf, int idade, char sexo,List<Veiculo> veiculo) {
		super(id, nome, cpf, idade, sexo);
	}
	public Cliente(Long id, String nome, int idade, char sexo) {
		super(id,nome,null,idade,sexo);
	}

	public List<Veiculo> getVeiculos() {
		return Collections.unmodifiableList(this.veiculos);
	}

	public void addVeiculos(Veiculo veiculos) {
		this.veiculos.add(veiculos);
	}
	
	public void removeVeiculos(Veiculo veiculos) {
		this.veiculos.remove(veiculos);
	}
	
	
	
}
