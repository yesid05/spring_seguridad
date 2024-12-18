package co.spring.seguridad.validar;

import java.io.Serializable;

public class ClienteValidar implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long id;
	
	private String nombreUsuario;
	
	private String nombre;
	
	private String contrasena;
	
	private String repetirContrasena;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getRepetirContrasena() {
		return repetirContrasena;
	}

	public void setRepetirContrasena(String repetirContrasena) {
		this.repetirContrasena = repetirContrasena;
	}

	public boolean compararContrasena() {
		return contrasena.equals(repetirContrasena);
	}
}
