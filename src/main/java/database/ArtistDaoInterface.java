package database;

import java.util.List;

import model.Artist;

public interface ArtistDaoInterface {

	public List<Artist> getAllArtist();

	public boolean addArtist(Artist newArtist);

	public List<Artist> searchArtist(String search);
}
