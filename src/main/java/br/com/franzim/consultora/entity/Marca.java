package br.com.franzim.consultora.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NamedQueries({
	@NamedQuery(name = "Marca.listarTodos", query = "select m from Marca m"),
	@NamedQuery(name = "Marca.buscaMarcaId", query = "select m from Marca m where m.id = :id") 
})
@Entity
@Table(name = "tb_marca")
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Marca implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;

	@OneToMany(mappedBy="marca", cascade=CascadeType.ALL)
	@Setter(value=AccessLevel.NONE)
	private List<Produto> produtos;

	public Marca(String nome) {
		this.nome = nome;
	}
	
	public void setProdutos(List<Produto> produtos) {
		this.produtos = new ArrayList<Produto>();
		for (Produto produto : produtos) {
			produto.setMarca(this);
			this.produtos.add(produto);
		}
	}
	
	
}
