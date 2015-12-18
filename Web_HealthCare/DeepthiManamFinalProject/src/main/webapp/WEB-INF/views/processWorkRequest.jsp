
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
table, th, td {
	border: 1px solid black;
	padding: 1px;
}
#basicInfo{
	padding-left: 7px;
	padding-right: 7px;
	padding-bottom:5px;
	background-color: #99C2D6;
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
						<li><a href="pharmaHome.htm">Home</a></li>
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="#">Prescription WorkRequest<span
									class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="manageWorkRequest.htm">Manage WorkRequest</a></li>
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
			
			<h2>Process WorkRequest</h2><br>

			<div id="basicInfo">
				<table>
					<tr>
						<td id="basicInfo"><b>MRN: </b></td>
						<td id="basicInfo">${patient.patientId}</td>
						<td id="basicInfo"><b>First Name: </b></td>
						<td id="basicInfo">${patient.firstName}</td>
						<td id="basicInfo"><b> Last Name: </b></td>
						<td id="basicInfo">${patient.lastName}</td>
						<td id="basicInfo"><b>SSN: </b></td>
						<td id="basicInfo">${patient.ssn}</td>
						<td id="basicInfo"><b>DOB: </b></td>
						<td id="basicInfo">${patient.dob}</td>
						<td id="basicInfo"><b>Email Id: </b></td>
						<td id="basicInfo">${patient.emailId}</td>
						<td id="basicInfo"><b>PhoneNumber: </b></td>
						<td id="basicInfo">${patient.phoneNumber}</td>

					</tr>


				</table>
			</div>
			
			<br><br>
			<form action ="completeWorkRequest.htm">
				<table>

					<tr>
						<th>MedicationID</th>
						<th>Date</th>
						<th>DrugId</th>
						<th>Dosage</th>						
						
					</tr>
					<c:forEach var="row" items="${requestScope.medicationList}">
						<tr>
							<td><input type="text" readonly="readonly" name="medicationId"
								value="${row.medicationId}" /></td>
								<td><input type="text" readonly="readonly" name="createdOn"
								value="${row.createdOn}" /></td>
							<td><input type="text" readonly="readonly" name="drugId"
								value="${row.drug.drugId}" /></td>
							<td><input type="text" readonly="readonly"
								name="dosage" value="${row.dosage}" /></td>														
						</tr>
					</c:forEach>
				</table>
				<br><br>
				<input type = "hidden" name ="workRequestString" value="${requestScope.workRequestString}"/>
			
				<div class="row">
					<div class="col-sm-2">
						<p></p>
					</div>
					<div class="col-sm-4">
						<input type="submit" name="submit" class="btn btn-info"
							value="Complete Request" />
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
