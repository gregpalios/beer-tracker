<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Author: Gregory Palios -->

<!DOCTYPE html>
<html>

<head>
<title>Save Rating</title>

<style>
.error {
	color: red
}
</style>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Beer Ratings</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Rating</h3>

		<form:form action="saveRating" modelAttribute="rating" method="POST">

			<!-- need to associate this data with rating id -->
			<form:hidden path="id" />

			<table>
				<tbody>
					<tr>
						<td><label>BeerId:</label></td>
						<td><form:input path="beer" /></td>
					</tr>

					<tr>
						<td><label>Rating:</label></td>
						<td><form:input path="rating"
								placeholder="Please enter a rating from 1-5" /></td>
						<form:errors path="rating" cssClass="error" element="div" />
					</tr>

					<tr>
						<td><label>Tasting Notes:</label></td>
						<td><form:input path="tastingNotes" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				</tbody>
				
			</table>

		</form:form>

		<div style=""></div>

		<p>
			<a href="${pageContext.request.contextPath}/ratings/list">Back to
				List</a>
		</p>

		<p>
			<a href="${pageContext.request.contextPath}/">Home</a>
		</p>
		
	</div>
	
</body>

</html>