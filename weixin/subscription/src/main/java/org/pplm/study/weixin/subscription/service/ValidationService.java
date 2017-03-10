package org.pplm.study.weixin.subscription.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.pplm.study.weixin.subscription.config.ValidationConfig;
import org.pplm.study.weixin.subscription.utils.CipherUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {

	@Autowired
	private ValidationConfig validationConfig;

	public boolean isValid(String signature, String nonce, String timestamp)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String plaintext = Stream.of(validationConfig.getToken(), timestamp, nonce).sorted()
				.collect(Collectors.joining());
		String ciphertext = CipherUtils.hexDigest(validationConfig.getCipher(), plaintext,
				validationConfig.getEncoding());
		return ciphertext.equals(signature);
	}
	
}
