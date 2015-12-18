
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
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
<style>

table, th, td {
	border: 1px solid black;
	padding: 1px;
}

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
						<li><a href="doctorHome.htm">Home</a></li>
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="#">Patient<span
									class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="managePatient.htm">Manage Patient</a></li>
									<li><a href="showSearchPatient.htm">Search Patient</a></li>
								</ul></li>

							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="#">Message<span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="showMessages.htm">Message Patient</a></li>
								</ul></li>

							<li><a href="logout.htm">Logout</a></li>

						</ul>
					</div>
					<!-- navbar-collapse -->
				</div>
				<!-- container-fluid -->
			</nav>
		</section>

		<section class="content">
		<form action="">
		<table>

			<tr>
				<th>MRN</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>SSN</th>
				<th>Date of Birth</th>
				<th>View Profile</th>

			</tr>
		<c:forEach var="row" items="${requestScope.patientList}">
			<tr>
				<td>${row.patientId}</td>
				<td>${row.firstName}</td>
				<td>${row.lastName}</td>
				<td>${row.ssn}</td>
				<td>${row.dob}</td>				
				<td><a href="searchById.htm?patientId=${row.patientId}">View Profile</a></td>
			</tr>
			
		</c:forEach>		
		</table>
		
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
