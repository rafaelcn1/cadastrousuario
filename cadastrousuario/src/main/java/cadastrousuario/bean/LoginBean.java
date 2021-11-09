package cadastrousuario.bean;

import java.io.Serializable;

import javax.ejb.Stateful;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import cadastrousuario.model.Login;

@Stateful
public class LoginBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Login login = new Login();

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public String autenticar() {
		if ("admin".equals(getLogin().getUsuario()) && "admin".equals(getLogin().getSenha())) {
			return "paginas/cadastro?faces-redirect=true";
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login", "Inválido!"));
			return null;
		}
	}

	public String logoff() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		setLogin(new Login());
		return "/login.xhtml?faces-redirect=true";
	}

}