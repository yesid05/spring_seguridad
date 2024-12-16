package co.spring.seguridad.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

@Configuration
public class InjectorBeansSeguridad {
	
	@Autowired
	private AuthenticationConfiguration authenticationConfiguration;
	
	
	@Bean
	public AuthenticationManager authenticationManager() throws Exception {
		
		return authenticationConfiguration.getAuthenticationManager();
		
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider estrategiaAutenticacion = new DaoAuthenticationProvider();
		
		estrategiaAutenticacion.setPasswordEncoder(null);
		estrategiaAutenticacion.setUserDetailsService(null);
		
		return estrategiaAutenticacion;
		
	}
	
}
