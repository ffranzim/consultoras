package br.com.franzim.consultora.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.franzim.consultora.entity.Cliente;
import br.com.franzim.consultora.persistence.JpaUtil;

public class ClienteDAO {

	EntityManager em = JpaUtil.getEntityManager();

	public List<Cliente> getClientes() {
		return em.createNamedQuery("Cliente.listarTodos", Cliente.class).getResultList();
	}

	public void salvar(Cliente cliente) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(cliente);
		tx.commit();
	}

}
