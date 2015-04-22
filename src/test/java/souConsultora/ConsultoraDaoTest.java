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

import br.com.franzim.consultora.entity.Consultora;
import br.com.franzim.consultora.persistence.JpaUtil;


public class ConsultoraDaoTest {
	
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
			stmt.execute("create table consultora(id int, nome char(50))");
			stmt.execute("insert into consultora values(1, 'consultora1')");
			stmt.execute("insert into consultora values(2, 'consultora2')");
			stmt.execute("insert into consultora values(3, 'consultora3')");
			stmt.execute("insert into consultora values(4, 'consultora4')");
			stmt.execute("insert into consultora values(5, 'consultora5')");	
			stmt.execute("insert into consultora values(6, 'consultora6')");	
			stmt.execute("insert into consultora values(7, 'consultora7')");
			
			
			ResultSet rst = stmt.executeQuery("select count(id) from consultora ");
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
		Long pk = (long) 3; 
		Consultora consultora = em.find(Consultora.class, pk);
		Assert.assertNotNull(consultora);
		System.out.println(consultora.getNome() +" passei aqui");
		}*/
	
	/*@Test
	public void testExcluir() throws Throwable{
		
		System.out.println(rowCount);
		
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Long pk = (long) 7; 
		Usuario  rslt = em.find(Usuario.class, pk);
		em.remove(rslt);
		tx.commit();
	}*/
	
	@Test
	public void salvar() throws Throwable{
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		Consultora consultora = new Consultora();
		tx.begin();
		em.persist(consultora);
		tx.commit();		
	}
	
	/*@Test
	public void BuscaTodos(){
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		Query query = em.createNamedQuery("Consultora.listarTodos");
		List<Consultora> list = query.getResultList();
		
		Assert.assertTrue(list!= null);
		
		for (Consultora consultora : list) {
			System.out.println(consultora.getNome());
			System.out.println(consultora.getId());
		}
	}*/
}
