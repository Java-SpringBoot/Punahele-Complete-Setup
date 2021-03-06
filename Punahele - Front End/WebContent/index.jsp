<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Punahele</title>
<script src="<c:url value="/resources/js/jquery-2.0.min.js" />"/></script>
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />">
<script src="<c:url value="/resources/js/bootstrap.min.js" />"/></script>
</head>
<body>
  <div class="container">
 <div class="row" style='background-color: black; color:white'>
    <h3 align="center" >The ultimate Product Price Comparison available</h3>
  </div>
  <div class="row" style='background-color: black; color:white'>
     <div class="col-sm-2">
      <nav class="navbar navbar-inverse">
       <div class="container-fluid">
         <div class="navbar-header">
            <a class="navbar-brand" href="http://localhost:8080/RumboJ">RumboJ.com</a>
         </div>  
       </div>
    </nav>
	 </div>
	 <div class="col-sm-8">
        <form class="navbar-form" role="search" action="search"  method="get">
		    <div class="input-group">       
                <input type="text" class="form-control" name="searchstring" placeholder="Search term..." style="width:400px">
				<div class="input-group-btn search-panel">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" style="width:200px">
                    	<span id="search_concept">Categories</span> <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" role="menu">
                      <li><a href="#contains">Mobile Phones</a></li>
                      <li><a href="#its_equal">Watches</a></li>
                      <li><a href="#greather_than">All</a></li>
                    </ul>
                </div>
                <span class="input-group-btn">
                    <button class="btn btn-default" type="submit" value="search">Search</button>
                </span>
            </div>
        </form>
    </div>
  </div>
  
  
  <div class="row">
	<nav class="navbar navbar-inverse">
       <div class="container">
         <ul class="nav navbar-nav">
            <li class="active"><a href="#">Mobile Phones</a></li>
            <li><a href="#">Watches</a></li>
            <li><a href="#">Fridges</a></li>
			<li><a href="#">Washing Machines</a></li>
         </ul>
       </div>
    </nav>
  </div>
    
  <div class="row">
  <c:if test="${not empty products}">
			<c:forEach var="product" items="${products}">
		     	<div class="col-md-4">
            		<img src="<c:url value="/resources/img/Nexus.jpg"/>"/>
					<a href="products/${product.get("title").getAsString().trim().replaceAll(" ","+")}">${product.get("title").getAsString()}</a>
					<ul>
				    	<li>${product.get("flipkartprice").getAsString()}</li>
				    	<li>${product.get("amazonprice").getAsString()}</li>
					</ul>
				</div>
			</c:forEach>
	</c:if>
	<c:if test="${empty products}">
            <img src="<c:url value="/resources/img/Deals.jpg"/>"/>
	</c:if>
  </div>  
  
  <div class="row-fluid" style='background-color: black; color:white'>
    <h3 align="center" style="font-size: 15px">Conditions of Use & SalePrivacy Notice Interest-Based Ads 2016-2017, Rumboj.com, Inc. or its affiliates</h3>
  </div>
   </div>
  </div>
</body>
</html>