package org.pplm.study.weixin.subscription.bean;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class TextResponseBean extends MessageResponseBean {
	
	@JacksonXmlProperty(localName = "Content")
	private String content;

	public TextResponseBean() {
		super();
	}

	public TextResponseBean(BaseBean baseBean) {
		super(baseBean);
		this.setMsgType(BaseBean.MESSAGE_TYPE_TEXT);
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public static TextResponseBean build(BaseBean baseBean, String content) {
		TextResponseBean textResponseBean = new TextResponseBean(baseBean);
		textResponseBean.setContent(content);
		return textResponseBean;
	}
	
}
