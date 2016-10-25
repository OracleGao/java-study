package com.piao.jfp.c3.e9;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.piao.jfp.base.Artist;

public class E392 {

	public static int GetTotalMembers(List<Artist> artists) {
/*		
		return artists.stream().mapToInt(artist -> {
			List<String> members = artist.getMembers();
			if (members != null) {
				return members.size();
			}
			return 0;
		}).sum();
*/
		return artists.stream().map(artist -> {
			List<String> members = artist.getMembers();
			if (members != null) {
				return members.size();
			}
			return 0;}).reduce(0, Integer::sum);
	}

	public static void main(String[] args) {
		List<Artist> artists = new ArrayList<>();
		Artist artist = new Artist("周杰伦", "中国台湾");
		artist.setMembers(Stream.of("方文山", "徐若瑄").collect(Collectors.toList()));
		artists.add(artist);
		artist = new Artist("许嵩", "中国");
		artist.setMembers(Stream.of("郑楠", "Adam Lee", "陈伟伦").collect(Collectors.toList()));
		artists.add(artist);
		artists.add(new Artist("Jackson", "USA"));
		System.out.println(GetTotalMembers(artists));
	}

}
