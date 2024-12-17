package co.spring.seguridad.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import co.spring.seguridad.error.Error;
import co.spring.seguridad.persistencia.repositorio.IUsuarioRepositorio;

@Configuration
public class InjectorBeansSeguridad {
	
	@Autowired
	private IUsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private AuthenticationConfiguration authenticationConfiguration;
	
	
	@Bean
	public AuthenticationManager authenticationManager() throws Exception {
		
		return authenticationConfiguration.getAuthenticationManager();
		
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider estrategiaAutenticacion = new DaoAuthenticationProvider();
		
		estrategiaAutenticacion.setPasswordEncoder(passwordEncoder());
		estrategiaAutenticacion.setUserDetailsService(null);
		
		return estrategiaAutenticacion;
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		return (unNombreUsuario) -> {
			return usuarioRepositorio.buscarPorNombreUsuario(unNombreUsuario)
					.orElseThrow(() -> new Error("Usuario no encontrado con el nombre de usuario "+unNombreUsuario,null));
		};
	}
	
}
