package br.com.mgoficina.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

	public Cliente findById(Long id) {
		for(Cliente cliente: this.clientes) {
			if(cliente.getId() == id) {
				return cliente;
			}
		}
		
		return null;
		
	}

	@Override
	public Cliente findByNome(String nome) {

		return this.clientes.stream()
			.filter(cliente -> cliente.getNome() == nome)
			.findAny()
			.orElseThrow(() -> new RuntimeException("Objeto n econtrado"));
	}

	@Override
	public List<Cliente> findAll() {
		return Collections.unmodifiableList(this.clientes);
	}

	@Override
	public boolean update(Cliente cliente) {
		
		boolean retorno = false;
		int indiceDoObjeto = this.clientes.indexOf(this.findById(cliente.getId()));
		
		if(indiceDoObjeto > -1) {
			this.clientes.remove(this.findById(cliente.getId()));
			this.clientes.add(indiceDoObjeto, cliente);
			retorno = true;
		}	
		
		return retorno;
		
	}


	@Override
	public boolean delete(Long id) {
		boolean retorno = false;
		int indiceDoObjeto = this.clientes.indexOf(this.findById(id));
		
		if(indiceDoObjeto > -1) {
			this.clientes.remove(this.findById(id));
			retorno = true;
		}	
		
		return retorno;	
		
		
	}
	
	@Override
	public Set<Cliente> findIdadeMaior(int idade){
	
		 return  this.clientes.stream()
				.filter(cliente -> cliente.getIdade() >= idade)
				.collect(Collectors.toSet());
		
	}
	
	
	public int totalCarros(){
		
		 return  this.clientes.stream()
				 .mapToInt(cliente -> cliente.getVeiculos().size())
				 .sum();
		
	}
	
}
