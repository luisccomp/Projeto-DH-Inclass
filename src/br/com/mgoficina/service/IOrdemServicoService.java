package br.com.mgoficina.service;

import java.util.List;

import br.com.mgoficina.model.OrdemServico;


public interface IOrdemServicoService {

	public OrdemServico create(OrdemServico ordemService);
	public OrdemServico findOrdemServicoById(Long id);
	public OrdemServico findOrdemServicoByNome(String nome);
	public List<OrdemServico> findAll();
	public boolean updateOrdemServico(OrdemServico ordemService);
	public boolean deleteOrdemServico(Long id);
}
