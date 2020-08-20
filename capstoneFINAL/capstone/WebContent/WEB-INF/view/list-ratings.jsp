<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!-- Author: Gregory Palios -->

<!DOCTYPE html>

<html>

<head>
	<title>Ratings</title>
	
	<!-- reference our style sheet -->
	
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Beer Ratings</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
			<!-- put new button: Add Rating -->
			
			<input type="button" value="Add Rating" 
				onclick="window.location.href='showFormForAdd'; return false"
				class="add-button"
			/>
		
			<!-- add html table -->
			<table>
				<tr>
					<th>Beer</th>
					<th>Rating</th>
					<th>Tasting Notes</th>
					<th>Date</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print ratings -->
				<c:forEach var="tempRating" items="${ratings}">
				
					<!-- construct an "update" link with Rating id -->
					<c:url var="updateLink" value="/ratings/showFormForUpdate">
						<c:param name="ratingId" value="${tempRating.id}" />
					</c:url>
					
					<!-- construct an "delete" link with rating id -->
					<c:url var="deleteLink" value="/ratings/delete">
						<c:param name="ratingId" value="${tempRating.id}" />
					</c:url>
					
					<tr>
						<td> ${tempRating.beer.beerName} </td>
						<td> ${tempRating.rating} </td>
						<td> ${tempRating.tastingNotes} </td>
						<td> ${tempRating.date} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
								onclick="if (!(confirm('Are you sure you want to delete this rating?'))) return false">Delete</a>
								<!-- note that onclick is a javascript feature to trigger a popup confirmation -->
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