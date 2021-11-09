package cadastrousuario.filtro;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cadastrousuario.controle.LoginControle;


public class LoginFilter implements Filter {

	@Inject
	private LoginControle loginControle;

	@Override
	public void destroy() {
		Filter.super.destroy();
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) servletRequest;
		HttpServletResponse res = (HttpServletResponse) servletResponse;

		String url = req.getRequestURI().toString();


		if (loginControle.getLoginBean().getLogin().getUsuario() == null && (url.contains("paginas"))) {
			res.sendRedirect(req.getServletContext().getContextPath() + "/login.xhtml");
		} else {
			filterChain.doFilter(servletRequest, servletResponse);
		}

	}

}
