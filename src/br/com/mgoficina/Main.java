package br.com.mgoficina;

import java.util.ArrayList;
import java.util.List;

import br.com.mgoficina.model.Cliente;
import br.com.mgoficina.model.OrdemServico;
import br.com.mgoficina.model.Servico;
import br.com.mgoficina.model.ServicoOrdemServico;
import br.com.mgoficina.model.Veiculo;

public class Main {
	
	public static void main(String[] args) {
		
		Cliente cliente = new Cliente(1l,"Ronisclei",18,'M');
		Cliente cliente2 = new Cliente(2l,"Maria",22,'F');
		Cliente cliente3 = new Cliente(3l,"João",25,'M');
		
		cliente.addVeiculos(new Veiculo("PQR-123"));
		cliente2.addVeiculos(new Veiculo("ABC-321"));
		cliente3.addVeiculos(new Veiculo("HEL-333"));
		
		List<Cliente> clientes = new ArrayList<>();
		clientes.add(cliente);
		clientes.add(cliente2);
		clientes.add(cliente3);

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
