<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@page import="model.Artist" %>
<%@page import="model.Artist" %>

<%@page import="dao.ImageDao" %>
<%@page import="dao.ArtistDao" %>

<%@page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


</head>

<body>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container-fluid">
   
    <div class="navbar-header">
        <a href="/EECS118-MINIP2/ShowGServlet" class="navbar-brand" >Gallery &nbsp&nbsp&nbsp&nbsp&nbsp</a>
    </div>
    
    <div>
        <ul class="nav navbar-nav">
        
        	<li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown">
                    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp Create <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="insertGallery.jsp">Gallery</a></li>
                    <li><a href="insertArtist.jsp">Artist</a></li>
                </ul>
            </li>
            
            
            
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown">
                    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp IMAGE SEARCH <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                	
                    <li><a  href="SearchImage.jsp">type</a></li>
				    <li><a  href="SearchImage.jsp">artist</a></li>
				    <li><a  href="SearchImage.jsp">location</a></li>
				    <li><a  href="SearchImage.jsp">year</a></li>
				    
                </ul>
            </li>
            
            
        </ul>
          
    </div>
   
    </div>
</nav>

<br><br><br>
	  <div class="col-md-11 col-md-offset-1">
	   <div class="row">
	   <form action="/EECS118-MINIP2/SearchAByBirth" method="post">
            <div class="col-lg-6">
                <div class="input-group">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="submit">search</button>
                    </span>
                    <input type="text" name="birth" class="form-control" placeholder="BIRTH_YEAR">
                </div>
            </div>
         </form>
         
         <form action="/EECS118-MINIP2/SearchAByCountry" method="post">
            <div class="col-lg-6">
                <div class="input-group">
                    <input type="text" name="country" class="form-control" placeholder="COUNTRY">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="submit" >search</button>
                    </span>
                </div>
            </div>
          </form>
        </div>
	  
	  
<br><br><br>
	<div class="col-md-11">
	<table class="table table-striped">
	  <thead>
	    <tr>
	      <th>Artist_ID</th>
	      <th>Name</th>
	      <th>Birth</th>
	      <th>Country</th>
	      <th>Description</th>
	      
	      
	    </tr>
	    <c:forEach items="${list}" var="item">
			<tr>
				<td>${item.aId}</td>
				<td>${item.name}</td>
				<td>${item.birth}</td>
				<td>${item.country}</td>
				<td>${item.aDes}</td>
				</tr>
		</c:forEach>
	  </thead>
	</table>
	</div>
	</div>
</body>
</html>