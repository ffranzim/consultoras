package br.com.franzim.consultora.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.franzim.consultora.entity.Usuario;
import br.com.franzim.consultora.persistence.JpaUtil;

public class UsuarioDAO {

	EntityManager em = JpaUtil.getEntityManager();

	public List<Usuario> getUsuario() {
		return em.createNamedQuery("Usuario.listarTodos", Usuario.class).getResultList();
	}

	public void salvar(Usuario usuario) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(usuario);
		tx.commit();
	}

}
