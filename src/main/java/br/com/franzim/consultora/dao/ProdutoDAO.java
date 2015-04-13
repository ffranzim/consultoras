package br.com.franzim.consultora.dao;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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

}
