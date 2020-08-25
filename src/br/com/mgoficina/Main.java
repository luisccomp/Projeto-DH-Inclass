package br.com.mgoficina;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.mgoficina.model.Cliente;
import br.com.mgoficina.service.IClienteService;
import br.com.mgoficina.service.impl.ClienteServiceImpl;

public class Main {
	
	public static void main(String[] args) {
		
		Cliente cliente = new Cliente(1l,"Gustavo", "111",18,'M',new ArrayList<>());
		
		IClienteService clienteService = new ClienteServiceImpl();
		clienteService.create(cliente);
		System.out.println(clienteService.findAll().size());
	}
}
