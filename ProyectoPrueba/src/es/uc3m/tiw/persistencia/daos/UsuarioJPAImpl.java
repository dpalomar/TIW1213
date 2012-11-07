package es.uc3m.tiw.persistencia.daos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.dominio.Usuario;

public class UsuarioJPAImpl implements UsuarioDAO {
	
	private final EntityManager em;
	private final UserTransaction ut;



	public UsuarioJPAImpl(EntityManager em, UserTransaction ut) {
			this.em = em;
			this.ut = ut;
	}

	@Override
	public Usuario actualizarUsuario(Usuario usuario) throws Exception {
		ut.begin();
		em.merge(usuario);
		ut.commit();
		return usuario;
		
	}

	@Override
	public void borrarUsuario(Usuario usuario) throws Exception{
		ut.begin();
		em.remove(em.merge(usuario));
		ut.commit();

	}

	@Override
	public Usuario crearUsuario(Usuario nuevoUsuario) throws Exception {
		ut.begin();
		em.persist(nuevoUsuario);
		ut.commit();
		return nuevoUsuario;
	}
	/**
	 * Este método asume que el nombre no puede repetirse
	 */
	@Override
	public Usuario recuperarUnUsuarioPorNombre(String nombre)
			throws SQLException {
		return em.createQuery("select u from Usuario u where u.nombre="+nombre, Usuario.class).getSingleResult();
		
	}

	@Override
	public Usuario recuperarUnUsuarioPorClave(long pk) throws Exception {
		
		return em.find(Usuario.class, pk);
	}

	@Override
	public Collection<Usuario> listarUsuarios() throws Exception {

		return em.createQuery("select u from Usuario u").getResultList();
	}
	


}
