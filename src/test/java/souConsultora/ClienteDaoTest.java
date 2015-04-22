package souConsultora;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.persistence.EntityManager;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.franzim.consultora.entity.Cliente;
import br.com.franzim.consultora.persistence.JpaUtil;


public class ClienteDaoTest {
	
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
			stmt.execute("create table cliente(id int, nome char(50))");
			stmt.execute("insert into cliente values(1, 'cliente1')");
			stmt.execute("insert into cliente values(2, 'cliente2')");
			stmt.execute("insert into cliente values(3, 'cliente3')");
			stmt.execute("insert into cliente values(4, 'cliente4')");
			stmt.execute("insert into cliente values(5, 'cliente5')");	
			stmt.execute("insert into cliente values(6, 'cliente6')");	
			stmt.execute("insert into cliente values(7, 'cliente7')");			
			
			ResultSet rst = stmt.executeQuery("select count(id) from cliente ");
			rst.next();
			rowCount = rst.getInt(1);
			
		} finally {
			stmt.close();
			con.close();
		}
	}
	
	@Test
	public void findById() throws Throwable{
		EntityManager em = JpaUtil.getEntityManager();
		Long pk = (long) 1; 
		Cliente cliente = em.find(Cliente.class, pk);
		Assert.assertNotNull(cliente);
		System.out.println("Nome: " + cliente.getNome());
		System.out.println("Endereco: " + cliente.getEndereco());
		System.out.println("Email: " + cliente.getEmail());
		System.out.println("Celular: " + cliente.getCelular());
		System.out.println("dtEntrada: " + cliente.getDtEntrada());
		System.out.println("dtNascimento: " + cliente.getDtNascimento());
		}
	
	/*@Test
	public void testExcluir() throws Throwable{
		
		System.out.println(rowCount);
		
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Long pk = (long) 4; 
		Cliente  rslt = em.find(Cliente.class, pk);
		em.remove(rslt);
		tx.commit();
	}
*/	
	/*@Test
	public void salvar() throws Throwable{
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		Cliente cliente = new Cliente();
		tx.begin();
		em.persist(cliente);
		tx.commit();		
	}*/
	
	/*@Test
	public void BuscaTodos(){
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		Query query = em.createNamedQuery("Cliente.listarTodos");
		List<Cliente> list = query.getResultList();
		
		Assert.assertTrue(list!= null);
		
		for (Cliente cliente : list) {
		System.out.println("Nome: " + cliente.getNome());
		System.out.println("Endereco: " + cliente.getEndereco());
		System.out.println("Email: " + cliente.getEmail());
		System.out.println("Celular: " + cliente.getCelular());
		System.out.println("dtEntrada: " + cliente.getDtEntrada());
		System.out.println("dtNascimento: " + cliente.getDtNascimento());
		}
	}*/
}
