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
import br.com.franzim.consultora.dao.ConsultoraDAO;
import br.com.franzim.consultora.entity.Consultora;

@Data
@ManagedBean
public class ConsultoraMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	ConsultoraDAO dao = new ConsultoraDAO();
	Long id;

	@Setter(value = AccessLevel.NONE)
	private List<Consultora> consultoras;
	private Consultora novaConsultora = new Consultora();
	

	@PostConstruct
	public void carregaCategorias() {
		consultoras = dao.getConsultoras();
	}

	public void salvar() {
		dao.salvar(novaConsultora);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Consultora salva com sucesso!", null));
	}
	
	public void excluir() {
		dao.excluir(novaConsultora);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Categoria excluida com sucesso!", null));
	}
}
