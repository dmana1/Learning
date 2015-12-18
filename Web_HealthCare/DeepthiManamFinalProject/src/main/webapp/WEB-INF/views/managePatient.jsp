
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

		<section class="content1">
			<h2>Manage Patients</h2><br>
			<form action ="showAddPatient.htm">

				<table>

					<tr>
						<th>MRN</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>SSN</th>
						<th>DOB</th>
						<th>Email ID</th>
						<th>PhoneNumber</th>

					</tr>
					<c:forEach var="row" items="${requestScope.patientList}">
						<tr>
							<td><input type="text" readonly="readonly" name="patientId"
								value="${row.patientId}" /></td>
							<td><input type="text" readonly="readonly" name="firstName"
								value="${row.firstName}" /></td>
							<td><input type="text" readonly="readonly"
								name="lastName" value="${row.lastName}" /></td>
							<td><input type="text" readonly="readonly"
								name="lastName" value="${row.ssn}" /></td>
							<td><input type="text" readonly="readonly" name="dob"
								value="${row.dob}" /></td>
							<td><input type="text" readonly="readonly"
								name="emailId" value="${row.emailId}" /></td>
							<td><input type="text" readonly="readonly" name="phoneNumber"
								value="${row.phoneNumber}" /></td>
						
						</tr>

					</c:forEach>
				</table>
				<br><br>
				<div class="row">
					<div class="col-sm-4">
						<p></p>
					</div>
					<div class="col-sm-4">
						<input type="submit" name="submit" class="btn btn-info"
							value="Add Patient" />
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
