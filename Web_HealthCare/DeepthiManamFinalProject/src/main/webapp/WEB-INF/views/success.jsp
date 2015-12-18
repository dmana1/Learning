
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
		
		

<style type="text/css">
.logo
{
    font-family: 'Dosis', sans-serif;
}
.nav.navbar-nav 
{
    /* padding: 0px 20px; */
}
.navbar-default
{
    background-color: #267D90;
    background-color: #085A6C;
}
.navbar-default .navbar-header .logo
{
    font-size: 32px;
    color: #fff;
}
.navbar-nav li 
{
    /* border-right: 1px solid #54aec2; */
    padding: 7px 0px;
}
.navbar-default .navbar-nav li a 
{
    text-shadow: 1px 1px 0px #20606D;
    color: #fff;
}
.dropdown-menu{
	background-color: rgba(5, 207, 252, 0.62);
    border-bottom: 1px;
}
.row{
padding-bottom: 5px;
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
				
				</div><!-- container-fluid -->
			</nav>
		</section>

		<section class="content">
		<br><br><br><br>
		
		
			

				
					<h2> Successfully Registered for Health Care Application</h2>
					<br>
					<h4 style="color:blue;"> You will receive email confirming your registration.Please check your email</h4>
					
					<h4><a href ="http://localhost:8080/care">Click Here to go back to login</a></h4>
					
			

		</section>
	
		
  
		

		
		<div class="navbar navbar-default navbar-fixed-bottom">
			<div class="navbar-header">
				<a class="navbar-brand" href="#"></a>
			</div>
			
		</div>
	</div>
</body>
</html>
