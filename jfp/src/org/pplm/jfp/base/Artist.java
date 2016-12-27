package org.pplm.jfp.base;

import java.util.ArrayList;
import java.util.List;

import org.pplm.jfp.utils.Utils;

public class Artist {
	private String name;
	private List<String> members = new ArrayList<>();
	private String origin;
	private boolean solo;

	public Artist() {
		super();
	}

	public Artist(String name) {
		super();
		this.name = name;
	}

	public Artist(String name, String origin) {
		super();
		this.name = name;
		this.origin = origin;
	}
	
	public Artist(String name, boolean solo) {
		super();
		this.name = name;
		this.solo = solo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addMember(String member) {
		this.addMember(member);
	}
	
	public List<String> getMembers() {
		return members;
	}

	public void setMembers(List<String> members) {
		this.members = members;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	public boolean isSolo() {
		return solo;
	}

	public void setSolo(boolean solo) {
		this.solo = solo;
	}

	@Override
	public String toString() {
		return "name:" + name + ", members:" + Utils.toString(members) + ", origin:" + origin;
	}
	
}
