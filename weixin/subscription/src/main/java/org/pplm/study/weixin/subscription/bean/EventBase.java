package org.pplm.study.weixin.subscription.bean;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class EventBase extends BaseBean {
	@JacksonXmlProperty(localName = "Event")
	private String event;
	
	@JacksonXmlProperty(localName = "EventKey")
	private String eventKey;

	public EventBase() {
		super();
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}
	
}
