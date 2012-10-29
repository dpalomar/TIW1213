package es.uc3m.tiw.dominio;

import java.io.Serializable;

/**
 * 
 * Modelo de dominio para la aplicación
 * 
 * @author david palomar
 * 
 */
public class Usuario implements Serializable {

	private String nombre;
	private String password;
	private int id;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
