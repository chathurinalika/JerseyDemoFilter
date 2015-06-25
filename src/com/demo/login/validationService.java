package com.demo.login;

import java.io.IOException;
import java.util.Base64;
import java.util.StringTokenizer;

public class validationService {

	public boolean validateAuthentication(String credentials) {
		if (null == credentials){
			//User hasn't entered credentials
			return false;
		}
		
		else{			
		// Header value format will be "Basic encoded string" for Basic authentication. 
		// Example : "Basic YWRtaW46YWRtaW4="
		final String encodedUserPassword = credentials.replaceFirst("Basic" + " ", "");
		
		String usernameAndPassword = null;
		try {
			byte[] decodedBytes = Base64.getDecoder().decode(encodedUserPassword);
			
			usernameAndPassword = new String(decodedBytes, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		final StringTokenizer tokenizer = new StringTokenizer(usernameAndPassword, ":");
		final String username = tokenizer.nextToken();
		final String password = tokenizer.nextToken();

		//Compare entered values
		boolean authenticationStatus = "admin".equals(username) && "admin".equals(password);
		
		return authenticationStatus;
		}
	}
}
