package br.com.mgoficina.factory;

import br.com.mgoficina.repository.impl.IVeiculoRepositoryImpl;
import br.com.mgoficina.service.IVeiculoService;
import br.com.mgoficina.service.impl.IVeiculoServiceImpl;

public class VeiculoServiceProvider implements IServiceProvider<IVeiculoService> {
	
	private static IVeiculoService service = new IVeiculoServiceImpl(new IVeiculoRepositoryImpl());

	@Override
	public IVeiculoService provide() {
		// TODO Auto-generated method stub
		return service;
	}

}
