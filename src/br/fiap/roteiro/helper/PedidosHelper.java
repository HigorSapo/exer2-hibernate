package br.fiap.roteiro.helper;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.fiap.roteiro.config.HibernateUtil;
import br.fiap.roteiro.entity.Clientes;
import br.fiap.roteiro.entity.Pedidos;

public class PedidosHelper {
	
	Session session = null;
	Transaction transaction = null;
	
	public void encerrar() {
		session.close();
	}
	
	public String Salvar(Pedidos pedidos) {
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			transaction = session.beginTransaction();
			session.save(pedidos);
			transaction.commit();
			return "Pedidos salvo";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String Salvar(Clientes clientes) {
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			transaction = session.beginTransaction();
			session.save(clientes);
			transaction.commit();
			return "Clientes salvo";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public List<Pedidos> listarPedidos(int idPedido) {
		List<Pedidos> pedidos = new ArrayList<Pedidos>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Clientes c = (Clientes) session.load(Clientes.class, idPedido);
			pedidos = c.getPedidos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pedidos;
	}

}
