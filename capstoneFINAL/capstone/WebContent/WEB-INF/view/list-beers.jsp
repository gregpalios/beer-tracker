<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!-- Author: Gregory Palios -->

<!DOCTYPE html>

<html>

<head>
	<title>List Beers</title>
	
	<!-- reference our style sheet -->
	
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Beers</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
			<!--  add a search box -->
            <form:form action="search" method="GET">
                Search by beer: <input type="text" name="theSearchName" />
                
                <input type="submit" value="Search" class="add-button" />
            </form:form>
		
			<!-- add our html table here -->
			<table>
				<tr>
					<th>Beer</th>
					<th>Brewery</th>
					<th>Type</th>
					<th>ABV</th>
					<th>Details</th>
				</tr>
				
				<!-- loop over and print our beers -->
				<c:forEach var="tempBeer" items="${beers}">
				
				<!-- construct an "details" link with Beer id -->
					<c:url var="detailsLink" value="/beers/details">
						<c:param name="beerId" value="${tempBeer.beerId}" />
					</c:url>
					
					<tr>
						<td> ${tempBeer.beerName} </td>
						<td> ${tempBeer.brewery} </td>
						<td> ${tempBeer.type} </td>
						<td> ${tempBeer.abv} </td>
						<td>
							<!-- display the update link -->
							<a href="${detailsLink}">Details</a>
						</td>
					</tr>
					
				</c:forEach>
				
			</table>
			
		</div>
		
	</div>
	
		<p>
			<a href="${pageContext.request.contextPath}/">Home</a>
		</p>

</body>

</html>