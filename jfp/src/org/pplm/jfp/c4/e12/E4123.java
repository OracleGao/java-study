package org.pplm.jfp.c4.e12;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.pplm.jfp.base.Artist;


public class E4123 {
	static class Artists {

		private List<Artist> artists;

		public Artists(List<Artist> artists) {
			this.artists = artists;
		}

		/*
		 * public Artist getArtist(int index) { if (index < 0 || index >=
		 * artists.size()) { indexException(index); } return artists.get(index);
		 * }
		 */

		public Optional<Artist> getArtist(int index) {
			if (index < 0 || index >= artists.size()) {
				//indexException(index);
				return Optional.empty();
			}
			
			return Optional.ofNullable(artists.get(index));
		}

/*		private void indexException(int index) {
			throw new IllegalArgumentException(index + " doesn't correspond to an Artist");
		}*/

		/*
		 * public String getArtistName(int index) { try { Artist artist =
		 * getArtist(index); return artist.getName(); } catch
		 * (IllegalArgumentException e) { return "unknown"; } }
		 */

		public String getArtistName(int index) {
			try {
				Optional<Artist> artist = getArtist(index);
				return artist.orElseThrow(IllegalArgumentException::new).getName();
			} catch (IllegalArgumentException e) {
				return "unknown";
			}
		}
	}
	
	public static void main(String[] args) {
		Artists artists = new Artists(Stream.<Artist>builder().add(new Artist("许嵩","中国")).add(new Artist("Jackson", "USA")).build().collect(Collectors.toList()));
		System.out.println(artists.getArtistName(-1));
		System.out.println(artists.getArtistName(0));
		System.out.println(artists.getArtist(1));
		System.out.println(artists.getArtist(3));
	}
}
