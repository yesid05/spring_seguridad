package co.spring.seguridad.servicio;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import co.spring.seguridad.iservicio.IJwtServicio;
import co.spring.seguridad.persistencia.entidad.UsuarioDTO;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtServicio implements IJwtServicio{
	
	@Value("${jwt.expira-en-minutos}")
	public static long TIEMPO_DE_VENCIMIENTO = 30;

	@Value("${jwt.key}")
	public static String KEY = "estaclave";

	@Override
	public String generarToken(UserDetails unUsuario) {
		
		UsuarioDTO usuarioObj = (UsuarioDTO)unUsuario;
		
		Date horaActual = new Date(System.currentTimeMillis());
		
		Map<String, Object> extraClaims = new HashMap<>();
		extraClaims.put("name", usuarioObj.getNombre());
		extraClaims.put("role", usuarioObj.getRol().name());
		extraClaims.put("authorities", usuarioObj.getAuthorities());
		
		String jwt = Jwts.builder()
				.setClaims(extraClaims)
				.setSubject(usuarioObj.getUsername())
				.setIssuedAt(horaActual)
				.setExpiration(new Date((TIEMPO_DE_VENCIMIENTO*60*1000)+horaActual.getTime()))
				.setHeaderParam(Header.TYPE, Header.JWT_TYPE)
				.signWith(generarCalaveSecreta(),SignatureAlgorithm.HS256)
				.compact();
				
		return jwt;
	}
	
	private Key generarCalaveSecreta() {		
		return Keys.hmacShaKeyFor(KEY.getBytes());
	}
	
}
