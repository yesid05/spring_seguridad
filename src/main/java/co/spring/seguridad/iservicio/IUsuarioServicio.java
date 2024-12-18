package co.spring.seguridad.iservicio;

import java.util.Optional;

import co.spring.seguridad.persistencia.entidad.UsuarioDTO;

public interface IUsuarioServicio {
	
	Optional<UsuarioDTO> buscarPorNombreUsuario(String unNombreUsuario);
	
}
