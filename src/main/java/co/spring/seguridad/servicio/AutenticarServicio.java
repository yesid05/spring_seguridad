package co.spring.seguridad.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import co.spring.seguridad.error.Error;
import co.spring.seguridad.iservicio.IAutenticarServicio;
import co.spring.seguridad.persistencia.entidad.Rol;
import co.spring.seguridad.persistencia.entidad.UsuarioDTO;
import co.spring.seguridad.persistencia.repositorio.IUsuarioRepositorio;
import co.spring.seguridad.validar.ClienteValidar;
import co.spring.seguridad.validar.IngresarValidar;

@Service
public class AutenticarServicio implements IAutenticarServicio {

	@Autowired
	private IUsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Override
	public UsuarioDTO crearCliente(ClienteValidar unCliente) {
		
		if(!unCliente.compararContrasena()) 
			throw new Error("Las contraseñas no coinciden",null);
		
		UsuarioDTO usuario = new UsuarioDTO();
		usuario.setNombre(unCliente.getNombre());
		usuario.setNombreUsuario(unCliente.getNombreUsuario());
		usuario.setContrasena(passwordEncoder.encode(unCliente.getContrasena()));
		usuario.setRol(Rol.ROLE_CLIENTE);
		
		return usuarioRepositorio.save(usuario);
		
	}

	@Override
	public UsuarioDTO ingresar(IngresarValidar unIngreso) {
		
		
		
		Authentication authentication = new UsernamePasswordAuthenticationToken(unIngreso.getNombreUsuario(), unIngreso.getContrasena()); 
		
		System.out.println(authentication.toString());
		
		return (UsuarioDTO)authenticationManager.authenticate(authentication).getPrincipal();
		
	}

}
