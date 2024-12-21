package co.spring.seguridad.validar;

import java.io.Serializable;

public class TokenValidar implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	

}
