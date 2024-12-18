package co.spring.seguridad.iservicio;

import co.spring.seguridad.persistencia.entidad.UsuarioDTO;
import co.spring.seguridad.validar.ClienteValidar;

public interface IAutenticarServicio {
	
	UsuarioDTO crearCliente(ClienteValidar unCliente);	
	
}
