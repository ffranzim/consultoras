package br.com.franzim.consultora.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import lombok.Data;
import br.com.franzim.consultora.dao.ClienteDAO;
import br.com.franzim.consultora.entity.Cliente;

@Data
@ManagedBean
public class ClienteMB {

	private ClienteDAO dao = new ClienteDAO();

	private Cliente cliente = new Cliente();
	
	private List<Cliente> clientes;
	
	private Long id;

	public void salvar() {
		dao.salvar(cliente);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Cliente salvo com sucesso!", null));
	}
	
	@PostConstruct
	public void carregarClientes(){
		clientes = dao.getClientes();
	}
}
