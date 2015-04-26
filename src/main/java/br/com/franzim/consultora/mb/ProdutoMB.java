package br.com.franzim.consultora.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import lombok.Data;
import br.com.franzim.consultora.dao.ProdutoDAO;
import br.com.franzim.consultora.entity.Categoria;
import br.com.franzim.consultora.entity.Marca;
import br.com.franzim.consultora.entity.Produto;

@Data
@ManagedBean
public class ProdutoMB {
	
	
	private ProdutoDAO dao = new ProdutoDAO();
	
	private Produto produto = new Produto();
	private Marca marca = new Marca();
	private Long id;
	
	List<Produto> produtos;	
	
	List<Categoria> categorias;

	@PostConstruct
	public void carregaProdutos() {
		produtos = dao.getProdutos(); 
	}

	public void salvar() {
		dao.salvar(produto);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Produto salvo com sucesso!", null));
	}
	
	public void excluir() {
		dao.excluir(produto);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Produto excluido com sucesso!", null));
	}

	public void findById() throws Throwable{
		produto = dao.findById(id);
	}
}
