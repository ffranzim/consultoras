package br.com.franzim.consultora.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.franzim.consultora.entity.Categoria;
import br.com.franzim.consultora.persistence.JpaUtil;

public class CategoriaDAO {

	EntityManager em = JpaUtil.getEntityManager();

	public List<Categoria> getCategorias() {
		return em.createNamedQuery("Categoria.listarTodos", Categoria.class)
				.getResultList();
	}

	public void salvar(Categoria categoria) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(categoria);
		tx.commit();
	}

	public void excluir(Categoria categoria) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(categoria);
		tx.commit();
	}

}
