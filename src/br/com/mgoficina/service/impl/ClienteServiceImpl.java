package br.com.mgoficina.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
	public Cliente findById(Long id) {
		Cliente retorno = null;
		for(Cliente cliente: this.clientes) {
			if(cliente.getId() == id) {
				retorno = cliente;
			}
		}
		return retorno;
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
	
//	@Override
//	public Set<Cliente> findIdadeMaior(int idade){
//		Set<Cliente> retorno = new HashSet<>();
//		
//		for(int i =0; i < this.clientes.size(); i++) {
//			if(clientes.get(i).getIdade() >= idade) {
//				retorno.add(clientes.get(i));
//			}
//		}
//		
//	
//		return retorno;
//		
//	}
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
