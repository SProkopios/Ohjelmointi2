package model;

public class Album {

	private long id;
	private String name;
	private long artistId;

	public Album(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Album(long id, long artistId, String name) {
		this.artistId = artistId;
		this.id = id;
		this.name = name;
	}

	public Album(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public long getId() {
		return this.id;
	}

	public long getArtistId() {
		return this.artistId;
	}
}
