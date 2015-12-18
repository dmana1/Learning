
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

#basicInfo{
	padding-left: 7px;
	padding-right: 7px;
	padding-bottom:5px;
	background-color: #99C2D6;
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
						<li><a href="patientHome.htm">Home</a></li>
							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="#">Encounter<span
									class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="viewEncounterDetails.htm">View Details</a></li>
								</ul></li>

							<li class="dropdown"><a class="dropdown-toggle"
								data-toggle="dropdown" href="#">Message<span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="patientMessages.htm">Message Doctor</a></li>
								</ul></li>

							<li><a href="logout.htm">Logout</a></li>

						</ul>
					</div>
					<!-- navbar-collapse -->
				</div>
				<!-- container-fluid -->
			</nav>
		</section>
		<br>
		
		<section class="content1">
		
		<div id ="basicInfo">
		<table>
		<tr>
		<td id ="basicInfo"><b>MRN: </b> </td>	
		<td id ="basicInfo"> ${patient.patientId}</td>	
		<td id ="basicInfo"><b>First Name: </b> </td>
		<td id ="basicInfo"> ${patient.firstName}</td>
		<td id ="basicInfo"><b> Last Name: </b></td>
		<td id ="basicInfo"> ${patient.lastName}</td>
		<td id ="basicInfo"><b>SSN: </b></td>
		<td id ="basicInfo"> ${patient.ssn}</td>
		<td id ="basicInfo"><b>DOB: </b></td>
		<td id ="basicInfo"> ${patient.dob}</td>	
		<td id ="basicInfo"><b>Email Id: </b></td>
		<td id ="basicInfo"> ${patient.emailId}</td>	
		<td id ="basicInfo"><b>PhoneNumber: </b></td>
		<td id ="basicInfo"> ${patient.phoneNumber}</td>
			
		</tr>
		
		
		</table>
		</div>
		<br>
		<form>
		
		
		<div id = "encounterAndMedicationInfo">
		<table>

					<tr>
						<th>EncounterID</th>
						<th>Date</th>
						<th>Problem</th>
						<th>Description</th>
						
					</tr>
					<c:forEach var="row" items="${requestScope.encounterList}">
						<tr>
							<td><input type="text" readonly="readonly" name="encounterId"
								value="${row.encounterId}" /></td>
							<td><input type="text" readonly="readonly" name="encounterDate"
								value="${row.encounterDate}" /></td>
							<td><input type="text" readonly="readonly"
								name="problem" value="${row.problem}" /></td>
							<td><input type="text" readonly="readonly" name="description"
								value="${row.description}" /></td>
							
						</tr>
					</c:forEach>
				</table>
				
		
		</div>
		<br>
		<div id ="medicationInfo">
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
		
		</div>
		<br>
		<div id ="vitalSignInfo">
		<table>

					<tr>
						<th>VitalSignID</th>
						<th>Date</th>	
						<th>BloodPressure</th>
						<th>HeartRate</th>	
						<th>Weight</th>
						<th>Respiratory Rate</th>									
						
					</tr>
					<c:forEach var="row" items="${requestScope.vitalsignList}">										
						
						<tr>
							<td><input type="text" readonly="readonly" name="vitalSignId"
								value="${row.vitalSignId}" /></td>
							<td><input type="text" readonly="readonly" name="createdOn"
								value="${row.createdOn}" /></td>
							<td><input type="text" readonly="readonly"
								name="bloodPressure" value="${row.bloodPressure}" /></td>	
								<td><input type="text" readonly="readonly"
								name="heartRate" value="${row.heartRate}" /></td>	
								<td><input type="text" readonly="readonly"
								name="weight" value="${row.weight}" /></td>	
								<td><input type="text" readonly="readonly"
								name="respiratoryRate" value="${row.respiratoryRate}" /></td>														
						</tr>
					</c:forEach>
				</table>
		
		
		</div>
		
		<input type ="hidden" name ="patientId" value = "patient.patientId"/>
		
		
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
