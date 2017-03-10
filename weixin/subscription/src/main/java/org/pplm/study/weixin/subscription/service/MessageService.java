package org.pplm.study.weixin.subscription.service;

import org.pplm.study.weixin.subscription.bean.BaseBean;
import org.pplm.study.weixin.subscription.bean.MessageRequestBean;
import org.pplm.study.weixin.subscription.bean.MessageResponseBean;
import org.pplm.study.weixin.subscription.bean.TextRequestBean;
import org.pplm.study.weixin.subscription.bean.TextResponseBean;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
	
	public MessageResponseBean processMessage(MessageRequestBean messageRequestBean) {
		if (BaseBean.MESSAGE_TYPE_TEXT.equals(messageRequestBean.getMsgType())) {
			return textMessageProcess(messageRequestBean.getTextBean());
		}
		return TextResponseBean.build(messageRequestBean, "暂不支持该类型服务！");
	}
	
	private TextResponseBean textMessageProcess(TextRequestBean textRequestBean) {
		if ("昆仑数据".equals(textRequestBean.getContent())) {
			return TextResponseBean.build(textRequestBean, "http://www.k2data.com.cn");
		}
		return TextResponseBean.build(textRequestBean, "您发送的消息是：" + textRequestBean.getContent());
	}
}
