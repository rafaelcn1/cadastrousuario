package cadastrousuario.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import cadastrousuario.model.Usuario;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class UsuarioDAO {

	@PersistenceContext(name = "projeto")
	private EntityManager manager;

	public UsuarioDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void incluir(Usuario usuario) {
		if (usuario.getId() == null) {
			getManager().persist(usuario);
		} else {
			getManager().merge(usuario);
		}

		getManager().flush();
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> listarTodos() {
		String sql = "from Usuario";

		try {
			return getManager().createQuery(sql).getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	public Usuario buscarPorId(int id) {
		Usuario usuario = getManager().find(Usuario.class, id);
		return usuario;

	}

	public void editar(Usuario usuario) {
		getManager().merge(usuario);
		getManager().flush();

	}

	public void remover(Usuario usuario) {
		Usuario find = getManager().find(Usuario.class, usuario.getId());
		getManager().remove(find);
		getManager().flush();
	}

}
