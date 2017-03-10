package org.pplm.study.weixin.subscription.handler;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;
import org.pplm.study.weixin.subscription.BaseTest;
import org.pplm.study.weixin.subscription.config.ValidationConfig;
import org.pplm.study.weixin.subscription.utils.CipherUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidationHandlerTest extends BaseTest {

	@Autowired
	private ValidationConfig validationConfig;
	
	@Test
	public void onGetValidationTest() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		String timestamp = String.valueOf(System.currentTimeMillis());
		String nonce = UUID.randomUUID().toString();
		String echostr = UUID.randomUUID().toString();
		String plaintext = Stream.of(validationConfig.getToken(), timestamp, nonce).sorted()
				.collect(Collectors.joining());
		String signature = CipherUtils.hexDigest(validationConfig.getCipher(), plaintext, validationConfig.getEncoding());
		String url = "/validations?signature=" + signature + "&timestamp=" + timestamp + "&nonce=" + nonce + "&echostr=" + echostr;
		Assert.assertEquals(echostr, restTemplate.getForObject(url, String.class));
	}
	
}
