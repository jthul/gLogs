package org.gLogs.security.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;

/**
 * 
 * @author thulliezj
 *
 */
public interface TokenAuthentificationInterface {
	public Authentication getAuthUser(HttpServletRequest request);
}
