package br.com.mgoficina;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import br.com.mgoficina.model.Cliente;
import br.com.mgoficina.model.Veiculo;
import br.com.mgoficina.service.IClienteService;
import br.com.mgoficina.service.impl.ClienteServiceImpl;

public class Main {
	
	public static void main(String[] args) {
		
		Cliente cliente = new Cliente(1l,"Ronisclei",18,'M');
		Cliente cliente2 = new Cliente(2l,"Maria",22,'F');
		Cliente cliente3 = new Cliente(3l,"João",25,'M');
		
		cliente.addVeiculos(new Veiculo("PQR-123"));
		cliente2.addVeiculos(new Veiculo("ABC-321"));
		cliente3.addVeiculos(new Veiculo("HEL-333"));
		
		List<Cliente> clientes = new ArrayList<>();
		clientes.add(cliente);
		clientes.add(cliente2);
		clientes.add(cliente3);


	    
		
	}
}
