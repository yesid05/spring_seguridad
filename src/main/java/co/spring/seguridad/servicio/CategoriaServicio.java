package co.spring.seguridad.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import co.spring.seguridad.error.Error;
import co.spring.seguridad.iservicio.ICategoriaServicio;
import co.spring.seguridad.persistencia.entidad.CategoriaDTO;
import co.spring.seguridad.persistencia.entidad.Status;
import co.spring.seguridad.persistencia.repositorio.ICategoriaRepositorio;
import co.spring.seguridad.validar.CategoriaValidar;

@Service
public class CategoriaServicio implements ICategoriaServicio {
	
	@Autowired
	private ICategoriaRepositorio categoriaRepositorio;

	@Override
	public Page<CategoriaDTO> buscarTodos(Pageable pagina) {
		return categoriaRepositorio.findAll(pagina);
	}

	@Override
	public Optional<CategoriaDTO> buscarPorId(long id) {
		
		return categoriaRepositorio.findById(id);
		
	}
	
	@Override
	public CategoriaDTO crear(CategoriaValidar unaCategoria) {
		
		CategoriaDTO categoriaDTO = new CategoriaDTO();
		
		categoriaDTO.setNombre(unaCategoria.getNombre());
		categoriaDTO.setStatus(Status.HABILITAR);
		
		return categoriaRepositorio.save(categoriaDTO);
	}

	@Override
	public CategoriaDTO actualizar(long id, CategoriaValidar unaCategoria) {
		
		CategoriaDTO categoriaDTO = categoriaRepositorio.findById(id)
				.orElseThrow(()-> new Error("Categoria no encontrada",null));

		categoriaDTO.setNombre(unaCategoria.getNombre());
				
		return categoriaRepositorio.save(categoriaDTO);
	}

	@Override
	public CategoriaDTO eliminar(long id) {
		CategoriaDTO categoriaDTO = categoriaRepositorio.findById(id)
				.orElseThrow(()-> new Error("Categoria no encontrada",null));
		
		categoriaRepositorio.deleteById(id);
		
		return categoriaDTO;
	}

	@Override
	public CategoriaDTO deshabilitarPorId(long id) {
		
		CategoriaDTO categoriaDTO = categoriaRepositorio.findById(id)
				.orElseThrow(()-> new Error("Categoria no encontrada",null));
		
		if(categoriaDTO.getStatus().equals(Status.HABILITAR))
			categoriaDTO.setStatus(Status.DESHABILITAR);
		else
			categoriaDTO.setStatus(Status.HABILITAR);
		
		
		return categoriaRepositorio.save(categoriaDTO);
	}

	

}
