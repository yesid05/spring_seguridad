package co.spring.seguridad.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import co.spring.seguridad.error.Error;
import co.spring.seguridad.iservicio.IProductoServicio;
import co.spring.seguridad.persistencia.entidad.CategoriaDTO;
import co.spring.seguridad.persistencia.entidad.ProductoDTO;
import co.spring.seguridad.persistencia.entidad.Status;
import co.spring.seguridad.persistencia.repositorio.IProductoRepositorio;
import co.spring.seguridad.validar.ProductoValidar;

@Service
public class ProductoServicio implements IProductoServicio{
	
	@Autowired
	private IProductoRepositorio productoRepositorio;

	@Override
	public Page<ProductoDTO> buscarTodos(Pageable pagina) {
		
		return productoRepositorio.findAll(pagina);
	}

	@Override
	public Optional<ProductoDTO> buscarPorId(long id) {
		
		return productoRepositorio.findById(id);
		
	}

	@Override
	public ProductoDTO crear(ProductoValidar unProducto) {
		
		ProductoDTO productoDTO = new ProductoDTO();
		
		productoDTO.setNombre(unProducto.getNombre());
		productoDTO.setPrecio(unProducto.getPrecio());
		productoDTO.setStatus(Status.HABILITAR);
		productoDTO.setCategoriaDTO(new CategoriaDTO(unProducto.getIdCategoria(),null,null));
		
		return productoRepositorio.save(productoDTO);
		
	}

	@Override
	public ProductoDTO actualizar(long id, ProductoValidar unProducto) {
		
		ProductoDTO productoDTO = productoRepositorio.findById(id)
				.orElseThrow(() -> new Error("Error. Producto no encontrado", null));
		
		productoDTO.setNombre(unProducto.getNombre());
		productoDTO.setPrecio(unProducto.getPrecio());
		productoDTO.setCategoriaDTO(new CategoriaDTO(unProducto.getIdCategoria(), null, null));
		
		return productoRepositorio.save(productoDTO);
	}

	@Override
	public ProductoDTO eliminar(long id) {
		
		ProductoDTO productoDTO = productoRepositorio.findById(id)
				.orElseThrow(() -> new Error("Error. Producto no encontrado", null));
		
		productoRepositorio.deleteById(id);
		
		return productoDTO;
	}

	@Override
	public ProductoDTO deshabilitarPorId(long id) {
		
		ProductoDTO productoDTO = productoRepositorio.findById(id)
				.orElseThrow(() -> new Error("Error. Producto no encontrado", null));
		
		if(productoDTO.getStatus().equals(Status.HABILITAR))
			productoDTO.setStatus(Status.DESHABILITAR);
		else
			productoDTO.setStatus(Status.HABILITAR);
		
		return productoRepositorio.save(productoDTO);
	}

}
