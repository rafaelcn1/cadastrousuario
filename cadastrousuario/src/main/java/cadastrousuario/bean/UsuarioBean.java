package cadastrousuario.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import cadastrousuario.dao.UsuarioDAO;
import cadastrousuario.model.Telefone;
import cadastrousuario.model.Usuario;

@Stateless
@Named(value = "usuarioBean")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class UsuarioBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	public UsuarioDAO usuarioDAO;

	private Usuario usuario = new Usuario();
	private Telefone telefone = new Telefone();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public void incluir() throws IOException {
		setUsuario(getUsuario());
		usuarioDAO.incluir(getUsuario());
		setUsuario(new Usuario());
		FacesContext.getCurrentInstance().getExternalContext().redirect("usuarios.xhtml");
	}

	public void cadastrarContato() throws IOException {
		getUsuario().getTelefones().add(getTelefone());
		setTelefone(new Telefone());
	}

	public void removerContato(Telefone telefone) {
		List<Telefone> telefones = getUsuario().getTelefones();
		telefones.remove(telefone);
	}

	public List<Telefone> getTelefones() {
		return getUsuario().getTelefones();
	}

	public List<Usuario> listarTodos() {
		return usuarioDAO.listarTodos();
	}

	public void buscar(Usuario usuario) throws Exception {
		setUsuario(usuarioDAO.buscarPorId(usuario.getId()));
		FacesContext.getCurrentInstance().getExternalContext().redirect("usuario.xhtml");

	}

	public void editar() throws Exception {
		System.out.println(getUsuario().toString());
		usuarioDAO.editar(getUsuario());
		setUsuario(new Usuario());
		FacesContext.getCurrentInstance().getExternalContext().redirect("usuarios.xhtml");
	}

	public void excluir(Usuario usuario) throws Exception {
		setUsuario(usuario);
		usuarioDAO.remover(getUsuario());
		setUsuario(new Usuario());
	}

	public String irParaPaginaAutor(String nomeDaPagina) {
		setUsuario(new Usuario());
		String url = "/paginas/" + nomeDaPagina + ".xhtml?faces-redirect=true";
		System.out.println(url);
		return url;
	}


}
