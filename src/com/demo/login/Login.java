package com.demo.login;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/login")
public class Login{

	/**
	 * This method will invoke only if credential validation correct
	 * URI is - http://localhost:8080/JerseyDemoFilter/demo/login
	 * 
	 * @return welcome string
	 */
	@GET
	public String sayWelcome(){	
		return "Welcome !";
	}
}
