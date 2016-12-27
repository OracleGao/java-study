package org.pplm.jfp.base;

public class Track {
	
	private String name;

	public Track() {
		super();
	}

	public Track(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	} 
}
