package co.spring.seguridad.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ConfiguracionSeguridadHttp {

	@Autowired
	private AuthenticationProvider authenticationProvider;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity unHttp) throws Exception {
		
		return unHttp
				.csrf(csrfConfig -> csrfConfig.disable())
				.sessionManagement(sesionConfig -> {
					sesionConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
				})
				.authenticationProvider(authenticationProvider)
				.authorizeHttpRequests(authConfig -> {
					authConfig.requestMatchers(HttpMethod.POST,"/cliente").permitAll();
					authConfig.requestMatchers(HttpMethod.POST,"/autenticar/**").permitAll();
					
					authConfig.anyRequest().authenticated();
				})
				.build();
		
	}
	
}
