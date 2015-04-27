package br.com.franzim.consultora.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.swing.JOptionPane;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import br.com.franzim.consultora.dao.PedidoDAO;
import br.com.franzim.consultora.entity.Cliente;
import br.com.franzim.consultora.entity.Pedido;

@ManagedBean
@Data
public class PedidoMB {

	private Cliente cliente;
	private PedidoDAO dao = new PedidoDAO();
	private Pedido novoPedido = new Pedido();
	

	@Setter(value = AccessLevel.NONE)
	private List<Pedido> pedidos;

	@PostConstruct
	public void carregaPedidos() {
		pedidos = dao.getPedidos();
		System.out.println(cliente.getNome());
	}

	public void salvar() {
		dao.salvar(novoPedido);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Pedido salvo com sucesso!", null));
	}
	

}
