package br.com.franzim.consultora.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.franzim.consultora.entity.Consultora;
import br.com.franzim.consultora.persistence.JpaUtil;

public class ConsultoraDAO {

	EntityManager em = JpaUtil.getEntityManager();

	public List<Consultora> getConsultoras() {
		return em.createNamedQuery("Consultora.listarTodos", Consultora.class)
				.getResultList();
	}

	public void salvar(Consultora consultora) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(consultora);
		tx.commit();
	}

	public void excluir(Consultora consultora) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(consultora);
		tx.commit();
	}

}
