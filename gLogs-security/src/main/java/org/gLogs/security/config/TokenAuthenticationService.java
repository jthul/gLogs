package org.gLogs.security.config;

import static java.util.Collections.emptyList;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

class TokenAuthenticationService {
	static final long EXPIRATIONTIME = 600000; // 10 minutes
	
	static final String SECRET = "g1L9o8g2s3K7e6y4S5u0p1e2r3S4e5c6r7e8t_*12587" + System.currentTimeMillis();
	static final String TOKEN_PREFIX = "XTFGLOGS";
	static final String HEADER_STRING = "Authorization";

	static void addAuthentication(HttpServletResponse res, String username) {
		String JWT = Jwts.builder().setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
				.signWith(SignatureAlgorithm.HS512, SECRET).compact();
		res.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
	}

	static Authentication getAuthentication(HttpServletRequest request) {
		String token = request.getHeader(HEADER_STRING);
		if (token != null) {
			String user = null;
			try{
				user = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody()
						.getSubject();
				return user != null ? new UsernamePasswordAuthenticationToken(user, null, emptyList()) : null;
			}catch(SignatureException e){
				return null;
			}
		}
		return null;
	}
}