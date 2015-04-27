package br.com.franzim.consultora.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@NamedQueries({
		@NamedQuery(name = "Venda.listarTodos", query = "select v from Venda v"),
		@NamedQuery(name = "Venda.buscaMarcaId", query = "select v from Venda v where v.id = :id") })
@Entity
@Table(name = "tb_venda")
@Data
@EqualsAndHashCode(of = "id")
public class Venda implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	private Date dtVenda;

	private String formaPgto;

	private Double valor;

	@OneToOne(fetch=FetchType.LAZY)
	private Pedido pedido;
	
	public Venda() {
	}

	public Venda(Pedido pedido) {
		this.valor = pedido.getValorTotal();
		this.dtVenda = new Date();
	}
	 
	
	// a venda precisa ser salva p\ alimentar estatisticas.
	//uma venda é um carrinho/pedido confirmado.
}
