package br.fiap.roteiro.helper;

import java.util.Date;
import java.util.List;

import br.fiap.roteiro.entity.Clientes;
import br.fiap.roteiro.entity.Pedidos;

public class TestePedidos {

	private static PedidosHelper helper = new PedidosHelper();
	
	public static void main(String[] args) {
		
		incluirClientePedidoAlternativo();
		listarPedidosPorCliente();

	}
	
	private static void incluirClientePedidoAlternativo() {
		Clientes c1 = new Clientes();
		c1.setNome("Higão");
		c1.setEmail("higor.xsapo@gmail.com");
		System.out.println(helper.Salvar(c1));
		
		Pedidos p1 = new Pedidos();
		p1.setData(new Date());
		p1.setDescricao("Kit lanterna Astra love");
		p1.setValor(10.00);
		p1.setClientes(c1);
		System.out.println(helper.Salvar(p1));
		
		Pedidos p2 = new Pedidos();
		p2.setData(new Date());
		p2.setDescricao("Kit lanterna Astra love");
		p2.setValor(10.00);
		p2.setClientes(c1);
		System.out.println(helper.Salvar(p2));
		
	}
	
	private static void listarPedidosPorCliente() {
		PedidosHelper helper = new PedidosHelper();
		List<Pedidos> pedidos = helper.listarPedidos(1);
		for (Pedidos pedido : pedidos) {
			System.out.println("ID do pedido: " + pedido.getId());
			System.out.println("Descriçao: " + pedido.getDescricao());
			System.out.println("Valor: " + pedido.getValor());
			System.out.println("--------------------------------------------");
		}
	}

}
