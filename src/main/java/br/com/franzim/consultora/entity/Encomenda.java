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
		@NamedQuery(name = "Encomenda.listarTodos", query = "select e from Encomenda e"),
		@NamedQuery(name = "Encomenda.buscaMarcaId", query = "select e from Encomenda e where e.id = :id") })
@Entity
@Table(name = "tb_encomenda")
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Encomenda implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	private String nome;

}
