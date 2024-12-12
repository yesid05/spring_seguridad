package co.spring.seguridad.error;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ManejadorError implements Serializable{
	
	private String backendMensaje;
	
	private String mensaje;
	
	private String url;
	
	private String metodo;
	
	private LocalDateTime tiempo;

	public String getBackendMensaje() {
		return backendMensaje;
	}

	public void setBackendMensaje(String backendMensaje) {
		this.backendMensaje = backendMensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	public LocalDateTime getTiempo() {
		return tiempo;
	}

	public void setTiempo(LocalDateTime tiempo) {
		this.tiempo = tiempo;
	}
	
}
