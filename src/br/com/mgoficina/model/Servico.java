package br.com.mgoficina.model;

import java.time.LocalDate;

public class Servico {

	private Long id;
	
	private String nomeDoServico;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private double valor;
	private String metodoPagamento;
	private Cliente cliente;

	public Servico(Long id, String nomeDoServico, LocalDate dataInicio, LocalDate dataFim, double valor, String metodoPagamento,
			Cliente cliente) {
		super();
		this.id = id;
		this.nomeDoServico = nomeDoServico;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.valor = valor;
		this.metodoPagamento = metodoPagamento;
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeDoServico() {
		return nomeDoServico;
	}

	public void setNomeDoServico(String nomeDoServico) {
		this.nomeDoServico = nomeDoServico;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getMetodoPagamento() {
		return metodoPagamento;
	}

	public void setMetodoPagamento(String metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
