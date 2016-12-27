package org.pplm.jfp.c3.e9;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.pplm.jfp.base.Album;
import org.pplm.jfp.base.Artist;
import org.pplm.jfp.base.Track;
import org.pplm.jfp.utils.Utils;

public class E391 {
	public static int AddUp(Stream<Integer> numbers) {
		return numbers.reduce(0, (x, y) -> x + y);
	}
	
	public static List<String> GetArtistsInfo(List<Artist> artists) {
		return artists.stream().map(artist -> artist.getName() + ":" + artist.getOrigin()).collect(Collectors.toList());
		//return artists.stream().flatMap(artist -> Stream.of(artist.getName(), artist.getOrigin())).collect(Collectors.toList());
	}
	
	public static List<Album> GetAlbums(List<Album> albums) {
		return albums.stream().filter(album -> album.getTracks() != null && album.getTracks().size() < 4).collect(Collectors.toList());
	}
	
	public static void main(String[] agrs) {
		System.out.println(AddUp(Stream.of(1, 2, 3, 4, 5)));
		
		List<Artist> artists = new ArrayList<>();
		artists.add(new Artist("周杰伦", "中国台湾"));
		artists.add(new Artist("许嵩", "中国"));
		artists.add(new Artist("Jackson", "USA"));
		Utils.Println(GetArtistsInfo(artists));
		
		List<Album> albums = new ArrayList<>();
		Album album = new Album("青年晚报");
		List<Track> tracks = new ArrayList<>();
		tracks.add(new Track("最佳歌手"));
		tracks.add(new Track("燕归巢"));
		tracks.add(new Track("早睡身体好"));
		tracks.add(new Track("雅俗共赏"));
		album.setTracks(tracks);
		albums.add(album);
		album = new Album("书香年华");
		tracks = new ArrayList<>();
		tracks.add(new Track("书香年华"));
		album.setTracks(tracks);
		albums.add(album);
		album = new Album("千古");
		tracks = new ArrayList<>();
		tracks.add(new Track("千古"));
		album.setTracks(tracks);
		albums.add(album);
		album = new Album("不如吃茶去");
		tracks = new ArrayList<>();
		tracks.add(new Track("山水之间"));
		tracks.add(new Track("惊鸿一面"));
		tracks.add(new Track("弹指一挥间"));
		album.setTracks(tracks);
		albums.add(album);
		Utils.Println(GetAlbums(albums));
		
	}
}
