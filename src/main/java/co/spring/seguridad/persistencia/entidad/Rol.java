package co.spring.seguridad.persistencia.entidad;

import java.util.Arrays;
import java.util.List;

public enum Rol {
	
	ROL_ADMINISTRADOR(Arrays.asList(
		RolPermiso.PRODUCTO_LEER_TODOS,
		RolPermiso.PRODUCTO_LEER_UNO,
		RolPermiso.PRODUCTO_CREAR,
		RolPermiso.PRODUCTO_ACTUALIZAR,
		RolPermiso.PRODUCTO_ELIMINAR,
		RolPermiso.PRODUCTO_DESHABILITAR,
		
		RolPermiso.CATEGORIA_LEER_TODOS,
		RolPermiso.CATEGORIA_LEER_UNO,
		RolPermiso.CATEGORIA_CREAR,
		RolPermiso.CATEGORIA_ACTUALIZAR,
		RolPermiso.CATEGORIA_ELIMINAR,
		RolPermiso.CATEGORIA_DESHABILITAR,
		
		RolPermiso.USUARIO_VER_PERFIL
	)),
	
	ROL_ADMINISTRADOR_ASISTENTE(Arrays.asList(
		RolPermiso.PRODUCTO_LEER_TODOS,
		RolPermiso.PRODUCTO_LEER_UNO,
		
		RolPermiso.CATEGORIA_LEER_TODOS,
		RolPermiso.CATEGORIA_LEER_UNO,
		RolPermiso.CATEGORIA_ACTUALIZAR,
		
		RolPermiso.USUARIO_VER_PERFIL
	)),
	
	ROLE_CLIENTE(Arrays.asList(
		RolPermiso.USUARIO_VER_PERFIL
	));
	
	private List<RolPermiso> permisos;

	private Rol(List<RolPermiso> permisos) {
		this.permisos = permisos;
	}

	public List<RolPermiso> getPermisos() {
		return permisos;
	}

	public void setPermisos(List<RolPermiso> permisos) {
		this.permisos = permisos;
	}
	
	
}
