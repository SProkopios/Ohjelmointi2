<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

</head>
<body>
	<h1>Search</h1>
	<form method="post">
		<input name="search" type="text" required
			placeholder="type artist or album here..." autofocus /> <input
			type="submit" value="Search" />
	</form>
	<br>
	<h1>Add artist</h1>
	<form method="post">
		<input name="name" type="text" required
			placeholder="type artist here..." autofocus /> <input type="submit"
			value="Add to list" />
	</form>
	<br>
	<h1>All artists</h1>
	<ol>
		<c:forEach items="${ artists }" var="artist">
			<li><a href="/albums?ArtistId=${ artist.getId() }"><c:out
						value="${ artist.getName() }" /></a></li>
		</c:forEach>
	</ol>
</body>


</html>