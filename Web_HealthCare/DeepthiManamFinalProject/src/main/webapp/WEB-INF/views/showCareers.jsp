
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

		<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
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
						<li><a href="home.htm">Home</a></li>
						<li><a href="services.htm">Services</a></li>
						<li class="active"><a href="careers.htm">Careers</a></li>
						<li><a href="question.htm">FAQs</a></li>
						<li><a href="signin.htm">Sign In</a></li>
						<li> <div id="google_translate_element"></div></li>
						


					</ul>
				</div>
				<!-- navbar-collapse -->
			</div>
			<!-- container-fluid -->
		</nav>
		<br>
		<br>
		<br><br><br>

		<section id="content">
			<div class="row">
				<div class="col-md-5">
					<h2>Want To Join Our Team ???</h2>
					<h4>We are looking for qualified professionals who are passionate
					 about their job. Send us your CV by uploading below: </h4>
					<form:form method="POST" action="uploadFile.htm"
						enctype="multipart/form-data" modelAttribute="fileUpload">
						
						Name: <input type="text" name="name" required="required"/><br><br>
						<div><input type="file" name="file" class="btn btn-info" required="required"></div><br><br>
						 <input	type="submit" value="Upload" class="btn btn-primary"> Click here to upload the
						file!
					</form:form>
				</div>


				<div class="col-md-6">
					<div class="block-image background-scale">
						<img class="img-responsive center-block"
							src="resources/images/join.png" alt="">
					</div>
				</div>
			</div>


		</section>






		<div class="navbar navbar-default navbar-fixed-bottom">
			<div class="navbar-header">
				<a class="navbar-brand" href="#"></a>
			</div>

		</div>
	</div>
	
	
	
<script type="text/javascript">
function googleTranslateElementInit() {
  new google.translate.TranslateElement({pageLanguage: 'en', layout: google.translate.TranslateElement.InlineLayout.SIMPLE}, 'google_translate_element');
}
</script>
<script type="text/javascript" src="//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>
  <!-- javascript at the bottom for fast page loading -->
 
</body>
</html>
