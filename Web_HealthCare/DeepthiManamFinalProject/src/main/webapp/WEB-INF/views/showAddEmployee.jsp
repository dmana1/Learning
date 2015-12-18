
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

<script src="resources/js/enterprise.js"></script>


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
			<h2>Add Employee</h2>
			<form id="addEmployee" action="addEmployee.htm">
				<div style ="color: red;" id = "error"><c:if test="${not empty errorMessage}">
				<p style="color: red">${errorMessage}</p>
			</c:if></div>
				

				<br> <b>Select Enterprise Type:</b> <select id="entType"
						name="enterpriseType">
						<option value="1">Hospital</option>
						<option value="2">Pharmacy</option>
					</select> <br><br> <b>Select Enterprise Name:</b><select id="ent"
						name="enterprise"></select> <br><br>


				<div class="row">
					<div class="col-md-2">
						<b>First Name:</b>
					</div>
					<div class="col-md-2">
						<input type="text" name="firstName"  id="firstName" value="" class="form-control"
							placeholder="First Name" required/>
					</div>

					<div class="col-md-2">
						<b>Last Name:</b>
					</div>
					<div class="col-md-2">
						<input type="text" name="lastName" id="lastName" value="" class="form-control"
							placeholder="Last Name" required/>
					</div>

				</div>
				<div class="row">
					<div class="col-md-2">
						<b> Email ID:</b>
					</div>
					<div class="col-md-2">
						<input type="email" name="emailId" value="" class="form-control"
							placeholder="emailId" required/>
					</div>

					<div class="col-md-2">
						<b>PhoneNumber: </b>
					</div>
					<div class="col-md-2">
						<input type="text" id="phoneNumber" name="phoneNumber" value="" class="form-control"
							placeholder="Phone Number" required />
					</div>

				</div>
				<div class="row">
					<div class="col-md-2">
						<b> Designation:</b>
					</div>
					<div class="col-md-2">
					<input type="text" name="designation" id="designation" value="" class="form-control"
							placeholder="Designation" required/>
					</div>

					<div class="col-md-2">
						<b>SSN: </b>
					</div>
					<div class="col-md-2">
						<input type="text" name="ssn" id="ssn" value="" class="form-control"
							placeholder="SSN" required/>
					</div>

				</div>
				<div class="row">
					<div class="col-md-2">
						<b> Date of Birth:</b>
					</div>
					<div class="col-md-2">
						<input type="date" name="dob" value="" class="form-control"
							 required/>
					</div>

					<div class="col-md-2">
						<b>Select Role:</b>
					</div>
					<div class="col-md-2">
						<select id="role" name="role" class="form-control"
							 required>
							<option value="2">doctor</option>
							<option value="3">pharmacist</option>
						</select>
					</div>

				</div>
				
				<div class="row">
					<div class="col-md-2">
						<b>UserName :</b>
					</div>
					<div class="col-md-2">
						<input type="text" name="username" id="username" value="" class="form-control"
							placeholder="UserName" required pattern="^.{4,10}$" title="Length of username must be between 4 and 10 "/>
					</div>

					<div class="col-md-2">
						<b>Password : </b>
					</div>
					<div class="col-md-2">
						<input type="text" name="password" value="" class="form-control"
							placeholder="Password" pattern="^.{4,10}$" title="Length of password must be between 4 and 10 " required/>
					</div>

				</div>


				<br>  
					
					
					
					<input type="submit" name="submit" value="Add Employee" class="btn btn-primary"/>

				

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
