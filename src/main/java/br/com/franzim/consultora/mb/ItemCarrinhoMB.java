package br.com.franzim.consultora.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import lombok.Data;
import br.com.franzim.consultora.dao.ItemCarrinhoDAO;
import br.com.franzim.consultora.entity.ItemCarrinho;

@ManagedBean
@Data
public class ItemCarrinhoMB {

	private ItemCarrinhoDAO dao = new ItemCarrinhoDAO();
	private ItemCarrinho itemCarrinho = new ItemCarrinho();

	private List<ItemCarrinho> itens;

	@PostConstruct
<<<<<<< HEAD
	public void carregaItemCarrinho() {
=======
	public void carregaMarcas() {
>>>>>>> origin/master
		itens = dao.getItemCarrinho();
	}

	public void salvar() {
		dao.salvar(itemCarrinho);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Item salvo com sucesso!", null));
	}
}
