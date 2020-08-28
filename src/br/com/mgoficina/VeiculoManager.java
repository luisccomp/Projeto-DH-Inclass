package br.com.mgoficina;

import java.io.BufferedReader;
import java.io.IOException;

import br.com.mgoficina.exception.DataIntegrityException;
import br.com.mgoficina.exception.ObjectNotFoundException;
import br.com.mgoficina.factory.ClienteServiceProvider;
import br.com.mgoficina.factory.VeiculoServiceProvider;
import br.com.mgoficina.model.Cliente;import br.com.mgoficina.model.Veiculo;
import br.com.mgoficina.service.IClienteService;
import br.com.mgoficina.service.IVeiculoService;

public class VeiculoManager {

	private IVeiculoService veiculoService = new VeiculoServiceProvider().provide();
	private IClienteService clienteService = new ClienteServiceProvider().provide();
	
	public void listarVeiculos() {
		System.out.println(":.:.:.: Listando os veiculos :.:.:.:");
		System.out.println();
		
		veiculoService.findAll()
				.forEach(veiculo -> {
					System.out.println("ID: " + veiculo.getId());
					System.out.println("Placa: " + veiculo.getPlaca());
					System.out.println("Ano: " + veiculo.getAno());
					System.out.println("Cor: " + veiculo.getCor());
					System.out.println("Chassi: " + veiculo.getChassi());
					System.out.println("Tipo: " + veiculo.getTipo());
				});
		
		System.out.println("---------------------------------");
	}

	public void detalhesDoVeiculo(BufferedReader reader) throws IOException {
		System.out.println(":.:.:.: Detalhes do veículo :.:.:.:");
		System.out.println();
		
		System.out.println("Digite o ID do veículo:");
		long id = Long.parseLong(reader.readLine());
		
		try {
			Veiculo veiculo = veiculoService.findById(id);
		} catch (ObjectNotFoundException e) {
			System.out.println("Veiculo não encontrado");
		}
	}
	
	public void adicionarVeiculo(BufferedReader reader) throws IOException {
		System.out.println(":.:.: Adicionar veiculo :.:.:");
		System.out.println("Digite o cpf do cliente:");
		String cpf = reader.readLine();
		
		try {
			Cliente cliente = clienteService.findByCpf(cpf);
			
			System.out.print("Placa: ");
			String placa = reader.readLine();
			
			System.out.print("Modelo: ");
			String modelo = reader.readLine();
			
			System.out.print("Ano: ");
			int ano = Integer.parseInt(reader.readLine());
			
			System.out.println("Cor: ");
			String cor = reader.readLine();
			
			System.out.println("Chassi: ");
			String chassi = reader.readLine();
			
			System.out.println("Tipo: ");
			String tipo = reader.readLine();
			
			Veiculo veiculo = new Veiculo(null, placa, modelo, ano, cor, chassi, tipo);
			
			veiculo = veiculoService.create(veiculo);
			
			cliente.getVeiculos().add(veiculo);
			clienteService.update(cliente);
		} catch (ObjectNotFoundException e) {
			// TODO: handle exception
			System.out.println("Erro: " + e.getMessage());
		} catch (DataIntegrityException e) {
			// TODO: handle exception
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
}
