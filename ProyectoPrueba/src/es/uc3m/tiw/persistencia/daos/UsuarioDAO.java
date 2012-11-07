package es.uc3m.tiw.persistencia.daos;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.ResourceBundle;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import es.uc3m.tiw.dominio.Usuario;

public interface UsuarioDAO {

	public abstract Usuario actualizarUsuario(Usuario usuario) throws Throwable;

	public abstract void borrarUsuario(Usuario usuario) throws Throwable;

	public abstract Usuario crearUsuario(Usuario nuevoUsuario) throws Throwable;

	public abstract Usuario recuperarUnUsuarioPorNombre(String nombre) throws Throwable;

	public abstract Usuario recuperarUnUsuarioPorClave(long pk) throws Throwable;

	public abstract Collection<Usuario> listarUsuarios() throws Throwable;

}