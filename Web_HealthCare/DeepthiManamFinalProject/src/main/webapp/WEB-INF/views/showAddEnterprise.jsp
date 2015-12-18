
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
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
<script src="resources/js/addEnterprise.js"></script>

</head>
<body>
	<div class="container">
		<section class="navs">
			<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
				<div class="container-fluid">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse"
							data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand logo" href="#"> <span><i
								class="fa fa-stethoscope"></i></span> HealthCare
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
				</div>
				<!-- container-fluid -->
			</nav>
		</section>

	<section class="content2">
		<h2>Add Enterprise:</h2><br>
		<form id="addEnterprise" action="addEnterprise.htm">
		<div style ="color: red;" id = "error"><c:if test="${not empty errorMessage}">
				<p style="color: red">${errorMessage}</p>
			</c:if></div>
		

				<div class="row">
					<div class="col-md-2">
						<b>Enterprise Name:</b>
					</div>
					<div class="col-md-2">
						<input type="text" id ="enterpriseName" name="enterpriseName" value=""
							class="form-control" required="required"
							placeholder="Enter enterprise" />
					</div>

				</div>
				<br>
				<div class="row">
					<div class="col-md-2">
						<b>EnterPrise Type:</b>
					</div>
					<div class="col-md-2">
						<select name="enterpriseType" required="required"
							class="form-control">
							<option value="1">Hospital</option>
							<option value="2">Pharmacy</option>
						</select>
					</div>

				</div>
				<br>
				<div class="row">
					<div class="col-md-1">
						<p></p>
					</div>
					<div class="col-md-4">
						<input type="submit" name="Add Enterprise"
				value="Add Enterprise" class="btn btn-primary"/>
					</div>
				</div>



				
		</form>
	</section>
	
	<section id="footer">
			<div class="navbar navbar-default navbar-fixed-bottom">
				<div class="navbar-header">
					<a class="navbar-brand" href="#"></a>
				</div>

			</div>
		</section>
		
		</div>
		
		
	
	
</body>
</html>
