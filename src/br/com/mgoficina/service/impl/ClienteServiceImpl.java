package br.com.mgoficina.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.mgoficina.model.Cliente;
import br.com.mgoficina.service.IClienteService;

public class ClienteServiceImpl implements IClienteService{

	private List<Cliente> clientes;
	
	
	
	public ClienteServiceImpl() {
		clientes = new ArrayList<Cliente>();
	}
	public ClienteServiceImpl(List<Cliente> clientes) {
		this.clientes = new ArrayList<>(clientes);
	} 
	
		
	
	@Override
	public Cliente create(Cliente cliente) {
		this.clientes.add(cliente);
		return cliente;
	}

	@Override
	public Cliente findClienteById(long id) {
		Cliente retorno = null;
		for(Cliente cliente: this.clientes) {
			if(cliente.getId() == id) {
				retorno = cliente;
			}
		}
		return retorno;
	}

	@Override
	public Cliente findClienteByNome(String nome) {
		
		Cliente retorno = null;
		for(Cliente cliente: this.clientes) {
			if(cliente.getNome().equals(nome)) {
				retorno = cliente;
			}
		}
		return retorno;
	}

	@Override
	public List<Cliente> findAll() {
		return Collections.unmodifiableList(this.clientes);
	}

	@Override
	public boolean updateCliente(Cliente cliente) {
		
		boolean retorno = false;
		int indiceDoObjeto = this.clientes.indexOf(this.findClienteById(cliente.getId()));
		
		if(indiceDoObjeto > -1) {
			this.clientes.remove(this.findClienteById(cliente.getId()));
			this.clientes.add(indiceDoObjeto, cliente);
			retorno = true;
		}	
		
		return retorno;
		
	}

	public boolean deleteCliente(long id) {
		boolean retorno = false;
		int indiceDoObjeto = this.clientes.indexOf(this.findClienteById(id));
		
		if(indiceDoObjeto > -1) {
			this.clientes.remove(this.findClienteById(id));
			retorno = true;
		}	
		
		return retorno;
		
	}
	
	
	
}
