package co.spring.seguridad.validar;

import java.io.Serializable;

public class IngresarValidar implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String nombreUsuario;
	
	private String contrasena;

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	
	
}
