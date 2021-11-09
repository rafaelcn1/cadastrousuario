package cadastrousuario.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

@Entity
public class Telefone implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private int ddd;
	private String numero;
	private String tipo;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "telefone_usuario", joinColumns = {
			@JoinColumn(name = "telefone_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "usuario_id", referencedColumnName = "id") })
	private Usuario usuario;

	public Telefone() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Telefone: ddd=" + ddd + ", numero=" + numero + ", tipo=" + tipo + "]";
	}

}