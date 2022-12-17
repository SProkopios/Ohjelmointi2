package database;

import java.util.List;

import model.Album;

public interface AlbumDaoInterface {

	public List<Album> getAllAlbum(String ArtistId);

	public List<Album> searchAlbum(String search);

}
