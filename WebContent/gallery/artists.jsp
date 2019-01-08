<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
        <a href="ShowGServlet" class="navbar-brand" >Gallery &nbsp&nbsp&nbsp&nbsp&nbsp</a>
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
<br><br><br><br><br>
<div class="container container-fluid">
<div class="panel panel-default">
<div class="panel-heading" align="center">
     <font size="6" style="font-weight: 500;">ARTITS INFORMATION</font>
</div>
	  <div class="panel-body" align="center">
	  
	 	<div class="col-md-8 col-md-offset-1 ">
		 	<p>
		 	<font size="4" style="font-weight: 400;">

		 	<input type="hidden" name = "iId" value="${iId}">
		 	ID: ${a.aId }<br><br>
		 	NAME:${a.name}<br><br>
		 	BIRTH_YEAR:${a.birth}<br><br>
		 	COUNTRY:${a.country}<br><br>
		 	DESCRIPTION:${a.aDes}<br><br>
		 	</font>
		 	</p>
		 	<a class="btn btn-success" href="/EECS118-MINIP2/UpdateAServlet?aId=${a.aId}&iId=${iId}">Modify</a>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	 	</div>
	
	  </div>
</div>
</div>
</body>
</html>