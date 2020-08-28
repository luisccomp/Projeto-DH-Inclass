package br.com.mgoficina;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static ClienteManager clienteManager = new ClienteManager();
	static VeiculoManager veiculoManager = new VeiculoManager();
	
	public static void main(String[] args) throws IOException {		
		boolean run = true;
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		while (run) {
			System.out.println("----------------------------------------------");
			System.out.println("Sistema MG Oficina");
			System.out.println("1 - Área do cliente;");
			System.out.println("Digite 0 para sair...");
			System.out.println();
			System.out.println("----------------------------------------------");
			System.out.print("> ");
			
			int option = Integer.parseInt(reader.readLine());
			
			switch (option) {
			case 1:
				System.out.println("Área do cliente.");
				areaDoCliente(reader);
				break;
			case 0:
				run = false;
				break;
			default:
				System.out.println("Opção inválida...");
			}
			
			System.out.flush();
		}
		
		reader.close();
	}
	
	public static void areaDoCliente(BufferedReader reader) throws IOException {
		boolean run = true;
		
		while (run) {
			System.out.println("----------------------------------------------");
			System.out.println("Sistema MG Oficina");
			System.out.println("1 - Listar clientes");
			System.out.println("2 - Detalhes de um cliente");
			System.out.println("3 - Salvar cliente");
			System.out.println("4 - Atualizar cliente");
			System.out.println("5 - Deletar cliente");
			System.out.println("6 - Listar clientes pelo nome;");
			System.out.println("7 - Registrar veiculo para o cliente;");
			System.out.println("Digite 0 para voltar ao menu principal");
			System.out.println();
			System.out.println("----------------------------------------------");
			System.out.print("> ");
			
			int option = Integer.parseInt(reader.readLine());
			
			switch (option) {
			case 1:
				clienteManager.listarClientes();				
				break;
			case 2:
				clienteManager.detalheCliente(reader);
				break;
			case 3:
				clienteManager.cadastrarCliente(reader);
				break;
			case 0:
				run = false;
				break;
			default:
				System.out.println("Opção inválida...");
			}
			
			System.out.flush();
		}
	}
	
}
