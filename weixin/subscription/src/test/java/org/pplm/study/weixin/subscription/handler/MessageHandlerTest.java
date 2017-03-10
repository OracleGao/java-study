package org.pplm.study.weixin.subscription.handler;

import org.junit.Test;
import org.pplm.study.weixin.subscription.BaseTest;
import org.springframework.http.HttpEntity;

public class MessageHandlerTest extends BaseTest {
	
	@Test
	public void onGetReceiveMessageTest() {
		String body = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><FromUserName><![CDATA[fromUser]]></FromUserName><CreateTime>1348831860</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[this is a test]]></Content><MsgId>1234567890123456</MsgId></xml>";
		String url = "/";
		HttpEntity<String> httpEnitiy = new HttpEntity<>(body);
		restTemplate.postForLocation(url, httpEnitiy);
	}
	
}
