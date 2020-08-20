<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!-- Author: Gregory Palios -->

<!DOCTYPE html>

<html>

<head>
	<title>${beer.beerName}</title>
	
	<!-- reference style sheet -->
	
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>${beer.beerName}</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
		<form:form action="getBeer" modelAttribute="beer" method="GET">
		
			<!-- need to associate this data with beer id -->
				<form:hidden path="beerId" />
		
		<br><br>
		Brewery: ${beer.brewery}
		<br><br>
		Type: ${beer.type}
		<br><br>
		ABV: ${beer.abv}
		<br><br>
		Serving Temperature: ${beer.servingTemperature}
		<br><br>
		First Brewed: ${beer.firstBrewed}
		<br><br>
		Country of Origin: ${beer.country}
		<br><br>
		${beer.history}

		</form:form>
			
		</div>
		
	</div>
	<p>
		<a href="${pageContext.request.contextPath}/beers/list">Beers</a>
	</p>

</body>

</html>