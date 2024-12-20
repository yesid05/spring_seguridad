package co.spring.seguridad.iservicio;

import co.spring.seguridad.persistencia.entidad.UsuarioDTO;
import co.spring.seguridad.validar.ClienteValidar;
import co.spring.seguridad.validar.IngresarValidar;

public interface IAutenticarServicio {
	
	UsuarioDTO crearCliente(ClienteValidar unCliente);
	
	UsuarioDTO ingresar(IngresarValidar unIngreso);
	
}
