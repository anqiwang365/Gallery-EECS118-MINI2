<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="model.Artist" %>
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

<script type="text/javascript" src="js/jquery.js"></script>

</head>
<%
		ArtistDao dao = new ArtistDao();
		List<Artist> list = dao.showAll();
		request.setAttribute("list", list);
%>
<%! %>
<script type="text/javascript">
function preview(obj){
	
	var file = obj.files[0];
	if(file==null){
		var file = new File("${image.link}");
	}
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
        var img = document.getElementById("tempImage");
        img.src = this.result;
    }
    reader.readAsDataURL(file);
}
</script>
<body>
	
<!-- show image details-->
	<div class="col-md-6 col-md-offset-3">
	 <div class="panel panel-default">
	 <div class="panel-heading" align="center">
        <font size="6" style="font-weight: 500;">MODIFY IMAGE</font>
     </div>
	  <div class="panel-body" align="center">
	 	<form action="UpdateIServlet?oldlink=${image.link}" method="post" enctype="multipart/form-data">
	 	<p>
	 	<font size="4" style="font-weight: 400;">
	 	<br>
	 	<input type="hidden" name="gId" value="${gId}">
	 	ID:&nbsp&nbsp<input type="text" name = "iId" value="${iId}" readonly = "readonly"><br><br>
	 	Title:&nbsp&nbsp<input type="text" name="title" value="${image.title}"> <br><br>
	 	Artist:<br><br>
	 	<select name="aId">
        <option value="${image.aId}" >===please choice===</option>
        <c:forEach items="${list}" var="item">
            <option value="${item.aId}">${item.name}</option>
        </c:forEach>
    	</select><br><br>
    	
	 	
	 	Year:&nbsp&nbsp<input type="text" name="year" value="${detail.year}"><br><br>
	 	Type:&nbsp&nbsp<input type="text" name="itype" value="${detail.type}"><br><br>
	 	Width:&nbsp&nbsp<input type="text" name="width" value="${detail.width}"><br><br>
	 	Height:&nbsp&nbsp<input type="text" name="height" value="${detail.height}"><br><br>
	 	Location:&nbsp&nbsp<input type="text" name="location" value="${detail.location}"><br><br>
	 	Description:&nbsp&nbsp<input type="text" name="des" value="${detail.des}"><br><br>
	 	
	 	
	 	
	 	Link:<input type="file" name="link"  onchange="preview(this)" accept="image/*"><br><br>
	 	<input type="hidden" name ="oldlink" value="${image.link}">
	 	

	 	
	 	<img id="tempImage" src="${image.link}" width="500px" height="500px">
	 	
	 	
	 	<input type="hidden" name="iId" value="${image.iId}">
	 	</font>
	 	</p>
	 	<button type="submit" class="btn btn-success" >Modify</button>
	 	</form>
	  </div>
	 </div>
	</div>
</body>
</html>