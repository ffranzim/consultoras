package br.com.franzim.consultora.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import lombok.Data;
import br.com.franzim.consultora.dao.EstoqueDAO;
import br.com.franzim.consultora.entity.Estoque;

@Data
@ManagedBean
public class EstoqueMB {
	
	
	private EstoqueDAO dao = new EstoqueDAO();
	
	private Estoque estoque = new Estoque();

	private List<Estoque> estoques;	
	
	private Long id;
	
	@PostConstruct
	public void carregaEstoques() {
		estoques = dao.getEstoques(); 
	}

	public void salvar() {
		dao.salvar(estoque);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Produto salvo com sucesso!", null));
	}
	
	public void excluir() {
		dao.excluir(estoque);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Produto excluido com sucesso!", null));
	}

	public void findById() throws Throwable{
		estoque = dao.findById(id);
	}
}
