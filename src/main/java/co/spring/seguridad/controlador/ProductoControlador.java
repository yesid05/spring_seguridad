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

import co.spring.seguridad.iservicio.IProductoServicio;
import co.spring.seguridad.persistencia.entidad.ProductoDTO;
import co.spring.seguridad.validar.ProductoValidar;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/producto")
public class ProductoControlador {
	
	@Autowired
	private IProductoServicio productoServicio;
	
	@GetMapping
	public ResponseEntity<Page<ProductoDTO>> buscarTodos(Pageable pagina){
		
		Page<ProductoDTO> pProducto = productoServicio.buscarTodos(pagina);
		
		return ResponseEntity.ok(pProducto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductoDTO> buscarPorId(@PathVariable long id){
		
		Optional<ProductoDTO> oProducto = productoServicio.buscarPorId(id);
		
		if(oProducto.isPresent())
			return ResponseEntity.ok(oProducto.get());
		
		return ResponseEntity.notFound().build();
		
	}
	
	@PostMapping
	public ResponseEntity<ProductoDTO> crear(@RequestBody @Valid ProductoValidar unProducto){
		
		ProductoDTO productoDTO = productoServicio.crear(unProducto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(productoDTO);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProductoDTO> actualizar(@PathVariable long id,@RequestBody @Valid ProductoValidar unProducto){
		
		ProductoDTO productoDTO = productoServicio.actualizar(id,unProducto);
		
		return ResponseEntity.ok(productoDTO);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ProductoDTO> eliminar(@PathVariable long id){
		
		ProductoDTO productoDTO = productoServicio.eliminar(id);
		
		return ResponseEntity.ok(productoDTO);
		
	}
	
	@PutMapping("/{id}/deshabilitar")
	public ResponseEntity<ProductoDTO> deshabilitarPorId(@PathVariable long id){
		
		ProductoDTO productoDTO = productoServicio.deshabilitarPorId(id);
		
		return ResponseEntity.ok(productoDTO);
		
	}
	
	
}
