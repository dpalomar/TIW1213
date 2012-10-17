package es.uc3m.tiw.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.uc3m.tiw.dominio.Usuario;

/**
 * @author david palomar
 * Servlet implementation class FormaularioServlet
 */
public class FormularioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
// Del primer ejemplo c�mo devolver datos de la vista desde el servlet
		//		PrintWriter out = response.getWriter();
//		out.println("<html>");
//		out.println("<body>");
//		out.println("<h1>Formulario</h1>");
//		out.println("<form action='formulario' method='post'>");
//		out.println("<input type='text' name='nombre'>");
//		out.println("<br>");
//		out.println("<input type='password' name='clave'> ");
//		out.println("<input type='submit' value='Enviar'>");
//		out.println("</form>");
//		out.println("</body>");
//		out.println("</html>");
//		out.close();
		
	//invalida la sesión si se hace un logout y devuelve a la página de login.
		if (request.getParameter("sesion").equals("logout")) {
			request.getSession().invalidate();
			
		}
		this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Primer ejemplo, respuesta directa del servlet
//		String nombre = request.getParameter("nombre");
//		String password = request.getParameter("clave");
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.println("<html>");
//		out.println("<body>");
//		out.println("<p> Estos son tus datos: "+nombre+" y clave: "+password+"</p>" );
//		out.println("</body>");
//		out.println("</html>");
//		out.close();
	
// Segundo ejemplo reenviamos la informaci�n al JSP con errores de login
		//o a una página de respuesta que muestra una colección de usuarios
//TODO hacer más reglas de validación, tamaño mínimo de la clave y del usuario, caracteres no válidos, etc.
		Map<String, String>errores;
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("clave");
		
		if (nombre.equals("")|| password.equals("")||(!nombre.equals("root")&& !password.equals("admin"))) {
			errores = new HashMap<String, String>();
				errores.put("nombre", nombre);
				errores.put("clave", password);
			
			request.setAttribute("errores", errores);
			this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
			
				
		} else  {
			
			// recuperar una lista y devolverla
			// simulación de la creación de un modelo de datos y devolverlo en el request.
			List<Usuario> listaUsuarios = new ArrayList<Usuario>();
			Usuario usu1 = new Usuario();
			usu1.setNombre("Juan");
			usu1.setPassword("11111");
			Usuario usu2 = new Usuario();
			usu2.setNombre("Eva");
			usu2.setPassword("22222");
			Usuario usu3 = new Usuario();
			usu3.setNombre(nombre);
			usu3.setPassword(password);
			
			listaUsuarios.add(usu1);
			listaUsuarios.add(usu2);
			listaUsuarios.add(usu3);
			
			request.setAttribute("atributo", "valor de atributo");
			request.setAttribute("listas", listaUsuarios);
			//añadido ejemplo de sesiones
			HttpSession sesion = request.getSession();
			sesion.setAttribute("autenticado", true);
			sesion.setAttribute("nombre", nombre);
			this.getServletContext().getRequestDispatcher("/respuesta.jsp").forward(request, response);
			
		}
		
		
	}

}
