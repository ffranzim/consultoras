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

import br.com.franzim.consultora.entity.Usuario;
import br.com.franzim.consultora.persistence.JpaUtil;


public class UsuarioDaoTest {
	
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
			stmt.execute("create table usuario(id int, nome char(50))");
			stmt.execute("insert into usuario values(1, 'usuario1')");
			stmt.execute("insert into usuario values(2, 'usuario2')");
			stmt.execute("insert into usuario values(3, 'usuario3')");
			stmt.execute("insert into usuario values(4, 'usuario4')");
			stmt.execute("insert into usuario values(5, 'usuario5')");	
			stmt.execute("insert into usuario values(6, 'usuario6')");	
			stmt.execute("insert into usuario values(7, 'usuario7')");
			
			
			ResultSet rst = stmt.executeQuery("select count(id) from usuario ");
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
		Long pk = (long) 8; 
		Usuario usuario = em.find(Usuario.class, pk);
		Assert.assertNotNull(usuario);
		System.out.println(usuario.getNome() +" passei aqui");
		}
	
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
	/*@Test
	public void salvar() throws Throwable{
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		Usuario usuario = new Usuario("nome", "email" , "usuario", "senha");
		tx.begin();
		em.persist(usuario);
		tx.commit();		
	}*/
	
	/*@Test
	public void BuscaTodos(){
		EntityManager em = JpaUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		Query query = em.createNamedQuery("Usuario.listarTodos");
		List<Usuario> list = query.getResultList();
		
		Assert.assertTrue(list!= null);
		
		for (Usuario usuario : list) {
			System.out.println(usuario.getNome());
			System.out.println(usuario.getId());
		}*/
	
}
