<%@page import="com.SportyShoes.web.entity.Shoes"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	></script>

</head>
<body>
	<!--  Java inside HTML 
 -->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">SS</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="index">Home</a></li>
					<%
					String id = (String) session.getAttribute("id");
					if (id == null) {
					%>
					<li class="nav-item"><a class="nav-link" href="login">Login</a>
					</li>
					<%
					}
					else if (id.equals("admin")) {
					%>
					<li class="nav-item"><a class="nav-link" href="shoes">View Shoes</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="users">View Users</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="report">Purchase Report</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="logout">Logout</a>
					</li>
					<%
					}
					%>
				</ul>
			</div>
		</div>
	</nav>
	<%
	if (id == null) {
	%>
	<h1>Welcome on Sporty Shoes administrative portal</h1>
	<h5>Please log in to make any changes</h5>
	<%
	} else if (id.equals("admin")) {
	%>
	<div align="center" class="container">
		<h5>Products</h5>
	</div>
	<a class="nav-link" href="addShoes">ADD A NEW SHOES</a><br>
	<div align="center">
        <table class="table" border="1">
            <tr>
                <th>Product ID</th>
                <th>Product Name</th>
                <th>Price</th>
                <th>Sport</th>
                <th>Sex</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            
            <c:forEach items="${shoesList}" var="shoes">
              	<tr>
					<td>${shoes.pid}</td>
					<td>${shoes.name}</td>
					<td>${shoes.price}</td>
					<td>${shoes.sport}</td>
					<td>${shoes.sex}</td>
					<td><a href="editShoes?pid=${ shoes.pid}">Edit</a> </td>
					<td><a href="deleteShoes?pid=${ shoes.pid}">Delete</a> </td>
				</tr>
			</c:forEach>
            
            
        </table>
    </div>
	<%
	}
	%>
</body>
</html>