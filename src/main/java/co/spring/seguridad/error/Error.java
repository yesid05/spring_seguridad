package co.spring.seguridad.error;

public class Error extends RuntimeException {
	
	private String mensaje;
	
	private Throwable objError;
	
	public Error() {}

	public Error(String mensaje, Throwable objError) {
		super();
		this.mensaje = mensaje;
		this.objError = objError;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Throwable getObjError() {
		return objError;
	}

	public void setObjError(Throwable objError) {
		this.objError = objError;
	}
	
	
	
}
