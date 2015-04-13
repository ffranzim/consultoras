package br.com.franzim.consultora.mb;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import lombok.Data;
import br.com.franzim.consultora.dao.ClienteDAO;
import br.com.franzim.consultora.entity.Cliente;

@Data
@ManagedBean
public class ClienteMB {

	ClienteDAO dao = new ClienteDAO();

	Cliente cliente = new Cliente();

	public void salvar() {
		dao.salvar(cliente);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Cliente salvo com sucesso!", null));
	}

}
