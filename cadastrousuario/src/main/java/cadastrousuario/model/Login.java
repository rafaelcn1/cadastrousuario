package cadastrousuario.model;

public class Login {
	private String usuario;
	private String senha;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Login [usuario=" + usuario + ", senha=" + senha + "]";
	}

}
