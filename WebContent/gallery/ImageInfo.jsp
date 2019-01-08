<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<script type="text/javascript" src="js/jquery.js"></script>

</head>
<body>
	
<!-- show image details-->
	<div class="col-md-6 col-md-offset-3 row">
	 <div class="panel panel-default ">
	 <div class="panel-heading" align="center">
        <font size="6" style="font-weight: 500;">IMAGE INFORMATION</font>
     </div>
	 <div class="panel-body " align="center">
	 	
	 	<p>
	 	<font size="4" style="font-weight: 400;">
	 	<input type="hidden" name="gId" value="${gId}">
	 	ID: ${image.iId}<br><br>
	 	Title: ${image.title}<br><br>
	 	Link: ${image.link}<br><br>
	 	Artist: <a href="/EECS118-MINIP2/ShowAServlet?iId=${image.iId}">${image.name}</a> <br>
	 	<br>
	 	Year: ${image.year}<br><br>
	 	Type: ${image.type}<br><br>
	 	Width:  ${image.width}<br><br>
	 	Height:  ${image.height}<br><br>
	 	Location:  ${image.location}<br><br>
	 	Description:  ${image.des}<br><br>
	 	<input type="hidden" name="dId" value="${image.dId}">
	 	</font>
	 	</p>
	 	<img src="${image.link}" width="400px" height="400px"><br><br>
	 	<a class="btn btn-success" href="/EECS118-MINIP2/deleteImageServlet?iId=${image.iId}&gId=${gId}&dId=${image.dId}">Delete</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	 	
	 	
	 	
	  </div>  
	 </div>
	</div>
	

</body>
</html>