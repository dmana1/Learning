
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
		<br><br><br>
		
		<section id="content">
			<h1>Welcome ${user.userName}</h1>
			
			<c:if test="${not empty errorMessage}">
				<p style="color: red">${errorMessage}</p>
			</c:if>
			<div class="row">
			<div class="col-md-9">
			<form action="deleteMessageOfPatient.htm">
				<br>
				<h4>
					<i>You have ${size}  messages</i>
				</h4>

				<table>


					<tr>
						<th>Message ID</th>
						<th>From User</th>
						<th>Message</th>
						<th>Date</th>						
						<th>Delete</th>

					</tr>
					<c:forEach var="row" items="${requestScope.messages}">
						<tr>
							<td><input type="text" readonly="readonly" name="messageID"
								value="${row.messageId}" /></td>
							<td><input type="text" readonly="readonly" name="fromUser"
								value="${row.fromUser}" /></td>
							<td><input type="text" readonly="readonly" name="message"
								value="${row.message}" /></td>
							<td><input type="text" readonly="readonly"
								name="messageDate" value="${row.sentDate}" /></td>
							
							<td><input type="checkbox" name="deleteMessage"
								value="${row.messageId}"></td>

						</tr>

					</c:forEach>




				</table>
				<br>
				<br>
				<div id="delete" style="padding-left: 250px">
					<input type="submit" name="delete" value="Delete Messages" class="btn btn-primary" />
					<input type="submit" onclick="this.form.action='messageDoctor.htm'"
					value="Message Doctor" class="btn btn-primary"/>
				</div>

			</form>
			</div>
			<div class="col-md-3">
					<div class="block-image background-scale">
						<img class="img-responsive center-block"
							src="resources/images/message1.png" alt="">
					</div>
				</div>
			
		</div>

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
