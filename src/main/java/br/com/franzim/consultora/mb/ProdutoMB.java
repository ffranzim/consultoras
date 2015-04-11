package br.com.franzim.consultora.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import br.com.franzim.consultora.dao.ProdutoDAO;
import br.com.franzim.consultora.entity.Categoria;
import br.com.franzim.consultora.entity.Marca;
import br.com.franzim.consultora.entity.Produto;

@Data
@ManagedBean
public class ProdutoMB {
	
	
	ProdutoDAO dao = new ProdutoDAO();
	
	Produto produto = new Produto();
	Marca marca = new Marca();
	
	@Setter(value = AccessLevel.NONE)
	List<Produto> produtos;	
	
	@Setter(value = AccessLevel.NONE)
	List<Categoria> categorias;

	@PostConstruct
	public void carregaProdutos() {
		produtos = dao.getProdutos(); 
	}

	public void salvar() {
		dao.salvar(produto);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Produto salvo com sucesso!", null));
	}

}
