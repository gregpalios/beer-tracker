<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!-- Author: Gregory Palios -->

<!DOCTYPE html>
<html>

<head>
	<title>Submit a Suggestion</title>
	
	<style>
		.error{color:red}
	</style>

	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css">
		
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Submit a Suggestion</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Submit a Suggestion</h3>
		<p>Have you tasted a delicious beer and want it added to the site? Let us know!</p>
		
		<form:form action="saveSuggestion" modelAttribute="suggestion" method="POST">
			<table>
				<tbody>
					<tr>
						<td><label>Beer</label></td>
						<td><form:input path="beer" placeholder="Required"/></td>
						<form:errors path="beer" cssClass="error" element="div" />
					</tr>
					
					<tr>
						<td><label>Brewery</label></td>
						<td><form:input path="brewery" /></td>
					</tr>
					
					<tr>
						<td><label>Your Email</label></td>
						<td><form:input path="email" placeholder="Required"/></td>
						<form:errors path="email" cssClass="error" element="div" />
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save"/></td>
					</tr>
					
				</tbody>
				
			</table>
		
		</form:form>
		
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/">Home</a>
		</p>
		
	</div>
	
</body>

</html>