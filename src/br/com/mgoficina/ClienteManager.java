package br.com.mgoficina;

import java.io.BufferedReader;
import java.io.IOException;

import br.com.mgoficina.exception.ObjectNotFoundException;
import br.com.mgoficina.factory.ClienteServiceProvider;
import br.com.mgoficina.model.Cliente;
import br.com.mgoficina.service.IClienteService;

public class ClienteManager {

	private IClienteService service = new ClienteServiceProvider().provide();
	
	public void cadastrarCliente(BufferedReader reader) throws IOException {		
		System.out.println("Entre com os dados do cliente.");
		
		System.out.print("nome: ");
		String nome = reader.readLine();
		
		System.out.print("cpf: ");
		String cpf = reader.readLine();
		
		System.out.print("idade: ");
		int idade = Integer.parseInt(reader.readLine());
		
		System.out.print("sexo: ");
		char sexo = reader.readLine().charAt(0);
		
		Cliente cliente = new Cliente(null, nome, cpf, idade, sexo);
		
		service.create(cliente);
		
		System.out.println("Cliente salvo com sucesso...");
	}

	public void listarClientes() {
		System.out.println(":.:.:.: Lista de clientes :.:.:.:.:");
		
		service.findAll()
				.forEach(cliente -> {
					System.out.println("Nome: " + cliente.getNome());
					System.out.println("CPF: " + cliente.getCpf());
					System.out.println("Idade: " + cliente.getIdade());
					System.out.println("Sexo: " + cliente.getSexo());
					System.out.println("Veiculos: " + cliente.getVeiculos().size());
				});
		
		System.out.println("-----------------------------------");
	}
	
	public void detalheCliente(BufferedReader reader) throws IOException {
		System.out.println(":.:.:.: Detalhes do cliente :.:.:.:");
		
		try {
			System.out.println("Digite o id do cliente:");
			long id = Integer.parseInt(reader.readLine());
			
			Cliente cliente = service.findById(id);
			
			System.out.println("Nome: " + cliente.getNome());
			System.out.println("CPF: " + cliente.getCpf());
			System.out.println("Idade: " + cliente.getIdade());
			System.out.println("Sexo: " + cliente.getSexo());
			System.out.println("Veiculos: " + cliente.getVeiculos().size());
		} catch (ObjectNotFoundException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void atualizarCliente(BufferedReader reader) throws IOException {
		System.out.println(":.:.:.: Atualizar os dados do cliente :.:.:.:");
		System.out.println();
		System.out.println("Digite o CPF do cliente:");
		String cpf = reader.readLine();
		
		try {
			Cliente cliente = service.findByCpf(cpf);
			
			System.out.println("Nome: " + cliente.getNome());
			System.out.println("CPF: " + cliente.getCpf());
			System.out.println("Idade: " + cliente.getIdade());
			System.out.println("Sexo: " + cliente.getSexo());
			System.out.println("Veiculos: " + cliente.getVeiculos().size());
			
			
			
		} catch (ObjectNotFoundException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
}
