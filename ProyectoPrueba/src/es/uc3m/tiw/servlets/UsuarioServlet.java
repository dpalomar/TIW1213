package es.uc3m.tiw.servlets;

import java.io.IOException;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.dominio.Usuario;
import es.uc3m.tiw.persistencia.daos.UsuarioDAO;
import es.uc3m.tiw.persistencia.daos.UsuarioJPAImpl;

/**
 * Servlet implementation class UsuarioServlet
 */
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig config;
	private UsuarioDAO dao;
	@Resource
	private UserTransaction ut;
	
	private static final String ALTA="ALTA",EDITAR="EDITAR",BORRAR="BORRAR";
	
    @PersistenceContext(unitName="prueba_UP")
	private EntityManager em;   
    

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		dao = new UsuarioJPAImpl(em,ut);
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");

			String pagina = null;
		
			if (accion.equals(ALTA)) {
				pagina = "/altausuario.jsp";
				
			}else if (accion.equals(EDITAR)) {
				Usuario usuario = recuperarDatosUsuario(request);
				request.setAttribute("usuario", usuario);
				pagina = "/editarusuario.jsp";
				
			}else if (accion.equals(BORRAR)) {
				Usuario usuario = recuperarDatosUsuario(request);
				pagina = "/login.jsp";
				borrarUsuario(usuario);
			}
			config.getServletContext().getRequestDispatcher(pagina).forward(request, response);
	}

	/**
	 * Obtiene los datos del usuario a editar o borrar
	 * @param request
	 * @return
	 */
	private Usuario recuperarDatosUsuario(HttpServletRequest request) {
		Usuario usuario = new Usuario();
		usuario.setId(Long.parseLong(request.getParameter("id")));
		usuario.setNombre(request.getParameter("nombre"));
		usuario.setPassword(request.getParameter("password"));
		return usuario;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		HttpSession sesion = request.getSession();
		String pagina = "/login.jsp";
		if ((sesion.getAttribute("autenticado").toString()).equalsIgnoreCase("true")) {
			
			pagina = "/formulario?nombre=root&clave=admin";
		
		if (accion.equalsIgnoreCase(ALTA)) {
			Usuario usuario = new Usuario();
			usuario.setNombre(request.getParameter("nombre"));
			usuario.setPassword(request.getParameter("password"));
			altaUsuario(usuario);
		}else if (accion.equalsIgnoreCase(EDITAR)) {
			Usuario usuario = recuperarDatosUsuario(request);
			modificarUsuario(usuario);
		 }
		}
		config.getServletContext().getRequestDispatcher(pagina).forward(request, response);
	}
	/**
	 * Modifica los datos del usuario con el UsuarioDao
	 * @param usuario
	 */
	private void modificarUsuario(Usuario usuario){
		try {
			dao.actualizarUsuario(usuario);
		} catch (Throwable e) {
			try {
				ut.rollback();
			} catch (Exception e1) {
				
				e1.printStackTrace();
			} 
			e.printStackTrace();
		}
	}
	/**
	 * Borra los datos de un usuario con el UsuarioDao
	 * @param usuario
	 */
	private void borrarUsuario(Usuario usuario){

			try {
				dao.borrarUsuario(usuario);
			} catch (Throwable e) {
				try {
					ut.rollback();
				} catch (Exception e1) {
					
					e1.printStackTrace();
				} 
				e.printStackTrace();
			}

		
	}
	/**
	 * Crea un usuario en la base de datos con el UsuarioDao
	 * @param usuario
	 */
	private void altaUsuario(Usuario usuario){
		try {
			dao.crearUsuario(usuario);
		} catch (Throwable e) {
			try {
				ut.rollback();
			} catch (Exception e1) {
				
				e1.printStackTrace();
			} 
			e.printStackTrace();
		}
	}
	
}