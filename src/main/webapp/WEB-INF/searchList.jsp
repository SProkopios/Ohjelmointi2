<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

</head>
<body>
	<h1>Albums</h1>
	<br>
	<ol>
		<c:forEach items="${ albums }" var="album">
			<li><a href="/albums?ArtistId=${ album.getArtistId() }"><c:out
						value="${ album.getName() }" /></a></li>
		</c:forEach>
	</ol>
	<h1>Artists</h1>
	<br>
	<ol>
		<c:forEach items="${ artists }" var="artist">
			<li><a href="/albums?ArtistId=${ artist.getId() }"><c:out
						value="${ artist.getName() }" /></a></li>
		</c:forEach>
	</ol>
</body>


</html>