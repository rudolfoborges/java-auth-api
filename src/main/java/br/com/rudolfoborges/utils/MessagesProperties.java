package br.com.rudolfoborges.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("messages.properties")
@ConfigurationProperties(prefix = "messages")
public class MessagesProperties {
	
	@Value("${messages.unauthorize}")
	private String unauthorize;
	
	@Value("${messages.forbidden}")
	private String forbidden;
	
	@Value("${messages.userExists}")
	private String userExists;
	
	@Value("${messages.internalError}")
	private String internalError;

	public String getUnauthorize() {
		return unauthorize;
	}

	public void setUnauthorize(String unauthorize) {
		this.unauthorize = unauthorize;
	}

	public String getForbidden() {
		return forbidden;
	}

	public void setForbidden(String forbidden) {
		this.forbidden = forbidden;
	}

	public String getUserExists() {
		return userExists;
	}

	public void setUserExists(String userExists) {
		this.userExists = userExists;
	}

	public String getInternalError() {
		return internalError;
	}

	public void setInternalError(String internalError) {
		this.internalError = internalError;
	}
	
}
