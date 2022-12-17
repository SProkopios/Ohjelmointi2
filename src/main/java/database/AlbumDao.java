package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Album;
import model.Artist;

public class AlbumDao implements AlbumDaoInterface {

	private Database db = new Database();

	public List<Album> getAllAlbum(String ArtistId) {
		String selectAll = "SELECT AlbumId, Title, ArtistId FROM Album WHERE ArtistId = (?);";

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		List<Album> allAlbums = new ArrayList<>();

		try {
			connection = db.connect();
			statement = connection.prepareStatement(selectAll);
			statement.setString(1, ArtistId);
			results = statement.executeQuery();
			while (results.next()) {
				long id = results.getLong("AlbumId");
				String name = results.getString("Title");

				Album a = new Album(id, name);
				allAlbums.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.db.close(connection, statement, results);
		}
		return allAlbums;
	}

	@Override
	public List<Album> searchAlbum(String search) {
		String findAlbum = "SELECT AlbumId, ArtistId, Title FROM Album WHERE Title LIKE ? ORDER BY Title ASC;";

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		List<Album> foundAlbum = new ArrayList<>();

		try {
			connection = db.connect();
			statement = connection.prepareStatement(findAlbum);
			statement.setString(1, "%" + search + "%");
			results = statement.executeQuery();
			while (results.next()) {
				long artistId = results.getLong("ArtistId");
				long albumId = results.getLong("AlbumId");
				String title = results.getString("Title");

				Album a = new Album(albumId, artistId, title);
				foundAlbum.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.db.close(connection, statement, results);
		}
		return foundAlbum;
	}
}
