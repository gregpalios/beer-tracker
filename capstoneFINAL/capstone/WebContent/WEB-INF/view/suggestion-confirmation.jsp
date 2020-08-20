<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!-- Author: Gregory Palios -->

<!DOCTYPE html>
<html>

<head>
	<title>Suggestion Confirmation</title>
	
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
			<h2>Thank you for your submission</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Your suggestion has been received. </h3>
		
		<br></br>
		
		We will review your submission and let you know if your beer 
			is selected to be added to our site.
		
		<br></br>
		
		<p>
			<a href="${pageContext.request.contextPath}/">Home</a>
		</p>
	</div>
</body>

</html>