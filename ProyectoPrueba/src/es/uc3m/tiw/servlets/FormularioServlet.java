package es.uc3m.tiw.servlets;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
 * @author david palomar
 * Servlet implementation class FormaularioServlet
 */
public class FormularioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	    private UsuarioDAO dao;   
	    private ServletConfig config;
	    @PersistenceContext(unitName="prueba_UP")
	    private EntityManager em;
	    @Resource
	    private UserTransaction ut;
		
		@Override
		public void init(ServletConfig config) throws ServletException {
			this.config = config;
			dao = new UsuarioJPAImpl(em,ut);
			

		}      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormularioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	//invalida la sesión si se hace un logout y devuelve a la página de login.
		if (request.getParameter("sesion").equals("logout")) {
			request.getSession().invalidate();
			
		}
		config.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Map<String, String>errores;
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("clave");
		
		if (nombre.equals("")|| password.equals("")||(!nombre.equals("root")&& !password.equals("admin"))) {
			errores = new HashMap<String, String>();
				errores.put("nombre", nombre);
				errores.put("clave", password);
			
			request.setAttribute("errores", errores);
			config.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
			
				
		} else  {
			
	
			//Reemplazamos la gestión en memoria por acceso a bbdd con el UsuarioDao
						Collection<Usuario> listaUsuarios = null;
						try {
							listaUsuarios = dao.listarUsuarios();
						} catch (Throwable e) {
							try {
								ut.rollback();
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							e.printStackTrace();
						}
			
			
			request.setAttribute("listas", listaUsuarios);
			//añadido ejemplo de sesiones
			HttpSession sesion = request.getSession();
			sesion.setAttribute("autenticado", true);
			sesion.setAttribute("nombre", nombre);
			config.getServletContext().getRequestDispatcher("/respuesta.jsp").forward(request, response);
			
		}
		
		
	}

}
