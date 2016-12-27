package org.pplm.study.classloader;

public class HelloWorld {
	private String message;

	public HelloWorld() {
		super();
		System.out.println("construct helloworld instanct!");
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
