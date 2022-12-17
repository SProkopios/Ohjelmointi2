package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.AlbumDao;
import database.ArtistDao;
import model.Album;
import model.Artist;

@WebServlet("/")
public class ArtistListServlet extends HttpServlet {

	private ArtistDao dao = new ArtistDao();
	private AlbumDao albumDao = new AlbumDao();

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Artist> artists = this.dao.getAllArtist();

		req.setAttribute("artists", artists);
		req.getRequestDispatcher("/WEB-INF/artistList.jsp").forward(req, resp);

	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String artistName = req.getParameter("name");
		String search = req.getParameter("search");
		if (artistName != null) {
			Artist add = new Artist(artistName);
			this.dao.addArtist(add);
			resp.sendRedirect("/list");
		} else if (search != null) {
			List<Artist> searchArtists = this.dao.searchArtist(search);
			List<Album> albums = this.albumDao.searchAlbum(search);
			req.setAttribute("albums", albums);
			req.setAttribute("artists", searchArtists);
			req.getRequestDispatcher("/WEB-INF/searchList.jsp").forward(req, resp);
		}
	}
}
