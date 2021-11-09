package cadastrousuario.model;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nome;
	private String email;
	private String senha;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "telefone_usuario", joinColumns = {
			@JoinColumn(name = "usuario_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "telefone_id", referencedColumnName = "id") })
	private List<Telefone> telefones = new ArrayList<Telefone>();

	public Usuario() {
		super();
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", telefones="
				+ telefones + "]";
	}

}
