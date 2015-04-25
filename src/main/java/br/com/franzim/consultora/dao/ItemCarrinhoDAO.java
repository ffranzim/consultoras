package br.com.franzim.consultora.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.franzim.consultora.entity.ItemCarrinho;
import br.com.franzim.consultora.persistence.JpaUtil;

public class ItemCarrinhoDAO {

	EntityManager em = JpaUtil.getEntityManager();

	public List<ItemCarrinho> getItens() {
		return em.createNamedQuery("ItemCarrinho.listarTodos",
				ItemCarrinho.class).getResultList();
	}

	public void salvar(ItemCarrinho item) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(item);
		tx.commit();
	}

	public void excluir(ItemCarrinho item) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(item);
		tx.commit();
	}

	public ItemCarrinho findById(Long pk) throws Throwable {
		EntityManager em = JpaUtil.getEntityManager();
		ItemCarrinho item = em.find(ItemCarrinho.class, pk);
		return item;
	}
}
