package es.uc3m.tiw.servlets.filtros;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author david palomar
 * Servlet Filter implementation class SessionFilter
 */
public class SessionFilter implements Filter {

    private FilterConfig filterConfig;
	private HttpSession session;
	private static final String SEPARADOR=" - ";

	/**
     * Default constructor. 
     */
    public SessionFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * Este filtro traza todas las peticiones y muestra una traza por consola incluyendo la fecha de la petición
	 * su nombre y comprueba si el usuario ha añadido o retirado su nombre de la sesión
	 *  
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		// place your code here
		session = ((HttpServletRequest) request).getSession();
		ServletContext contexto = filterConfig.getServletContext();
		
		StringBuilder sb = new StringBuilder();
		SimpleDateFormat sdf = new SimpleDateFormat("d MMM yyyy HH:mm:ss");
		
		sb.append(sdf.format(new Date()));
		sb.append(SEPARADOR);
		sb.append("doFilter llamado en "+filterConfig.getFilterName());
		sb.append(SEPARADOR);
		sb.append("SessionID:"+session.getId());
		sb.append(SEPARADOR);
		String nombre = (String) session.getAttribute("nombre");
		if (nombre == null) {
			session.setAttribute("nombre", "SIN NOMBRE");
			
		}
		sb.append(session.getAttribute("nombre"));
		
		contexto.log(sb.toString());
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
		this.filterConfig = fConfig;
	}

}
