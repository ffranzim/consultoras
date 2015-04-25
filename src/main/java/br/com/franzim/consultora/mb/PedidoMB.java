package br.com.franzim.consultora.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import br.com.franzim.consultora.dao.PedidoDAO;
import br.com.franzim.consultora.entity.Pedido;
import br.com.franzim.consultora.entity.Produto;

@ManagedBean
@Data
public class PedidoMB {

	PedidoDAO dao = new PedidoDAO();
	private Pedido novoPedido = new Pedido();

	@Setter(value = AccessLevel.NONE)
	private List<Pedido> pedidos;

	@PostConstruct
	public void carregaPedidos() {
		pedidos = dao.getPedidos();
	}

	public void salvar() {
		dao.salvar(novoPedido);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Pedido salvo com sucesso!", null));
	}

	public void getItens() {
		for (Pedido pedido : pedidos) {
			for (Produto produto : pedido.getProdutos()) {
				System.out.println(produto.getNome());       // teste tosco
			}
		}
	}
}
