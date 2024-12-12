package co.spring.seguridad.controlador;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import co.spring.seguridad.error.ManejadorError;
import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ManejadorGlobalExcepciones {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> manejadorGenericoExcepcion(HttpServletRequest request, Exception exception){
		ManejadorError manejadorError = new ManejadorError();
		
		manejadorError.setBackendMensaje(exception.getLocalizedMessage());
		manejadorError.setUrl(request.getRequestURL().toString());
		manejadorError.setMetodo(request.getMethod());
		manejadorError.setTiempo(LocalDateTime.now());
		manejadorError.setMensaje("Error interno en el servidor");
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(manejadorError);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> manejadorArgumentoExcepcion(HttpServletRequest request, MethodArgumentNotValidException exception){
		ManejadorError manejadorError = new ManejadorError();
		
		manejadorError.setBackendMensaje(exception.getLocalizedMessage());
		manejadorError.setUrl(request.getRequestURL().toString());
		manejadorError.setMetodo(request.getMethod());
		manejadorError.setMensaje("Error en la peticion enviada");
		
		
		List<ObjectError> vecMensaje = exception.getAllErrors();
		for (ObjectError string : vecMensaje) {
			System.out.println(string.getDefaultMessage());
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(manejadorError);
	}
	
}
