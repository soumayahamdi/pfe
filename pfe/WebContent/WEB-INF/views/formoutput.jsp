<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta name="viewport" content="initial-scale=1.0, user-scalable=no"/>
		<meta charset="UTF-8" />
			<style type="text/css">
			html {
				height: 100%
			}
			body {
				height: 100%;
				margin: 0;
				padding: 0
			}
			#EmplacementDeMaCarte {
				height: 100%		
			}
		</style>
		<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?sensor=false"></script>
		<script type="text/javascript">
	
		function initialisation(){
var centreCarte = new google.maps.LatLng(33.888658, 9.536133);
			
			var optionsCarte = {
				zoom: 2,
				center: centreCarte,
				mapTypeId: google.maps.MapTypeId.ROADMAP
			}
			
			var maCarte = new google.maps.Map(document.getElementById("EmplacementDeMaCarte"), optionsCarte);
		
			<c:forEach items="${tweets}" var="tweet">

		x="${tweet.text}";
		y="${tweet.longitude}";
		z="${tweet.altitude}";
		var marker1=new google.maps.LatLng(z,y);
		var optionsMarqueur1 = {
				position: marker1,
				map: maCarte,
				title: x
			}
		var marqueur1 = new google.maps.Marker(optionsMarqueur1);
		</c:forEach>				
		}
		google.maps.event.addDomListener(window, 'load', initialisation)
			</script>
	</head>
	<body>
		<div id="EmplacementDeMaCarte"></div>
	
	</body>
</html>