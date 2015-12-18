
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

							<li><a href="logout.htm">Logout</a></li>

						</ul>
					</div>
					<!-- navbar-collapse -->
				</div>
				<!-- container-fluid -->
			</nav>
		</section>

		<section class="content">

			<form>

				<table>

					<tr>
						<th>Employee ID</th>
						<th>Employee Name</th>
						<th>Designation</th>
						<th>Email ID</th>
						<th>PhoneNumber</th>
						<th>Role</th>
						<th>Enterprise Name</th>

					</tr>
					<c:forEach var="row" items="${requestScope.employeeList}">
						<tr>
							<td><input type="text" readonly="readonly" name="employeeId"
								value="${row.employeeId}" /></td>
							<td><input type="text" readonly="readonly" name="firstName"
								value="${row.firstName}" /></td>
							<td><input type="text" readonly="readonly"
								name="designation" value="${row.designation}" /></td>
							<td><input type="text" readonly="readonly" name="emailId"
								value="${row.emailId}" /></td>
							<td><input type="text" readonly="readonly"
								name="phoneNumber" value="${row.phoneNumber}" /></td>
							<td><input type="text" readonly="readonly" name="roleName"
								value="${row.role.roleName}" /></td>
							<td><input type="text" readonly="readonly"
								name="enterpriseName" value="${row.enterprise.name}" /></td>
							<td><input type="checkbox" name="deleteEmployee"
								value="${row.employeeId}"></td>

						</tr>

					</c:forEach>
				</table>
				<br> <br> <input type="submit"
					onclick="this.form.action='showAddEmployee.htm'" value="Add Employee" />
				<input type="submit" onclick="this.form.action='deleteEmployee.htm'"
					value="Delete Employee" />

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
