package com.piao.jfp.c4.e12;

import java.util.stream.Stream;

import com.piao.jfp.base.Album;
import com.piao.jfp.base.Artist;

public class E4121 {
	static interface Performance {

	    public String getName();

	    public Stream<Artist> getMusicians();

	    public default Stream<Artist> getAllMusicians() {
	    	
	        return null;
	    }
	}
	
	static class AlbumNew extends Album implements Performance {
		
	}
	public static void main(String[] args) {
		Album album = new Album("老男孩之猛龙过江 ");
		
	}
}
