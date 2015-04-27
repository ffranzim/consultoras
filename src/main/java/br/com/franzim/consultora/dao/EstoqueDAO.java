package br.com.franzim.consultora.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.franzim.consultora.entity.Estoque;
import br.com.franzim.consultora.persistence.JpaUtil;

public class EstoqueDAO {

	EntityManager em = JpaUtil.getEntityManager();

	public List<Estoque> getEstoques() {
		return em.createNamedQuery("Estoque.listarTodos", Estoque.class)
				.getResultList();
	}

	public void salvar(Estoque estoque) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(estoque);
		tx.commit();
	}
	
	public void excluir(Estoque estoque) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(estoque);
		tx.commit();
	}
	
	public Estoque findById(Long pk) throws Throwable{
		EntityManager em = JpaUtil.getEntityManager();
		Estoque estoque = em.find(Estoque.class, pk);
		return estoque;
	}
}
