package br.com.franzim.consultora.entity;

import java.io.Serializable;
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
		@NamedQuery(name = "Estoque.listarTodos", query = "select est from Estoque est"),
		@NamedQuery(name = "Estoque.buscaMarcaId", query = "select est from Estoque est where est.id = :id") })
@Entity
@Table(name = "tb_estoque")
@Data
@EqualsAndHashCode(of = "id")
public class Estoque implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	private int quantidade;
	
	private double valor;

	@OneToMany
	private List<Produto> produtos;

	public Estoque() {
	}
}
