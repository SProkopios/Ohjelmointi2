<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

</head>
<body>
	<h1>albums</h1>
	<br>
	<ol>
		<c:forEach items="${ albums }" var="album">
			<li><a><c:out value="${ album.getName() }" /></a></li>
		</c:forEach>
	</ol>
</body>


</html>