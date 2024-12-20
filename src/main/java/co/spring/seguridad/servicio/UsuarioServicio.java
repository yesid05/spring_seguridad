package co.spring.seguridad.servicio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import co.spring.seguridad.iservicio.IUsuarioServicio;
import co.spring.seguridad.persistencia.entidad.UsuarioDTO;
import co.spring.seguridad.persistencia.repositorio.IUsuarioRepositorio;

@Service
public class UsuarioServicio implements IUsuarioServicio{

	@Autowired
	private IUsuarioRepositorio usuarioRepositorio;
	
	
	@Override
	public Optional<UsuarioDTO> buscarPorNombreUsuario(String unNombreUsuario) {
		// TODO Auto-generated method stub
		return usuarioRepositorio.findByNombreUsuario(unNombreUsuario);
	}

	

}
