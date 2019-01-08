<%@ page language="java" import ="java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="model.Gallery" %>
    <%@page import="dao.GalleryDao" %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="gallery/image.css">
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<script type="text/javascript" src="js/jquery.js"></script>

</head>
<body>

<div>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container-fluid">
   
    <div class="navbar-header">
        <a class="navbar-brand" >Gallery &nbsp&nbsp&nbsp&nbsp&nbsp</a>
    </div>
    
    <div>
        <ul class="nav navbar-nav">
        
        	<li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown">
                    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp Create <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="gallery/insertGallery.jsp">Gallery</a></li>
                    <li><a href="gallery/insertArtist.jsp">Artist</a></li>
                </ul>
            </li>
            
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown">
                    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp ARTIST SEARCH <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a  href="gallery/SearchArtist.jsp">country</a></li>
				    <li><a  href="gallery/SearchArtist.jsp">birth_year</a></li>
                </ul>
            </li>
            
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown">
                    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp IMAGE SEARCH <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                	
                    <li><a  href="gallery/SearchImage.jsp">type</a></li>
				    <li><a  href="gallery/SearchImage.jsp">artist</a></li>
				    <li><a  href="gallery/SearchImage.jsp">location</a></li>
				    <li><a  href="gallery/SearchImage.jsp">year</a></li>
				    
                </ul>
            </li>
            
            
        </ul>
          
    </div>
   
    </div>
</nav>
<!-- gallery table -->
<br><br><br><br>


<div id="main-content">
	<div class="container">
		<div class="box">
			<c:forEach items="${list}" var="item">
			<div class="col-sm-6 col-md-4">
			<div class="media-box">
			<img src="${item.imgLink}" class="img-zi">
			</div>
				<div class="content-box">
				<font size="4">
				GALLERY_ID:&nbsp&nbsp${item.gId}<br>
				NAME:&nbsp&nbsp${item.name}<br>
	      		DESCRIPTION:&nbsp&nbsp${item.gDes}<br>
	      		</font>
	      		<a class="btn btn-success" href="/EECS118-MINIP2/UpdateGServlet?gId=${item.gId}">Modify</a>
				<a class="btn btn-success" href="/EECS118-MINIP2/ViewGServlet?gId=${item.gId}">View</a>
				</div>
			</div>
			</c:forEach>
		</div>
	</div>
</div>




<!--  
<table class="table table-striped" id="gallery">
  <thead>
    <tr>
      <th>ID</th>
      <th>NAME</th>
      <th>DESCRIPTION</th>
      <th>MODIFY</th>
      <th>VIEW</th>
    </tr>
    <c:forEach items="${list}" var="item">
	<tr>
		<td>${item.gId}</td>
		<td>${item.name}</td>
		<td>${item.gDes}</td>
		<td><a class="btn btn-success" href="/EECS118-MINIP2/UpdateGServlet?gId=${item.gId}">Modify</a></td>
		<td><a class="btn btn-success" href="/EECS118-MINIP2/ViewGServlet?gId=${item.gId}">View</a></td>
	</tr>
	</c:forEach>
  </thead>
</table>
-->	

</div>


</body>
</html>