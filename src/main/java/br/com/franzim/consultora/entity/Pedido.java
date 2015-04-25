package br.com.franzim.consultora.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@NamedQueries({
		@NamedQuery(name = "Pedido.listarTodos", query = "select p from Pedido p"),
		@NamedQuery(name = "Pedido.buscaMarcaId", query = "select p from Pedido p where p.id = :id") })
@Entity
@Table(name = "tb_pedido")
@Data
@EqualsAndHashCode(of = "id")
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	private Double valor;

	private String observacoes;

	private Integer pontuacaoTotal;

	private Date dtPedido;

	private Date dtEntrega;

	@OneToMany
	private List<Produto> produtos;

	public Pedido() {
	}

	public void adicionaProduto(Produto produto) {
		if (produto != null) {
			produtos.add(produto);
		}
	}

}
