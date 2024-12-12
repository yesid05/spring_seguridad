package co.spring.seguridad.persistencia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import co.spring.seguridad.persistencia.entidad.ProductoDTO;

public interface IProductoRepositorio extends JpaRepository<ProductoDTO, Long> {}
