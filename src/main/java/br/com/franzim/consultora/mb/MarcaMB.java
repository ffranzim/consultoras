package br.com.franzim.consultora.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import br.com.franzim.consultora.dao.MarcaDAO;
import br.com.franzim.consultora.entity.Marca;

@ManagedBean
@Data
public class MarcaMB {

	MarcaDAO dao = new MarcaDAO();

	@Setter(value = AccessLevel.NONE)
	private List<Marca> marcas;
	private Marca novaMarca = new Marca();

	@PostConstruct
	public void carregaMarcas() {
		marcas = dao.getMarcas();
	}
}
