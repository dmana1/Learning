
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
<script src="resources/js/login.js"></script>


</head>



<body>
	<div class="container">
	
			<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
  				<div class="container-fluid">
    				<!-- Brand and toggle get grouped for better mobile display -->
    				<div class="navbar-header">
      					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					        <span class="sr-only">Toggle navigation</span>
					        <span class="icon-bar"></span>
					        <span class="icon-bar"></span>
					        <span class="icon-bar"></span>
	      				</button>
	      				<a class="navbar-brand logo" href="#">
	      					<span><i class="fa fa-stethoscope"></i></span>
	      					HealthCare
	      				</a>
	    			</div>
		
		    		<!-- Collect the nav links, forms, and other content for toggling -->
				    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				    	<ul class="nav navbar-nav navbar-right">
					       	<li><a href="home.htm">Home</a></li>
					        <li><a href="services.htm">Services</a></li>
					        <li><a href="careers.htm">Careers</a></li>
							<li><a href="question.htm">FAQs</a></li>
							<li class="active"><a href="signin.htm">Sign In</a></li>
							
							
				      	</ul>
				    </div><!-- navbar-collapse -->
				</div><!-- container-fluid -->
			</nav>
		

		<div id="empty"><p></p></div>
		
			
			<div style ="color: red;" id = "error"><c:if test="${not empty errorMessage}">
				<p style="color: red">${errorMessage}</p>
			</c:if></div>
		<div class="row"><div class="col-md-7">
		<div id ="login">
		<form:form role="form" id = "login" method="POST" action="login.htm" commandName="user">
			<div class="form-group">
				<div class="row">
					<div class="col-md-4">
						<label for="userName" class="control-label input-md">User
							Name</label>
					</div>
					
				</div>
				<div class="row">
					<div class="col-md-4">
						<form:input id = "userName" path="userName" class="form-control"
							placeholder="Enter UserName" />
					</div>
				</div>
				<form:errors path="userName" cssStyle="color:#ff0000"></form:errors>
			</div>
			<div class="form-group form-group-md">
				<div class="row">
					<div class="col-md-4">
						<label for="password" class="control-label input-md">Password:</label>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<form:password id = "password" path="password" class="form-control"
							placeholder="Enter Password" />
					</div>
				</div>
				<form:errors path="password" cssStyle="color:#ff0000"></form:errors>
			</div>
			
			

			<input type="submit" name="submit" value="Submit"
				class="btn btn-primary" />
				
			
				

		</form:form>
		</div>
		</div>
 	 <div class="col-md-5"><img src="resources/images/service1.jpg" class="img-responsive" ></div>
  </div>
  			<div class ="row">
				
				<h4>If you are interested to sign up ? <a href="registration.htm">Register Here </a></h4>
			
			
			</div>
		

		
		<div class="navbar navbar-default navbar-fixed-bottom">
			<div class="navbar-header">
				<a class="navbar-brand" href="#"></a>
			</div>
			
		</div>
	</div>
</body>
</html>
