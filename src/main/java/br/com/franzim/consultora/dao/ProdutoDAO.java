package br.com.franzim.consultora.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.franzim.consultora.entity.Produto;
import br.com.franzim.consultora.persistence.JpaUtil;

public class ProdutoDAO {

	EntityManager em = JpaUtil.getEntityManager();

	public List<Produto> getProdutos() {
		return em.createNamedQuery("Produto.listarTodos", Produto.class)
				.getResultList();
	}

	public void salvar(Produto produto) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(produto);
		tx.commit();
	}
	
	public void excluir(Produto produto) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(produto);
		tx.commit();
	}
	
	public Produto findById(Long pk) throws Throwable{
		EntityManager em = JpaUtil.getEntityManager();
		Produto produto = em.find(Produto.class, pk);
		return produto;
	}
}
