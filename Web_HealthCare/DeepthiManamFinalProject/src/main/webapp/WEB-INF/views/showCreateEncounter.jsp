
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

<script src="resources/js/dosage.js"></script>

<link rel="stylesheet" type="text/css" href="resources/css/main.css">

<style>

#basicInfo{
	padding-left: 7px;
	padding-right: 7px;
	padding-bottom:5px;
	background-color: #99C2D6;
}

th{
	background-color: #99D6EB;
}
table, th, td {
	border: 1px solid black;
	padding: 1px;
}
</style>

<script src="resources/js/addEncounter.js"></script>


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

		<section class="content2">
		
		<form id = "addEncounter"  action="addEncounter.htm" method="post">
			<h4><b>Enter Encounter Details</b></h4>
			<div style ="color: red;" id = "error"><c:if test="${not empty errorMessage}">
				<p style="color: red">${errorMessage}</p>
			</c:if></div>
			
				<div class="row">
					<div class="col-md-2">
						<b>Respiratory Rate:</b>
					</div>
					<div class="col-md-2">
						<input type="text" id = "respiratoryRate" name = "respiratoryRate" class="form-control"
							placeholder="Respiratory Rate" required />
					</div>
					
					<div class="col-md-2">
						<b>Heart Rate:</b>
					</div>
					<div class="col-md-2">
						<input type="text" id = "heartRate" name = "heartRate" class="form-control"
							placeholder="Heart Rate" required />
					</div>
					
				</div>				
				
				
				
				<div class="row">
					<div class="col-md-2">
						<b>Weight:</b>
					</div>
					<div class="col-md-2">
						<input type="text" id = "weight" name = "weight" class="form-control"
							placeholder="Weight" required />
					</div>
					
					<div class="col-md-2">
						<b>Blood Pressure:</b>
					</div>
					<div class="col-md-2">
						<input type="text" id = "bloodPressure"  name = "bloodPressure" class="form-control"
							placeholder="Blood Pressure" required />
					</div>
				
				</div>
				
			<h4><b>Medication Details:</b></h4>
			
			
				
				<div class="row">
					<div class="col-md-2">
						<b>Preferred Pharmacy :</b>
					</div>
					
					<div class="col-md-2">
						<select  name="selectedPharmacy">

							<c:forEach var="row" items="${pharmaciesList}">

								<option value="${row.enterpriseId}">${row.name}</option>

							</c:forEach>

						</select>

					</div>
					
					
				</div>
				
				<div class="row">
					
					<div class="col-md-2">
						<b>Select Drug :</b>
							
					</div>
					
					<div class="col-md-2">
						<select id = "selectedDrug" name="selectedDrug">

							<c:forEach var="row" items="${drugList}">

								<option value="${row.drugId}">${row.name}</option>

							</c:forEach>

						</select>

					</div>
					
					<div class="col-md-2">
					<b>Dosage:</b>
					</div>
					<div class="col-md-2">
					<input type="number" id = "dosage" name = "dosage"  class="form-control"
							 min="1" max="20" required/>
					</div>
					
					
					
					
					<div class="col-md-2">
					<input type="button" id = "addDosage"  class="btn btn-warning"
							value = "AddDosage" />
					</div>
					
				</div>
				
				
				
				
				<div>
				<table id = "medication">
				<tr><th> Drug Id</th>
				<th>  Name</th>				
				<th> Usage Directions</th>
				<th> Dosage</th></tr>				
				</table>
				
				
				</div>
				<br>
				
				<div class="row">
						<div class="col-md-2">
						<b>Problem:</b>
					</div>
					
					<div class="col-md-2">
					<input type="text" id = "problem" name = "problem"  class="form-control"
							placeholder="problem" required/>
					</div>
					<div class="col-md-2">
						<b>Advice:</b>
					</div>
					
					<div class="col-md-2">
					<input type="text" id = "description" name = "description"  class="form-control"
							placeholder="Advice" required/>
					</div>
					
					
				</div>
				
							
				
				
				<div class="row">
				<div class="col-md-4">
				<input type="submit" name="submit" value="Submit"
				class="btn btn-primary" /></div></div>
				
		
				

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
