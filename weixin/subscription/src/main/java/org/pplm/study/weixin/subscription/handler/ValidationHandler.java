package org.pplm.study.weixin.subscription.handler;

import java.io.UnsupportedEncodingException;

import java.security.NoSuchAlgorithmException;

import org.pplm.study.weixin.subscription.service.ValidationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ValidationHandler {

	@Autowired
	private ValidationService validationService;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public String onGetValidation(@RequestParam(value = "signature", required = true) String signature,
			@RequestParam(value = "timestamp", required = true) String timestamp,
			@RequestParam(value = "nonce", required = true) String nonce,
			@RequestParam(value = "echostr", required = true) String echostr) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		if (validationService.isValid(signature, nonce, timestamp)) {
			return echostr;
		}
		return null;
	}

}
