
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
			<c:if test="${not empty errorMessage}">
				<p style="color: red">${errorMessage}</p>
			</c:if>
			<h2>Prescription Work Requests</h2><br>
			<form action ="processPrescription.htm">

				<table>

					<tr>
						<th>PrescriptionId</th>
						<th>Created On</th>
						<th>Patient MRN</th>
						<th>Status</th>
						<th>Process</th>
					</tr>
					<c:forEach var="row" items="${requestScope.workRequestList}">
						<tr>
							<td>PR000${row.requestId}</td>
							<td>${row.createdOn}</td>
							<td>${row.patientId}</td>
							<td>${row.status}</td>
							<td><input type="radio" name="processId"
								value="${row.requestId}"></td>
						
						</tr>

					</c:forEach>
				</table>
				<br><br>
				<div class="row">
					<div class="col-sm-1">
						<p></p>
					</div>
					<div class="col-sm-4">
						<input type="submit" name="submit" class="btn btn-info"
							value="Process Request" />
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
