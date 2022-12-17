Servletit:
	ArtistListServlet.java = Noutaa artistit etusivulle listattavaksi ja lisää artistin listaan. Noutaa myös kentistä arvot ja ohjaa seuraaville sivuille. 
	AlbumListServlet.java = Hakee artistin albumit ja vie ne sivulle listattavaksi.
DAO:
	AlbumDao.java = Tekee kyselyitä tietokannalle Albumi-taulusta ja palauttaa tulokset.
	ArtistDao.java = Tekee kyselyitä tietokannalle Artisti-taulusta ja palauttaa tulokset.
Rajapinnat:
	AlbumDaoInterface.java = Toimii Album-luokan rajapintana.
	ArtistDaoInterface.java = Toimii Artist-luokan rajapintana.
JSP-sivut:
	albumList.jsp = Sivulle listautuu artistin albumit
	artistList.jsp = Sivulle listautuu kaikki artistit ja nimet toimivat linkkeinä kyseisen artistin albumeihin.
	searchList.jsp = Sivulle listautuu etusivun haun tulokset artisteista ja albumeista.