package br.com.franzim.consultora.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.franzim.consultora.entity.Pedido;
import br.com.franzim.consultora.persistence.JpaUtil;

public class PedidoDAO {

	EntityManager em = JpaUtil.getEntityManager();

	public List<Pedido> getPedidos() {
		return em.createNamedQuery("Pedido.listarTodos", Pedido.class)
				.getResultList();
	}

	public void salvar(Pedido pedido) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(pedido);
		tx.commit();
	}
}
