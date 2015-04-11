package teste;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.franzim.consultora.entity.Categoria;
import br.com.franzim.consultora.entity.Marca;
import br.com.franzim.consultora.entity.Produto;
import br.com.franzim.consultora.persistence.JpaUtil;

public class PersistidorProduto {

	public static void main(String[] args) {

		EntityManager em = JpaUtil.getEntityManager();

		incluirProduto(em);
//		listaProdutos(em);
		// buscaUsuarioId(em, 1L);
		// buscaUsuarioIdOutroJeito(em, 2L);

		em.close();
	}

	private static void incluirProduto(EntityManager em) {

		// public Produto(String nome, Date dtVencimento, String descricao,
		// String codigo, double valor, Integer qtdUnidade) {

		
		Produto p = new Produto("Produto2", new Date("01/01/15"),
				"Qualquer Coisa", "A3331", new Double(21.15), 2, new Marca("Frimesa"), new Categoria("Suina"));
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(p);
		tx.commit();
	}

	 private static void listaProdutos(EntityManager em) {
	 Query q = em.createNamedQuery("Produto.listarTodos");
	 @SuppressWarnings("unchecked")
	 List<Produto> produtos = q.getResultList();
	
	 int i = 0;
	 for (Produto p : produtos) {
	 System.out.println("Dados do Produto:" + i);
	 System.out.println("Id : " + p.getId());
	 System.out.println("Nome : " + p.getNome());
	 System.out.println("Descricao : " + p.getDescricao());
	 System.out.println("QtdUnidade" + p.getQtdUnidade());
	
	 i++;
	 }
	 }
	//
	// private static void buscaUsuarioId(EntityManager em, long id) {
	// Usuario u = em.find(Usuario.class, id);
	//
	// System.out.println("Id : " + u.getId());
	// System.out.println("Nome : " + u.getNome());
	// System.out.println("Email : " + u.getEmail());
	// System.out.println("Senha : " + u.getSenha());
	//
	// }
	//
	//
	// private static void buscaUsuarioIdOutroJeito(EntityManager em, long id) {
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
