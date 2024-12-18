package co.spring.seguridad.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.spring.seguridad.iservicio.IAutenticarServicio;
import co.spring.seguridad.persistencia.entidad.UsuarioDTO;
import co.spring.seguridad.validar.ClienteValidar;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteControlador {
	
	@Autowired
	private IAutenticarServicio autenticarServicio;
	
	@PostMapping
	public ResponseEntity<UsuarioDTO> registrar(@RequestBody @Valid ClienteValidar unCliente){
		
		UsuarioDTO usuario = autenticarServicio.crearCliente(unCliente);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
		
	}
	
}
