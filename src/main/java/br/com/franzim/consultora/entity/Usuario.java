package br.com.franzim.consultora.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NamedQueries({
		@NamedQuery(name = "Usuario.listarTodos", query = "select u from Usuario u"),
		@NamedQuery(name = "Usuario.buscaUsuarioId", query = "select u from Usuario u where u.id = :id") 
})
@Entity
@Table(name = "tb_usuario")
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	private String email;
	private String celular;
	private String username;
	@Setter(value=AccessLevel.NONE)
	private String senha;

	public Usuario(String nome, String email, String username, String senha) {
		this.nome = nome;
		this.email = email;
		this.username = username;
		this.senha = String.valueOf(senha.hashCode());
	}

	public void setSenha(String senha) {
		this.senha = String.valueOf(senha.hashCode());
	}
}
