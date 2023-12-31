<%@page import="com.SportyShoes.web.entity.Shoes"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Purchases</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>

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
		<h5>Purchase Report</h5><br>
		Filter by Purchase Date:
		<a href="report?pcdate=today">Today</a>
		<a href="report?pcdate=week">Last Week</a>
		<a href="report?pcdate=month">Last Month</a>
		<a href="report">All</a><br>
		Filter by Purchase Status:
		<a href="report?status=paid">Paid</a>
		<a href="report?status=sent">Sent</a>
		<a href="report?status=delivered">Delivered</a>
		<a href="report">All</a>
	</div><br>
	<div align="center">
        <table class="table" border="1" cellpadding="5">
            <tr>
                <th>Purchase ID</th>
                <th>Purchase Date</th>
                <th>Purchase Status</th>
                <th>User ID</th>
                <th>Products Purchased IDs</th>
                <th>Total Price</th>
            </tr>
            <c:forEach items="${purchaseList}" var="purchase">
				<tr>
					<td>${purchase.pcid}</td>
					<td>${purchase.pcdate}</td>
					<td>${purchase.status}</td>
					<td>${purchase.pcemail}</td>
					<td>
						<c:forEach items="${purchase.shoes}" var="shoes">
							${shoes.pid}<br>
						</c:forEach>
					</td>
					<td>${purchase.totalprice}</td>
				</tr>
			</c:forEach>
        </table>
    </div>
	<%
	}
	%>
</body>
</html>