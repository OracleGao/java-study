package org.pplm.study.weixin.subscription.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ValidationConfig {
	@Value("${weixin.subscription.validation.token}")
	private String token;
	
	@Value("${weixin.subscription.validation.cipher}")
	private String cipher;
	
	@Value("${weixin.subscription.validation.encoding}")
	private String encoding;

	public ValidationConfig() {
		super();
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getCipher() {
		return cipher;
	}

	public void setCipher(String cipher) {
		this.cipher = cipher;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
	
}
