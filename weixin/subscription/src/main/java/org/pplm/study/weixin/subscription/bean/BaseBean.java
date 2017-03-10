package org.pplm.study.weixin.subscription.bean;

import org.pplm.study.weixin.subscription.utils.DebugUtils;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "xml")
public class BaseBean {
	
	public static final String MESSAGE_TYPE_TEXT = "text";
	
	@JacksonXmlProperty(localName = "ToUserName")
	private String toUserName;
	
	@JacksonXmlProperty(localName = "FromUserName")
	private String fromUserName;
	
	@JacksonXmlProperty(localName = "CreateTime")
	private String createTime;
	
	@JacksonXmlProperty(localName = "MsgType")
	private String msgType;

	public BaseBean() {
		super();
	}
	
	public BaseBean(BaseBean baseBean) {
		this.toUserName = baseBean.getToUserName();
		this.fromUserName = baseBean.getFromUserName();
		this.createTime = baseBean.getCreateTime();
		this.msgType = baseBean.getMsgType();
	}

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	
	@Override
	public String toString() {
		return DebugUtils.bean2Json(this);
	}
	
}
