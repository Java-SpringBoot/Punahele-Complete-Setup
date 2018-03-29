<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Punahele</title>
<script src="<c:url value="/resources/js/jquery-2.0.min.js" />" /></script>
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css" />">
<link rel="stylesheet"
	href="<c:url value="/resources/css/custom.css" />">
<script src="<c:url value="/resources/js/bootstrap.min.js" />" /></script>
</head>
<body>
	<div class="container">
		<div class="row" style='background-color: white; color: white'>
			<div class="col-sm-1">
				<div class="container-fluid">
					<div class="navbar-header">
						<a href="#" class="pull-left"><img
							src="<c:url value="/resources/img/punahele.png"/>"></a>
					</div>
				</div>
			</div>
			<div class="col-sm-8">
				<form class="navbar-form" role="search" action="search" method="get">
					<div class="input-group">
						<input type="text" class="form-control" name="searchstring"
							placeholder="Search term..." style="width: 600px">
						<div class="input-group-btn search-panel"></div>
						<span class="input-group-btn">
							<button class="btn btn-default" type="submit" value="search">Search</button>
						</span>
					</div>
				</form>
			</div>
			<div class="col-sm-3">
			<div class="row">
				<div class="col-sm-4">
					<a href="#">Upload</a>
				</div>
				<div class="col-sm-4">
					<a href="#">Settings</a>
				</div>
				<div class="col-sm-4">
					<a href="#">Sign in</a>
				</div>
			</div>
			</div>
		</div>
		<div class="container-fluid"
			style="background-color: hsl(0, 15%, 91%); border: 1px solid hsl(0, 96%, 1%);">
			<div class="row text-grey"
				style="border: 10px solid hsl(0, 15%, 91%);">
				<div class="col-sm-4" style="border: 10px solid hsl(0, 15%, 91%);">
					<img class="img-responsive"
						src="<c:url value="/resources/img/thumbnail.jpg"/>"> <span>Tamil
						Rockers</span><br> <span>21K Views</span>
				</div>
				<div class="col-sm-4" style="border: 10px solid hsl(0, 15%, 91%);">
					<img class="img-responsive"
						src="<c:url value="/resources/img/thumbnail.jpg"/>"> <span>Tamil
						Rockers</span><br> <span>21K Views</span>
				</div>
				<div class="col-sm-4" style="border: 10px solid hsl(0, 15%, 91%);">
					<img class="img-responsive"
						src="<c:url value="/resources/img/thumbnail.jpg"/>"> <span>Tamil
						Rockers</span><br> <span>21K Views</span>
				</div>
			</div>
		</div>
</body>
</html>