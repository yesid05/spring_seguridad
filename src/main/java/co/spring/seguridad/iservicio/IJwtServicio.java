package co.spring.seguridad.iservicio;

import org.springframework.security.core.userdetails.UserDetails;

public interface IJwtServicio {

	String generarToken(UserDetails unUsuario);
	
}
