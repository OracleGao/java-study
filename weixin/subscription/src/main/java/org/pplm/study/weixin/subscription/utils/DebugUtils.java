package org.pplm.study.weixin.subscription.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DebugUtils {
	
	public static String bean2Json (Object bean) {
		if (bean != null) {
			ObjectMapper objectMapper = new ObjectMapper();
			try {
				return objectMapper.writeValueAsString(bean);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
