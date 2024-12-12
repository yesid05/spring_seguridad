package co.spring.seguridad.controlador;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.spring.seguridad.iservicio.ICategoriaServicio;
import co.spring.seguridad.persistencia.entidad.CategoriaDTO;
import co.spring.seguridad.validar.CategoriaValidar;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaControlador {
	
	@Autowired
	private ICategoriaServicio categoriaServicio;

	@GetMapping
	public ResponseEntity<Page<CategoriaDTO>> buscarTodos(Pageable pagina){
		
		Page<CategoriaDTO> pCategoria = categoriaServicio.buscarTodos(pagina);
		
		return ResponseEntity.ok(pCategoria);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaDTO> buscarPorId(@PathVariable long id){
		
		Optional<CategoriaDTO> oCategoria = categoriaServicio.buscarPorId(id);
		
		if(oCategoria.isPresent())
			return ResponseEntity.ok(oCategoria.get());
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<CategoriaDTO> crear(@RequestBody @Valid CategoriaValidar unaCategoria){
		
		CategoriaDTO categoriaDTO = categoriaServicio.crear(unaCategoria);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaDTO);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CategoriaDTO> actualizar(@PathVariable long id, @RequestBody @Valid CategoriaValidar unaCategoria){
		
		CategoriaDTO categoriaDTO = categoriaServicio.actualizar(id,unaCategoria);
		
		return ResponseEntity.ok(categoriaDTO);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<CategoriaDTO> eliminar(@PathVariable long id){
		
		CategoriaDTO categoriaDTO = categoriaServicio.eliminar(id);
		
		return ResponseEntity.ok(categoriaDTO);
	}
	
	@PutMapping("/{id}/deshabilitar")
	public ResponseEntity<CategoriaDTO> deshabilitarPorId(@PathVariable long id){
		
		CategoriaDTO categoriaDTO = categoriaServicio.deshabilitarPorId(id);
		
		return ResponseEntity.ok(categoriaDTO);
	}
	
}
	