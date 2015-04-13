package br.com.franzim.consultora.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.franzim.consultora.entity.Marca;
import br.com.franzim.consultora.persistence.JpaUtil;

public class MarcaDAO {

	EntityManager em = JpaUtil.getEntityManager();

	public List<Marca> getMarcas() {
		return em.createNamedQuery("Marca.listarTodos", Marca.class)
				.getResultList();
	}

	public void salvar(Marca marca) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(marca);
		tx.commit();
	}
}
