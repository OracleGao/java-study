package org.pplm.study.cglib;

public class HelloWorld {
	private String message;

	public HelloWorld() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void showMessage() {
		System.out.println(message);
	}
	
}
