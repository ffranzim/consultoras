package souConsultora;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.franzim.consultora.entity.Categoria;
import br.com.franzim.consultora.persistence.JpaUtil;


public class CategoriaDaoTest {
	
	int rowCount = -1;
	
	@Before
	public void setUp() throws Exception {
		Connection con=null;
		Statement stmt=null;
		try {
			File dir = new File("/temp/testedb");
			FileUtils.forceDelete(dir);
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con = DriverManager.getConnection("jdbc:derby:" + dir.getAbsolutePath() + ";create=true");
			stmt = con.createStatement();
			stmt.execute("create table categoria(id int, nome char(50))");
			stmt.execute("insert into categoria values(1, 'categoria1')");
			stmt.execute("insert into categoria values(2, 'categoria2')");
			stmt.execute("insert into categoria values(3, 'categoria3')");
			stmt.execute("insert into categoria values(4, 'categoria4')");
			stmt.execute("insert into categoria values(5, 'categoria5')");	
			stmt.execute("insert into categoria values(6, 'categoria6')");	
			stmt.execute("insert into categoria values(7, 'categoria7')");
			
			
			ResultSet rst = stmt.executeQuery("select count(id) from categoria ");
			rst.next();
			rowCount = rst.getInt(1);
			
		} finally {
			stmt.close();
			con.close();
		}
	}
	
	/*@Test
	public void findById() throws Throwable{
		EntityManager em = JpaUtil.getEntityManager();
		Long pk = (long) 11; 
		Categoria categoria = em.find(Categoria.class, pk);
		Assert.assertNotNull(categoria);
		System.out.println(categoria.getNome() +"passei aqui");
		}*/
	
	/*@Test
	public void testExcluir() throws Throwable{
		
		System.out.println(rowCount);
		
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Long pk = (long) 4; 
		Categoria  rslt = em.find(Categoria.class, pk);
		em.remove(rslt);
		tx.commit();
	}*/
	/*@Test
	public void salvar() throws Throwable{
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		Categoria categoria = new Categoria("Metodo salva JUnit");
		tx.begin();
		em.persist(categoria);
		tx.commit();		
	}*/
	
	@Test
	public void BuscaTodos(){
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		Query query = em.createNamedQuery("Categoria.listarTodos");
		List<Categoria> list = query.getResultList();
		
		Assert.assertTrue(list!= null);
		
		for (Categoria categoria : list) {
			System.out.println(categoria.getNome());
			System.out.println(categoria.getId());
		}
	}
}
