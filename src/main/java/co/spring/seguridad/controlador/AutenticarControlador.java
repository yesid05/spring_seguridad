package co.spring.seguridad.controlador;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.spring.seguridad.iservicio.IAutenticarServicio;
import co.spring.seguridad.iservicio.IJwtServicio;
import co.spring.seguridad.iservicio.IUsuarioServicio;
import co.spring.seguridad.persistencia.entidad.UsuarioDTO;
import co.spring.seguridad.validar.IngresarValidar;
import co.spring.seguridad.validar.TokenValidar;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/autenticar")
public class AutenticarControlador {

	@Autowired
	private IAutenticarServicio autenticarServicio;
	
	@Autowired
	private IJwtServicio jwtServicio;
	
	@Autowired
	private IUsuarioServicio usuarioServicio;
	
	@PostMapping("/ingresar")
	public ResponseEntity<Map<String, Object>> ingresar(@RequestBody @Valid IngresarValidar unIngreso){
		
		UsuarioDTO usuario = autenticarServicio.ingresar(unIngreso);
		
		String token = jwtServicio.generarToken(usuario);
		
		Map<String, Object> respuesta = new HashMap<>();
		
		respuesta.put("nombreUsuario", usuario.getNombreUsuario());
		respuesta.put("token", token);
		
		return ResponseEntity.ok(respuesta);
		
	}
	
	@PostMapping("/validar-token")
	public ResponseEntity<Map<String, Object>> validarToken(@RequestBody @Valid TokenValidar unToken){
		
		Map<String, Object> respuesta = new HashMap<>();
		
		try {
			
			jwtServicio.validarToken(unToken.getToken());
			
			respuesta.put("esValido", Boolean.TRUE);
					
		} catch (Exception e) {			
			respuesta.put("error", e.getLocalizedMessage());
			respuesta.put("esValido", Boolean.FALSE);			
		}
		
		return ResponseEntity.ok(respuesta);
	}
	
	@PostMapping("/perfil")
	public ResponseEntity<UsuarioDTO> buscarPerfil(){
		HashMap<String, Object> respuesta = new HashMap<>();
		
		String unUsuario = autenticarServicio.buscarPerfil();
		
		Optional<UsuarioDTO> unUsuarioDTO = usuarioServicio.buscarPorNombreUsuario(unUsuario);
		
		return ResponseEntity.ok(unUsuarioDTO.get());
	}
	
}
