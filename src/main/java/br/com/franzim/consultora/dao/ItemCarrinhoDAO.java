package br.com.franzim.consultora.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.franzim.consultora.entity.ItemCarrinho;
import br.com.franzim.consultora.persistence.JpaUtil;

public class ItemCarrinhoDAO {

	EntityManager em = JpaUtil.getEntityManager();

	public List<ItemCarrinho> getItemCarrinho() {
		return em.createNamedQuery("ItemCarrinho.listarTodos", ItemCarrinho.class)
				.getResultList();
	}

	public void salvar(ItemCarrinho itemCarrinho) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(itemCarrinho);
		tx.commit();
	}
}
