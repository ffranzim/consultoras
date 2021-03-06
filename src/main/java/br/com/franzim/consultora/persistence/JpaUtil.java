package br.com.franzim.consultora.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Session;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class JpaUtil {

	private static ThreadLocal<EntityManager> manager = new ThreadLocal<EntityManager>();

	private static EntityManagerFactory factory;

	public static boolean isEntityManagerOpen() {
		return JpaUtil.manager.get() != null && JpaUtil.manager.get().isOpen();
	}

	public static EntityManager getEntityManager() {
		if (JpaUtil.factory == null) {
			JpaUtil.factory = Persistence.createEntityManagerFactory("tccPU");
		}
		EntityManager em = JpaUtil.manager.get();
		if (em == null || !em.isOpen()) {
			em = JpaUtil.factory.createEntityManager();
			JpaUtil.manager.set(em);
		}
		return em;
	}
	
	public static void evictCache(EntityManager em, String region){
		((Session)em.getDelegate()).getSessionFactory().getCache().evictQueryRegion(region);
	}

	public static void closeEntityManager() {
		EntityManager em = JpaUtil.manager.get();
		if (em != null) {
			EntityTransaction tx = em.getTransaction();
			if (tx.isActive()) {
				tx.commit();
			}
			em.close();
			JpaUtil.manager.set(null);
		}
	}

	public static void closeEntityManagerFactory() {
		closeEntityManager();
		JpaUtil.factory.close();
	}
}
