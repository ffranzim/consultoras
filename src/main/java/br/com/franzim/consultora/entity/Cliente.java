package br.com.franzim.consultora.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NamedQueries({
		@NamedQuery(name = "Cliente.listarTodos", query = "select cl from Cliente cl"),
		@NamedQuery(name = "Cliente.buscaClienteId", query = "select cl from Cliente cl where cl.id = :id") })
@Entity
@Table(name = "tb_cliente")
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	private String nome;

	private String email;
	
	private String celular;

	private String endereco;

	private Date dtEntrada;

	private Date dtNascimento;
}
