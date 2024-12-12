package co.spring.seguridad.persistencia.entidad;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
public class ProductoDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nombre;
	
	private BigDecimal precio;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private CategoriaDTO categoriaDTO;

	public ProductoDTO() {}
	
	public ProductoDTO(long id, String nombre, BigDecimal precio, Status status) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.status = status;
	}

	public ProductoDTO(long id, String nombre, BigDecimal precio, Status status, CategoriaDTO categoriaDTO) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.status = status;
		this.categoriaDTO = categoriaDTO;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public CategoriaDTO getCategoriaDTO() {
		return categoriaDTO;
	}

	public void setCategoriaDTO(CategoriaDTO categoriaDTO) {
		this.categoriaDTO = categoriaDTO;
	}

	@Override
	public String toString() {
		return "ProductoDTO [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", status=" + status
				+ ", categoriaDTO=" + categoriaDTO + "]";
	}
	
	

}
