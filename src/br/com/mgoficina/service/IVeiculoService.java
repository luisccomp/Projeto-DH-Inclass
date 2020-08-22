package br.com.mgoficina.service;

import java.util.List;

import br.com.mgoficina.model.Veiculo;

public interface IVeiculoService {

	public Veiculo create(Veiculo veiculo);
	public Veiculo findClienteById(int indice);
	public Veiculo findClienteByChassi(String chassi);
	public List<Veiculo> findAll();
	public boolean updateVeiculo(Veiculo veiculo);
	public boolean deleteVeiculo(int indice);
	
}
