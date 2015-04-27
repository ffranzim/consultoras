package br.com.franzim.consultora.entity;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.SessionScoped;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@NamedQueries({
		@NamedQuery(name = "Pedido.listarTodos", query = "select pd from Pedido pd"),
		@NamedQuery(name = "Pedido.buscaMarcaId", query = "select pd from Pedido pd where pd.id = :id") })
@Entity
@Table(name = "tb_pedido")
@Data
@EqualsAndHashCode(of = "id")
@SessionScoped
public class Pedido extends CarrinhoCompra implements Serializable {

	private static final long serialVersionUID = 1L;

	// um pedido é um carrinho de compra confirmado, e uma venda é um pedido
	// confirmado.

	@Id
	@GeneratedValue
	private Long id;

	private String observacoes;

	private Date dtPedido;

	private Date dtEntrega;

	/*@OneToOne(cascade=CascadeType.ALL)*/
	private Cliente cliente;

	public Pedido() {
	}

	public Pedido(Cliente cliente) {
		this.cliente = cliente;
		this.dtPedido = new Date();

		this.setConfirmação(true);
	}

}
