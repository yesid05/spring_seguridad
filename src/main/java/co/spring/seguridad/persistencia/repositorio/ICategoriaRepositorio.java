package co.spring.seguridad.persistencia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import co.spring.seguridad.persistencia.entidad.CategoriaDTO;

public interface ICategoriaRepositorio extends JpaRepository<CategoriaDTO, Long>{}
