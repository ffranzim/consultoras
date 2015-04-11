package teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.franzim.consultora.entity.Usuario;
import br.com.franzim.consultora.persistence.JpaUtil;

public class PersistidorUsuario {

	public static void main(String[] args) {

		EntityManager em = JpaUtil.getEntityManager();

		 incluirUsuario(em);
		 listaUsuarios(em);
//		buscaUsuarioId(em, 1L);
//		buscaUsuarioIdOutroJeito(em, 2L);

		// consultaTeste(em);
		// incluirAutomovel(em);
		// listarAutomovel(em);
		// excluirAutomovel(em);
		// jpqlTeste(em);
		// jpqlTestePassandoParametros(em);
		// jpqlTesteAgregacao(em);
		// jpqlTesteSubConsulta(em);
		// jpqlTesteSubConsulta2(em);
		// jpqlTesteResultadoEstranhoComNew(em);
		// jpqlTesteNamedQuery(em);
		// jpqlTesteNamedQuery2(em);
		// jpqlTesteNamedQueryComParametro(em);
		em.close();
	}

	private static void incluirUsuario(EntityManager em) {

		Usuario u = new Usuario("Ricardo0", "f@gmail.com", "franzimF1",
				"senha02");
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(u);
		tx.commit();
	}

	private static void listaUsuarios(EntityManager em) {
		Query q = em.createNamedQuery("Usuario.listarTodos");
		@SuppressWarnings("unchecked")
		List<Usuario> usuarios = q.getResultList();

		int i = 0;
		for (Usuario u : usuarios) {
			System.out.println("Dados do usuario:" + i);
			System.out.println("Id : " + u.getId());
			System.out.println("Nome : " + u.getNome());
			System.out.println("Email : " + u.getEmail());
			System.out.println("Senha : " + u.getSenha());

			i++;
		}
	}

	private static void buscaUsuarioId(EntityManager em, long id) {
		Usuario u = em.find(Usuario.class, id);
		
		System.out.println("Id : " + u.getId());
		System.out.println("Nome : " + u.getNome());
		System.out.println("Email : " + u.getEmail());
		System.out.println("Senha : " + u.getSenha());
		
	}
	

	private static void buscaUsuarioIdOutroJeito(EntityManager em, long id) {
		Query q = em.createNamedQuery("Usuario.buscaUsuarioId");
		q.setParameter("id", id);
		@SuppressWarnings("unchecked")
		List<Usuario> usuarios = q.getResultList();

		int i = 0;
		for (Usuario u : usuarios) {
			System.out.println("Dados do usuario:" + i);
			System.out.println("Id : " + u.getId());
			System.out.println("Nome : " + u.getNome());
			System.out.println("Email : " + u.getEmail());
			System.out.println("Senha : " + u.getSenha());

			i++;
		}
	}
	
	
	
	
	// private static void buscaUsuarioIdTipo2(EntityManager em, Long id) {
	// Query q = em.createNamedQuery("Usuario.buscaUsuarioId");
	// q.setParameter("id", id);
	// @SuppressWarnings("unchecked")
	// List<Usuario> usuarios = q.getResultList();
	//
	// int i = 0;
	// for (Usuario u : usuarios) {
	// System.out.println("Dados do usuario:" + i);
	// System.out.println("Id : " + u.getId());
	// System.out.println("Nome : " + u.getNome());
	// System.out.println("Email : " + u.getEmail());
	// System.out.println("Senha : " + u.getSenha());
	//
	// i++;
	// }
	// }

}
