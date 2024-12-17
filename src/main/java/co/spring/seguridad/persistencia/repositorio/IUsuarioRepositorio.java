package co.spring.seguridad.persistencia.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.spring.seguridad.persistencia.entidad.UsuarioDTO;

public interface IUsuarioRepositorio extends JpaRepository<UsuarioDTO, Long>{

	Optional<UsuarioDTO> buscarPorNombreUsuario(String unNombreUsuario);

}
