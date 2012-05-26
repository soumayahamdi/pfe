<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" %>
<!doctype html>
<html>
<head>
	<meta charset=utf-8>
	<title>Twitter</title>
	<style>
	body { width: 600px; margin: auto; }
	ul { list-style: none; }
	li { padding-bottom: 1em; }
	img { float: left; padding-right: 1em; }
	a { text-decoration: none; color: #333; }
	</style>
</head>
<body>
		
<ul id="biebster-tweets">
<c:forEach items="${ltweets}" var="tweet">

		<li id="twitt">
			<img id="image" src="${tweet.getProfileImageUrl()}" alt="${tweet.getFromUserId()}" >
			
			<p><a href="http://twitter.com/" >"${tweet.getText()}"</a></p>
		</li>
			</c:forEach>	
			
</ul>





</body>
</html>
