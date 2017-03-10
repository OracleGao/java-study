package org.pplm.study.weixin.subscription.handler;

import org.pplm.study.weixin.subscription.bean.MessageRequestBean;
import org.pplm.study.weixin.subscription.bean.MessageResponseBean;
import org.pplm.study.weixin.subscription.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MessageHandler {
	
	@Autowired
	private MessageService messageService;
	
	@RequestMapping(method = RequestMethod.POST, consumes= MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
	public MessageResponseBean onGetReceiveMessage(@RequestBody MessageRequestBean messageRequestBean) {
		return messageService.processMessage(messageRequestBean);
	}
}
