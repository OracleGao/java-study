package org.pplm.study.weixin.subscription.bean;

public class MessageResponseBean extends BaseBean {
	
	public MessageResponseBean() {
		super();
	}

	public MessageResponseBean(BaseBean baseBean) {
		super();
		this.setFromUserName(baseBean.getToUserName());
		this.setToUserName(baseBean.getFromUserName());
		this.setCreateTime(String.valueOf(System.currentTimeMillis()));
	}
	
}
