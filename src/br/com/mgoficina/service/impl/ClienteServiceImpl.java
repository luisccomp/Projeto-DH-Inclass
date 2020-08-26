package br.com.mgoficina.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import br.com.mgoficina.exception.DataIntegrityException;
import br.com.mgoficina.model.Cliente;
import br.com.mgoficina.service.IClienteService;

public class ClienteServiceImpl implements IClienteService{

	private List<Cliente> clientes;
	
	
	
	public ClienteServiceImpl() {
		clientes = new ArrayList<Cliente>();
	}

		
	
	@Override
	public Cliente create(Cliente cliente) throws DataIntegrityException{
		
		if(cliente.getIdade()<18) {
			throw new DataIntegrityException("idade");
		}
		
		this.clientes.add(cliente);
		return cliente;
	}

	@Override
	public Cliente findClienteById(Long id) {
		for(Cliente cliente: this.clientes) {
			if(cliente.getId() == id) {
				return cliente;
			}
		}
		return null;
		
	}

	@Override
	public Cliente findClienteByNome(String nome) {
		
		
		for(Cliente cliente: this.clientes) {
			if(cliente.getNome().equals(nome)) {
				return  cliente;
			}
		}
		return null;
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

	@Override
	public boolean deleteCliente(Long id) {
		boolean retorno = false;
		int indiceDoObjeto = this.clientes.indexOf(this.findClienteById(id));
		
		if(indiceDoObjeto > -1) {
			this.clientes.remove(this.findClienteById(id));
			retorno = true;
		}	
		
		return retorno;	
		
		
	}
	
	
	
}
