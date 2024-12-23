 package co.spring.seguridad.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.util.StringUtils;

import co.spring.seguridad.iservicio.IUsuarioServicio;
import co.spring.seguridad.persistencia.entidad.UsuarioDTO;
import co.spring.seguridad.servicio.JwtServicio;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFiltroAutenticacion extends OncePerRequestFilter {
	
	@Autowired
	private JwtServicio jwtServicio;
	
	@Autowired
	private IUsuarioServicio usuarioServicio;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		//Obtiene el encabezado Authorization
		
		String unaAutorizacion = request.getHeader("Authorization");
		if(!StringUtils.hasText(unaAutorizacion) || !unaAutorizacion.startsWith("Bearer ")) {
			filterChain.doFilter(request, response);
			return;
		}
		
		//Obtener el jwt
		String jwt = unaAutorizacion.split(" ")[1];
		

		//Obtener el subject
		String nombreUsuario = jwtServicio.validarToken(jwt).getSubject();
		
		UsuarioDTO unUsuarioDTO = usuarioServicio.buscarPorNombreUsuario(nombreUsuario).get();
		
		//Inyectar el objeto authentication en Security
		Authentication authentication = new UsernamePasswordAuthenticationToken(unUsuarioDTO.getNombreUsuario(), null, unUsuarioDTO.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		//ejecutar el registro de filtros
		filterChain.doFilter(request, response);

	}

}
