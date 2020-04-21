package com.vaadin.tutorial.com.security;

import com.vaadin.flow.server.ServletHelper;
import com.vaadin.flow.shared.ApplicationConstants;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

public final class SecurityUtils {

	private SecurityUtils() {

	}

	static boolean isFrameworkInternalRequest(HttpServletRequest request) {
		final String parameterVlaue = request.getParameter(ApplicationConstants.REQUEST_TYPE_PARAMETER);
		return parameterVlaue != null
				&& Stream.of(ServletHelper.RequestType.values()).anyMatch(r -> r.getIdentifier().equals(parameterVlaue));
	}

	static boolean isUserLoggedIn() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication != null
				&& !(authentication instanceof AnonymousAuthenticationToken)
				&& authentication.isAuthenticated();
	}

}
