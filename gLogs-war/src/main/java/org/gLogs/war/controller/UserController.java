package org.gLogs.war.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.gLogs.data.exception.DataNotFoundException;
import org.gLogs.data.model.UserDTO;
import org.gLogs.engine.service.AuthenticateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private AuthenticateService authenticateService;

	/**
	 * @param username
	 * @param password
	 * @param response
	 * @return JSON contains token and user after success authentication.
	 * @throws IOException
	 */
	@RequestMapping(value = "/authenticate", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> login(@RequestParam String username, @RequestParam String password,
			HttpServletResponse response) throws IOException {
		String token = null;
		UserDTO dto = new UserDTO(username, password);
		UserDTO authUser = null;
		Map<String, Object> tokenMap = new HashMap<String, Object>();
		
		try {
			authUser = authenticateService.authenticate(dto);
		} catch (DataNotFoundException e) {
			tokenMap.put("token", null);
		}

		if (authUser != null) {
			token = Jwts.builder().setSubject(username).claim("roles", authUser.getRoles()).setIssuedAt(new Date())
					.signWith(SignatureAlgorithm.HS256, "secretkey").compact();
			tokenMap.put("token", token);
			tokenMap.put("user", authUser);
			return new ResponseEntity<Map<String, Object>>(tokenMap, HttpStatus.OK);
		} else {
			return new ResponseEntity<Map<String, Object>>(tokenMap, HttpStatus.UNAUTHORIZED);
		}
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> createUser(@RequestBody Map<String, Object> parameters) {
		System.out.println("OUAIIIIIIIIIIII ! ");
		return null;
		
	}
 
}
