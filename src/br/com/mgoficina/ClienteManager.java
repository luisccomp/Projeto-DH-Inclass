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
			
			boolean run = true;
			
			while (run) {
				System.out.println("Selecione um atributo para atualizar.");
				System.out.println("Nome: " + cliente.getNome());
				System.out.println("CPF: " + cliente.getCpf());
				System.out.println("Idade: " + cliente.getIdade());
				System.out.println("Sexo: " + cliente.getSexo());
				System.out.println("Veiculos: " + cliente.getVeiculos().size());
				System.out.println();
				System.out.println("Selecione um atributo:");
				System.out.println("1 - Nome;");
				System.out.println("2 - Idade;");
				System.out.println("3 - Sexo");
				System.out.println("Digite 4 para salvar;");
				System.out.println("Digite 0 para cancelar.");
				System.out.print("> ");
				
				int opcao = Integer.parseInt(reader.readLine());
				
				switch (opcao) {
				case 1:
					System.out.println("Digite o nome:");
					String nome = reader.readLine();
					
					cliente.setNome(nome);
					break;
				case 2:
					System.out.println("Digite a Idade:");
					int idade = Integer.parseInt(reader.readLine());
					
					cliente.setIdade(idade);
					break;
				case 3:
					System.out.println("Digite o sexo:");
					char sexo = reader.readLine().charAt(0);
					
					cliente.setSexo(sexo);
					break;
				case 4:
					service.update(cliente);
				case 0:
					run = false;
					break;
				default:
					System.out.println("Opção inválida...");
				}
			}
		} catch (ObjectNotFoundException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void deletarCliente(BufferedReader reader) throws IOException {
		System.out.println(":.:.:.: Deletar cliente :.:.:.:");
		System.out.println();
		System.out.println("Digite o CPF do cliente:");
		String cpf = reader.readLine();
		
		try {
			Cliente cliente = service.findByCpf(cpf);
			service.delete(cliente);
		} catch (ObjectNotFoundException e ) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
}
