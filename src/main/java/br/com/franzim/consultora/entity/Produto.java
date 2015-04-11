package br.com.franzim.consultora.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NamedQueries({
		@NamedQuery(name = "Produto.listarTodos", query = "select p from Produto p"),
		@NamedQuery(name = "Produto.buscaProdutoId", query = "select p from Produto p where p.id = :id") })
@Entity
@Table(name = "tb_produto")
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	private String nome;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_marca", foreignKey = @ForeignKey(name = "ck_marca_produto"))
	private Marca marca;

	private Date dtVencimento;

	private String descricao;

	private String codigo;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_categoria", foreignKey = @ForeignKey(name = "ck_categoria_produto"))
	private Categoria categoria;

	private double valor;

	private Integer qtdUnidade;

	public Produto(String nome, Date dtVencimento, String descricao,
			String codigo, double valor, Integer qtdUnidade, Marca marca,
			Categoria categoria) {
		this.nome = nome;
		this.dtVencimento = dtVencimento;
		this.descricao = descricao;
		this.codigo = codigo;
		this.valor = valor;
		this.qtdUnidade = qtdUnidade;
		this.marca = marca;
		this.categoria = categoria;
	}

}
