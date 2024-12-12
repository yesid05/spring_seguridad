package co.spring.seguridad.iservicio;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import co.spring.seguridad.persistencia.entidad.CategoriaDTO;
import co.spring.seguridad.validar.CategoriaValidar;

public interface ICategoriaServicio {
	
	Page<CategoriaDTO> buscarTodos(Pageable pagina);

	Optional<CategoriaDTO> buscarPorId(long id);
	
	CategoriaDTO crear(CategoriaValidar unaCategoria);

	CategoriaDTO actualizar(long id,CategoriaValidar unaCategoria);

	CategoriaDTO eliminar(long id);

	CategoriaDTO deshabilitarPorId(long id);
	
}
