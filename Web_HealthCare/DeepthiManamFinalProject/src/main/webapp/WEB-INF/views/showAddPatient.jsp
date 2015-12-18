
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
<script src="resources/js/addPatient.js"></script>


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
		<h3>Add Patient</h3>
		<form id="addPatient" action="addPatient.htm" method="post">

		<div style ="color: red;" id = "error"><c:if test="${not empty errorMessage}">
				<p style="color: red">${errorMessage}</p>
			</c:if></div>

				<div class="row">
					<div class="col-md-2">
						<b>First Name :</b>
					</div>
					<div class="col-md-2">
						<input type="text" id="firstName" name = "firstName" class="form-control"
							placeholder="Enter First Name" required />
					</div>
					
				</div>
				
				
				<div class="row">
					<div class="col-md-2">
						<b>Last Name :</b>
					</div>
					<div class="col-md-2">
						<input type="text" id="lastName"  name = "lastName" class="form-control"
							placeholder="Enter Last Name" required />
					</div>
				
				</div>
				
				<div class="row">
					<div class="col-md-2">
						<b> SSN :</b>
					</div>
					<div class="col-md-2">
						<input type="text" id="ssn" name = "ssn" class="form-control"
							placeholder="ssn" required/>
					</div>
					
				</div>
				
				<div class="row">
					<div class="col-md-2">
						<b>Date of Birth :</b>
							
					</div>
					<div class="col-md-2">
						<input type="date" id ="dob" name = "dob" class="form-control"
							placeholder="dob" required/>
					</div>
					
				</div>
				
				<div class="row">
					<div class="col-md-2">
					<b>Email ID:</b>
					</div>
					<div class="col-md-2">
					<input type="email" name = "emailId"  class="form-control"
							placeholder="emailId" required/>
					</div>
					
				</div>
				
				
				
				<div class="row">
					<div class="col-md-2">
					<b>Phone Number:</b>
					</div>
					<div class="col-md-2">
					<input type="text" id = "phoneNumber" name = "phoneNumber"  class="form-control"
							placeholder="phoneNumber" required/>
					</div>
					
				</div>
				<div class="row">
					<div class="col-md-2">
					<b>Address:</b>
					</div>
					<div class="col-md-4">
					<input type="text" id="address" name = "address"  class="form-control"
							placeholder="address" required/>
					</div>
					
				</div>
				
				<div class="row">
				<div class="col-md-4">
				<input type="submit" name="submit" value="Submit"
				class="btn btn-primary" /></div></div>
				
		
				

		</form>
		

		
		</section>
		
		<br><br><br><br>

		<section id="footer">
			<div class="navbar navbar-default ">
				<div class="navbar-header">
					<a class="navbar-brand" href="#"></a>
				</div>

			</div>
		</section>


	</div>

</body>
</html>
