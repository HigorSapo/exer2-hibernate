package br.fiap.roteiro.helper;

import java.util.Date;

import br.fiap.roteiro.entity.Clientes;
import br.fiap.roteiro.entity.Pedidos;

public class TestePedidos {

	private static PedidosHelper helper = new PedidosHelper();
	
	public static void main(String[] args) {
		
		incluirClientePedidoAlternativo();

	}
	
	private static void incluirClientePedidoAlternativo() {
		Clientes c1 = new Clientes();
		c1.setNome("Higão");
		c1.setEmail("higor.xsapo@gmail.com");
		System.out.println(helper.Salvar(c1));
		
		Pedidos p1 = new Pedidos();
		p1.setData(new Date());
		p1.setDescricao("Kit lanterna Astra");
		p1.setValor(10.00);
		p1.setClientes(c1);
		System.out.println(helper.Salvar(p1));
		
	}

}
