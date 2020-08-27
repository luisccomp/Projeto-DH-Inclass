package br.com.mgoficina;

import br.com.mgoficina.model.OrdemServico;
import br.com.mgoficina.model.Servico;
import br.com.mgoficina.model.ServicoOrdemServico;

public class Main {
	
	public static void main(String[] args) {
		Servico s1 = new Servico(1L, "Trocar pneu","");
		Servico s2 = new Servico(2L, "Trocar oleo","");
		Servico s3 = new Servico(3L, "Reparo pisca alerta","");
		
		ServicoOrdemServico sos1 = new ServicoOrdemServico(1L, s1, 4, 20.0);
		ServicoOrdemServico sos2 = new ServicoOrdemServico(2L, s2, 1, 15.0);
		ServicoOrdemServico sos3 = new ServicoOrdemServico(3L, s3, 1, 25.0);
		
		
		OrdemServico os = new OrdemServico(1L);
		
		os.addServico(sos1).addServico(sos2).addServico(sos3);
		
		System.out.println(os.getValorTotal());
		

	}
}
