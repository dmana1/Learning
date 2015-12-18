<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<style>
table, th, td {
	border: 1px solid black;
	padding: 10px;
}
</style>
<!--  For BootStrap -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	


<!--  end of BootStrap -->


<link rel="stylesheet" type="text/css" href="resources/css/main.css">
<style>
th{
	background-color: #99D6EB;
}
</style>
</head>
<body>
<div class="container">
		<section class="navs">
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
  				<div class="container-fluid">
    				<!-- Brand and toggle get grouped for better mobile display -->
    				<div class="navbar-header">
      					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					        <span class="sr-only">Toggle navigation</span>
					        <span class="icon-bar"></span>
					        <span class="icon-bar"></span>
					        <span class="icon-bar"></span>
	      				</button>
	      				<a class="navbar-brand logo" href="#">
	      					<span><i class="fa fa-stethoscope"></i></span>
	      					HealthCare
	      				</a>
	    			</div>
		
		    	
				   	<!-- Collect the nav links, forms, and other content for toggling -->
					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav navbar-right">
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="#">Enterprise<span
									class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="viewEnterprise.htm">Manage Enterprise</a></li>
									<li><a href="showAddEnterprise.htm">Add Enterprise</a></li>
								</ul></li>

							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="#">Employee<span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="manageEmployee.htm">Manage Employee</a></li>
								</ul></li>
								
								
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="#">Resumes<span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="viewResume.htm">View Resume</a></li>
								</ul></li>

							<li><a href="logout.htm">Logout</a></li>

						</ul>
					</div>
					<!-- navbar-collapse -->
				   
				</div><!-- container-fluid -->
			</nav>
			</section>
			<br><br><br><br>
			
			<section id = "content">
			<form>
	
	
			<h2> <b>List of Resumes</b> </h2><br>
			<table>

					<tr>
						<th>Resume Name</th>
						<th>Download Link</th>
					</tr>
					<c:forEach var="row" items="${requestScope.resumeList}">
						<tr>
							<td><input type="text" readonly="readonly" name="Name"
								value="${row.name}" /></td>
							<td><a target="_blank" href="/care/downloadResume.htm?fullPath=${row.path}&name=${row.name}">Download</a></td>
					</tr>

					</c:forEach>
				</table>

	</form>
	</section>
	<div class="navbar navbar-default navbar-fixed-bottom">
		<div class="navbar-header">
			<a class="navbar-brand" href="#"></a>
		</div>
	</div>
	</div>


</body>
</html>
