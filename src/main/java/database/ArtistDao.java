package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Artist;

public class ArtistDao implements ArtistDaoInterface {

	private Database db = new Database();

	public List<Artist> getAllArtist() {
		String selectAll = "SELECT ArtistId, Name FROM Artist ORDER BY Name ASC;";

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		List<Artist> allArtists = new ArrayList<>();

		try {
			connection = db.connect();
			statement = connection.prepareStatement(selectAll);
			results = statement.executeQuery();
			while (results.next()) {
				long id = results.getLong("ArtistId");
				String name = results.getString("Name");

				Artist a = new Artist(id, name);
				allArtists.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.db.close(connection, statement, results);
		}
		return allArtists;
	}

	public boolean addArtist(Artist newArtist) {
		String sql = "INSERT INTO Artist (Name) VALUES (?);";

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet ids = null;

		try {
			connection = this.db.connect();
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, newArtist.getName());
			int rows = statement.executeUpdate();
			if (rows == 1) {
				ids = statement.getGeneratedKeys();
				ids.next();
				long generatedId = ids.getLong(1);
				newArtist.setId(generatedId);
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.db.close(connection, statement, ids);
		}
		return false;
	}

	@Override
	public List<Artist> searchArtist(String search) {
		String selectAll = "SELECT ArtistId, Name FROM Artist WHERE Name LIKE (?) ORDER BY Name ASC;";

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		List<Artist> foundArtists = new ArrayList<>();

		try {
			connection = db.connect();
			statement = connection.prepareStatement(selectAll);
			statement.setString(1, "%" + search + "%");
			results = statement.executeQuery();
			while (results.next()) {
				long id = results.getLong("ArtistId");
				String name = results.getString("Name");

				Artist a = new Artist(id, name);
				foundArtists.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.db.close(connection, statement, results);
		}
		return foundArtists;
	}

}
