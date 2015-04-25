package br.com.franzim.consultora.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@NamedQueries({
		@NamedQuery(name = "ItemCarrinho.listarTodos", query = "select i from ItemCarrinho i"),
		@NamedQuery(name = "ItemCarrinho.buscaMarcaId", query = "select i from ItemCarrinho i where i.id = :id") })
@Entity
@Table(name = "tb_itemCarrinho")
@Data
@EqualsAndHashCode(of = "id")
public class ItemCarrinho implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	private int quantidade;

	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private Produto produto;

	public ItemCarrinho() {
	}

	public ItemCarrinho(Produto produto, int quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}

	public double getValorTotal() {
		return getQuantidade() * produto.getValor();
	}
}
