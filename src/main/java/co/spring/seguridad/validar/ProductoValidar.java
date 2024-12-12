package co.spring.seguridad.validar;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class ProductoValidar implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@NotBlank
	private String nombre;
	
	
	//@Pattern(regexp = "/^[0-9]{3}\\.[0-9]{2}$/",message = "Precio no valido")
	@DecimalMin(value = "0.01")
	private BigDecimal precio;
	
	@Min(value = 1)
	private long idCategoria;

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

	public long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
	}

	@Override
	public String toString() {
		return "ProductoValidar [nombre=" + nombre + ", precio=" + precio + ", idCategoria=" + idCategoria + "]";
	}
	
	
	
}
