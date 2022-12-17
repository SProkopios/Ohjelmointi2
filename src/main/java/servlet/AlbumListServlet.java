package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.AlbumDao;
import model.Album;

@WebServlet("/albums")
public class AlbumListServlet extends HttpServlet {

	private AlbumDao dao = new AlbumDao();

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String ArtistId = req.getParameter("ArtistId");

		List<Album> albums = this.dao.getAllAlbum(ArtistId);

		req.setAttribute("albums", albums);
		req.getRequestDispatcher("/WEB-INF/albumList.jsp").forward(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

	}
}