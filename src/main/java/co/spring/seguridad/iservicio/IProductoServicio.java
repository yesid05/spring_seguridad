package co.spring.seguridad.iservicio;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import co.spring.seguridad.persistencia.entidad.ProductoDTO;
import co.spring.seguridad.validar.ProductoValidar;

public interface IProductoServicio {
	
	Page<ProductoDTO> buscarTodos(Pageable pagina);

	Optional<ProductoDTO> buscarPorId(long id);

	ProductoDTO crear(ProductoValidar unProducto);

	ProductoDTO actualizar(long id, ProductoValidar unProducto);

	ProductoDTO eliminar(long id);

	ProductoDTO deshabilitarPorId(long id);
	
}
