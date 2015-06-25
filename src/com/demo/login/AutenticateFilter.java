package com.demo.login;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

@Provider
public class AutenticateFilter implements ContainerRequestFilter {
	public static final String AUTHENTICATION_HEADER = "Authorization";

	/**
	 * This method will execute before GET request invoke. This will get user entered credentials 
	 * and check validity
	 */
	@Override
	public void filter(ContainerRequestContext containerRequest) throws WebApplicationException {

		String credentials = containerRequest.getHeaderString(AUTHENTICATION_HEADER);

		validationService authenticationService = new validationService();
		boolean authenticationStatus = authenticationService.validateAuthentication(credentials);

		if (!authenticationStatus) {
			throw new WebApplicationException(Status.UNAUTHORIZED);
		}
	}	
}
