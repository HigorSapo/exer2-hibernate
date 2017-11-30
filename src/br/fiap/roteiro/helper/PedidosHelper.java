package br.fiap.roteiro.helper;

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

}
