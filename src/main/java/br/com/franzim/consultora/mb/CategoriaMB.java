package br.com.franzim.consultora.mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import br.com.franzim.consultora.dao.CategoriaDAO;
import br.com.franzim.consultora.entity.Categoria;

@Data
@ManagedBean
public class CategoriaMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	CategoriaDAO dao = new CategoriaDAO();
		
	@Setter(value = AccessLevel.NONE)
	private List<Categoria> categorias;
	private Categoria novaCategoria = new Categoria();
	

	@PostConstruct
	public void carregaCategorias() {
		categorias = dao.getCategorias();
	}

	public void salvar() {
		dao.salvar(novaCategoria);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Categoria salva com sucesso!", null));
	}
	
	public void excluir() {
		dao.excluir(novaCategoria);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Categoria excluida com sucesso!", null));
	}
}
