<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="model.Artist" %>
<%@page import="dao.ArtistDao" %>
<%@page import="java.util.*" %>
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
	
	<%
	    String errorInfo = (String)request.getAttribute("uploadError");         
	    if(errorInfo != null) {
	%>
	    <script type="text/javascript" language="javascript">
	        alert("<%=errorInfo%>");                                                                   
	    </script>   
	<%
	    }
	%>
<script type="text/javascript">
function preview(obj){
	var file = obj.files[0];
	var reader = new FileReader();
	reader.onloadstart = function (e) {
        console.log("start....");
    }
    reader.onprogress = function (e) {
        console.log("loading....");
    }
    reader.onabort = function (e) {
        console.log("stop....");
    }
    reader.onerror = function (e) {
        console.log("error....");
    }
    reader.onload = function (e) {
        console.log("success....");
        var img = document.getElementById("image");
        img.src = this.result;
    }
    reader.readAsDataURL(file);
}
</script>
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
<br><br><br><br>
<div class="container container-fluid">
<div class="col-md-6 col-md-offset-3 ">
<div class="panel panel-default">
	 <div class="panel-heading" align="center">
        <font size="6" style="font-weight: 500;">IMAGE INFORMATION</font>
     </div>
	  <div class="panel-body" align="center">
	 	
		
		<form action="/EECS118-MINIP2/AddIServlet" method="post" enctype="multipart/form-data">
		<input type="hidden" name="gId" value="<%=request.getParameter("gId") %>">
	 	<font size="4" style="font-weight: 400;">
	 	Title:<input type="text" name="title"><br><br>
	 	Artist:
	 	<select name="aId">
        <option value="0">===please choice===</option>
        <c:forEach items="${list}" var="item">
            <option value="${item.aId}">${item.name}</option>
        </c:forEach>
    	</select><br><br>
	 	
	 	Year:<input type="text" name="year"><br><br>
	 	Type:<input type="text" name="type"><br><br>
	 	Width:<input type="text" name="width"><br><br>
	 	Height:<input type="text" name="height"><br><br>
	 	Location:<input type="text" name="location"><br><br>
	 	Description:<input type="text" name="description"><br><br>
	 	
	 	
	 	LINK:<input type="file" id ="fileupload" onchange="preview(this)" name="link" accept ="image/*"><br><br>
	 	
	 	<img id="image" width="500px" height="500px"><br><br>
	 	
	 	
		<button class="btn btn-success" type="submit">SUBMIT</button>
		</font>
		
	 	</form>
	 
	 	</div>
	 	
	  </div>
</div>
</div>
</body>
</html>