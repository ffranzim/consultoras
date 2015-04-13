package br.com.franzim.consultora.mb;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import lombok.Data;
import br.com.franzim.consultora.dao.UsuarioDAO;
import br.com.franzim.consultora.entity.Usuario;

@Data
@ManagedBean
public class UsuarioMB {

	UsuarioDAO dao = new UsuarioDAO();

	Usuario usuario = new Usuario();

	public void salvar() {
		dao.salvar(usuario);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Usuario salvo com sucesso!", null));
	}
}
