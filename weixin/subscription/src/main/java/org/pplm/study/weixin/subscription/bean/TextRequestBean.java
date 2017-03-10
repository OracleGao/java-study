package org.pplm.study.weixin.subscription.bean;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class TextRequestBean extends BaseBean {
	
	@JacksonXmlProperty(localName = "Content")
	private String content;
	
	@JacksonXmlProperty(localName = "MsgId")
	private String msgId;

	public TextRequestBean() {
		super();
	}

	public TextRequestBean(MessageRequestBean messageReceptionBean) {
		super(messageReceptionBean);
		this.content = messageReceptionBean.getContent();
		this.msgId = messageReceptionBean.getMsgId();
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
