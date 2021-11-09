package cadastrousuario.controle;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import javax.ejb.EJB;
import javax.ejb.StatefulTimeout;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import cadastrousuario.bean.LoginBean;

@Named(value = "controleLogin")
@SessionScoped
@StatefulTimeout(unit = TimeUnit.MINUTES, value = 10)
public class LoginControle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private LoginBean loginBean = new LoginBean();

	public LoginControle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

}
