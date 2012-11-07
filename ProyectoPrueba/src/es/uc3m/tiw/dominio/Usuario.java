package es.uc3m.tiw.dominio;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.AUTO;
import javax.persistence.Column;
import javax.persistence.Basic;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;
import javax.persistence.Table;

/**
 * 
 * Modelo de dominio para la aplicación
 * 
 * @author david palomar
 * 
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	@Column(length = 45, nullable = false, unique = true)
	@Basic
	private String nombre;
	@Column(length = 8, nullable = false)
	private String password;
	@Id
	@GeneratedValue(strategy = AUTO)
	private Long id;

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

	public Long getId() {
		return id;
	}

	public void setId(Long i) {
		this.id = i;
	}

}
