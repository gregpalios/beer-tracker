<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!-- Author: Gregory Palios -->

<!DOCTYPE html>
<html>

<head>
	<title>Beer Tracker</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css" />
		
<!-- Taken from www.w3schools.com -->		
<style>
body {
	margin-left: 15px;
	margin-right: 15px;
	padding: 0px;
	font-family: 'Lato', sans-serif;
}

.overlay {
	height: 100%;
	width: 0;
	position: fixed;
	z-index: 1;
	top: 0;
	left: 0;
	background-color: rgb(0, 0, 0);
	background-color: rgba(0, 0, 0, 0.9);
	overflow-x: hidden;
	transition: 0.5s;
}

.overlay-content {
	position: relative;
	top: 25%;
	width: 100%;
	text-align: center;
	margin-top: 30px;
}

.overlay a {
	padding: 8px;
	text-decoration: none;
	font-size: 36px;
	color: #818181;
	display: block;
	transition: 0.3s;
}

.overlay a:hover, .overlay a:focus {
	color: #09c332;
}

.overlay .closebtn {
	position: absolute;
	top: 20px;
	right: 45px;
	font-size: 60px;
}

@media screen and (max-height: 450px) {
	.overlay a {
		font-size: 20px
	}
	.overlay .closebtn {
		font-size: 40px;
		top: 15px;
		right: 35px;
	}
}
</style>
</head>

<body>
	<div id="myNav" class="overlay">
		<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
		<div class="overlay-content">
			<a href="${pageContext.request.contextPath}/beers/list">Discover</a>
			<a href="${pageContext.request.contextPath}/ratings/showFormForAdd">Submit a Rating</a>
			<a href="${pageContext.request.contextPath}/ratings/list">My Ratings</a> 
			<a href="${pageContext.request.contextPath}/suggestions/form">Suggest a Beer</a> 
		</div>
	</div>

	<div id="wrapper">
		<div id="header">
			<h2>Beer Tracker</h2>
		</div>
	</div>
			<p>Gregory Palios</p>
			<p>Florida Tech</p>
			<p>CIS 5898 - Projects in Computer Information Systems</p>
			<p>For: Dr. David O. LeVan</p>
	
	<span style="font-size: 30px; cursor: pointer" onclick="openNav()">&#9776;
		Navigation</span>

	<script>
		function openNav() {
			document.getElementById("myNav").style.width = "100%";
		}

		function closeNav() {
			document.getElementById("myNav").style.width = "0%";
		}
	</script>
	
</body>

</html>