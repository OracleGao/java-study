package com.piao.jfp.base;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.piao.jfp.utils.Utils;

public class Album implements Performance {
	private String name;
	private List<Track> tracks = new ArrayList<>();
	private List<Artist> musicians = new ArrayList<>();
	
	public Album() {
		super();
	}

	public Album(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}

	public Stream<Artist> getMusicians() {
		return musicians.stream();
	}
	
	public void setMusicians(List<Artist> musicians) {
		this.musicians = musicians;
	}

	@Override
	public String toString(){
		return "name:" + name + ", tracks:" + Utils.toString(tracks) + ", musicians:" + Utils.toString(musicians);	
	}
	
}
