package br.com.mgoficina.factory;

import br.com.mgoficina.repository.impl.IClienteRepositoryImpl;
import br.com.mgoficina.service.IClienteService;
import br.com.mgoficina.service.impl.IClienteServiceImpl;

public class ClienteServiceProvider implements IServiceProvider<IClienteService> {

	private static IClienteService service = new IClienteServiceImpl(new IClienteRepositoryImpl());
	
	@Override
	public IClienteService provide() {
		// TODO Auto-generated method stub
		return service;
	}

}
