<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="model.Artist" %>
<%@page import="model.Image" %>
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
<%
		ArtistDao dao = new ArtistDao();
		List<Artist> list = dao.showAll();
		request.setAttribute("list", list);
%>

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
                    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp ARTIST SEARCH <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a  href="SearchArtist.jsp">country</a></li>
				    <li><a  href="SearchArtist.jsp">birth_year</a></li>
                </ul>
            </li>
            
            
        </ul>
          
    </div>
   
    </div>
</nav>
<br><br><br><br>

<div class="col-md-11 col-md-offset-1">
	 <div class="panel panel-default ">
	  <div class="panel-body col-md-7">
	  <div class="row">
	   <form action="/EECS118-MINIP2/SearchIByArtist" method="post" >
            <div class="col-lg-6">
                <div class="input-group">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="submit">search</button>
                    </span>
                    <select class="form-control" name="aId" width="70px" height="40px">
				        <option value="${image.aId}" ><font size="2">===SELECT ONE===</font></option>
				        <c:forEach items="${list}" var="item">
				            <option value="${item.aId}">${item.name}</option>
				        </c:forEach>
					</select>
                </div>
            </div>
         </form>
         
         <form action="/EECS118-MINIP2/SearchIByYear" method="post">
            <div class="col-lg-6 ">
                <div class="input-group">
                    <input type="text" name="year1" class="form-control" placeholder="start">
                    <input type="text" name="year2" class="form-control" placeholder="end">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="submit" >search</button>
                    </span>
                </div>
            </div>
          </form>
          <br> <br> <br> <br>
          <form action="/EECS118-MINIP2/SearchIByLocation" method="post">
            <div class="col-lg-6">
                <div class="input-group">
                    <input type="text" name="location" class="form-control" placeholder="Location">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="submit" >search</button>
                    </span>
                </div>
            </div>
          </form>
          
          <form action="/EECS118-MINIP2/SearchIByType" method="post">
            <div class="col-lg-6">
                <div class="input-group">
                    <input type="text" name="type" class="form-control" placeholder="Type">
                    <span class="input-group-btn">
                        <button class="btn btn-default" type="submit" >search</button>
                    </span>
                </div>
            </div>
          </form>
          
          
        </div>
	  
	  
	  
	  
	  </div>
	</div>
</div>

<div class="col-md-11 col-md-offset-1">
	<table class="table table-striped">
	  <thead>
	    <tr>
	      <th>IMAGE_ID</th>
	      <th>TITLE</th>
	      <th>LINK</th>
	      <th>VIEW</th>
	      <th>MODIFY</th>
	      
	    </tr>
	    <c:forEach items="${ilist}" var="item">
			<tr>
				<td>${item.iId}</td>
				<td>${item.title}</td>
				<td>${item.link}</td>
				<td><a class="btn btn-success" href="/EECS118-MINIP2/ShowImageDetail?iId=${item.iId}&gId=${item.gId}">View</a></td>
				<td><a class="btn btn-success" href="/EECS118-MINIP2/UpdateIServlet?iId=${item.iId}&gId=${item.gId}">Modify</a></td>
			</tr>
		</c:forEach>
	  </thead>
	</table>
	</div>


</body>
</html>