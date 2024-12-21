package co.spring.seguridad.iservicio;

import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Claims;

public interface IJwtServicio {

	String generarToken(UserDetails unUsuario);
	
	Claims validarToken(String unToken);
	
}
