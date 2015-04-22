package souConsultora;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

import br.com.franzim.consultora.entity.Marca;
import br.com.franzim.consultora.persistence.JpaUtil;


public class MarcaDaoTest {
	
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
			stmt.execute("create table marca(id int, nome char(50))");
			stmt.execute("insert into marca values(1, 'marca1')");
			stmt.execute("insert into marca values(2, 'marca2')");
			stmt.execute("insert into marca values(3, 'marca3')");
			stmt.execute("insert into marca values(4, 'marca4')");
			stmt.execute("insert into marca values(5, 'marca5')");	
			stmt.execute("insert into marca values(6, 'marca6')");	
			stmt.execute("insert into marca values(7, 'marca7')");			
			
			ResultSet rst = stmt.executeQuery("select count(id) from marca ");
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
		Marca marca = em.find(Marca.class, pk);
		Assert.assertNotNull(marca);
		System.out.println("Nome: " + marca.getNome());
		}*/
	
	@Test
	public void testExcluir() throws Throwable{
		
		System.out.println(rowCount);
		
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Long pk = (long) 3; 
		Marca  rslt = em.find(Marca.class, pk);
		em.remove(rslt);
		tx.commit();
	}

	/*@Test
	public void salvar() throws Throwable{
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		Marca marca = new Marca();
		tx.begin();
		em.persist(marca);
		tx.commit();		
	}*/
	
	/*@Test
	public void BuscaTodos() throws Throwable{
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		Query query = em.createNamedQuery("Marca.listarTodos");
		List<Marca> list = query.getResultList();
		
		Assert.assertTrue(list!= null);
		
		for (Marca marca : list) {
		System.out.println("Nome: " + marca.getNome());
		}
	}*/
}
	
