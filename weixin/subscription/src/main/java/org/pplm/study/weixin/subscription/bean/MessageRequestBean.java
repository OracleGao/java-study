package org.pplm.study.weixin.subscription.bean;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;


public class MessageRequestBean extends BaseBean {

	//text message
	@JacksonXmlProperty(localName = "Content")
	private String content;
	
	@JacksonXmlProperty(localName = "MsgId")
	private String msgId;
	
	
	public MessageRequestBean() {
		super();
	}

	public TextRequestBean getTextBean() {
		return new TextRequestBean(this);
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

}
