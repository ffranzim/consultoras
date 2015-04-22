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

import br.com.franzim.consultora.entity.Produto;
import br.com.franzim.consultora.persistence.JpaUtil;


public class ProdutoDaoTest {
	
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
			stmt.execute("create table produto(id int, nome char(50))");
			stmt.execute("insert into produto values(1, 'produto1')");
			stmt.execute("insert into produto values(2, 'produto2')");
			stmt.execute("insert into produto values(3, 'produto3')");
			stmt.execute("insert into produto values(4, 'produto4')");
			stmt.execute("insert into produto values(5, 'produto5')");	
			stmt.execute("insert into produto values(6, 'produto6')");	
			stmt.execute("insert into produto values(7, 'produto7')");			
			
			ResultSet rst = stmt.executeQuery("select count(id) from produto ");
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
		Long pk = (long) 2; 
		Produto produto = em.find(Produto.class, pk);
		Assert.assertNotNull(produto);
		System.out.println("Nome: " + produto.getNome());
		}*/
	
	/*@Test
	public void testExcluir() throws Throwable{
		
		System.out.println(rowCount);
		
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Long pk = (long) 3; 
		Produto  rslt = em.find(Produto.class, pk);
		em.remove(rslt);
		tx.commit();
	}*/

	/*@Test
	public void salvar() throws Throwable{
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		Produto produto = new Produto();
		tx.begin();
		em.persist(produto);
		tx.commit();		
	}*/
	
	@Test
	public void BuscaTodos() throws Throwable{
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		Query query = em.createNamedQuery("Produto.listarTodos");
		List<Produto> list = query.getResultList();
		
		Assert.assertTrue(list!= null);
		
		for (Produto produto : list) {
		System.out.println("Referencia: " + produto.getCodigo());
		System.out.println("Nome: " + produto.getNome());
		System.out.println("Nome: " + produto.getValor());
		System.out.println("Nome: " + produto.getQtdUnidade());
		System.out.println("Nome: " + produto.getDtVencimento());
		}
	}
}
	
