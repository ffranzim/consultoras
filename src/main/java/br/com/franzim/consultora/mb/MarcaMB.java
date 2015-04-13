package br.com.franzim.consultora.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import br.com.franzim.consultora.dao.MarcaDAO;
import br.com.franzim.consultora.entity.Marca;

@ManagedBean
@Data
public class MarcaMB {

	MarcaDAO dao = new MarcaDAO();
	private Marca novaMarca = new Marca();

	@Setter(value = AccessLevel.NONE)
	private List<Marca> marcas;

	@PostConstruct
	public void carregaMarcas() {
		marcas = dao.getMarcas();
	}

	public void salvar() {
		dao.salvar(novaMarca);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Marca salva com sucesso!", null));
	}
}
