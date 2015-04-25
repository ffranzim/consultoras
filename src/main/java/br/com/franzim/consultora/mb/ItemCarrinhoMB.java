package br.com.franzim.consultora.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import lombok.Data;
import br.com.franzim.consultora.dao.ItemCarrinhoDAO;
import br.com.franzim.consultora.entity.ItemCarrinho;

@Data
@ManagedBean
public class ItemCarrinhoMB {

	private ItemCarrinhoDAO dao = new ItemCarrinhoDAO();

	private ItemCarrinho item = new ItemCarrinho();

	private List<ItemCarrinho> itens;

	@PostConstruct
	public void buscaTodos() {
		itens = dao.getItens();
	}

	public void excluir() {
		if (item != null) {
			itens.remove(item);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Item excluido com sucesso!", null));
			buscaTodos();
		}
	}
	
	public void adicionar(){
		if(item != null){
			itens.add(item);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Item adicionado com sucesso!", null));
			buscaTodos();
		}
	}
}
