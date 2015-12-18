	
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
			
			<form action ="" method="post">

				<h3>HealthCare System, Inc.</h3>
				<h5>HealthCare Website Privacy Policy</h5>
				<p>This Website Privacy Policy, along with the Health Care
					Terms of Use and  Notice of Privacy Practices will tell you
					what information we collect through health care and how it is
					used. By using the Health Care, you agree to acceptance of this
					Website Privacy Policy. Please read the following carefully before
					using the site. Information Collection and Use
				
				<p>
				
				<h5><b>Information We Collect</b></h5>
				<p> The information required is noted on each
					specific form or registration page. Additional questions might be
					included to help us improve the services we offer. How We Use This
					Information Partners uses the information you provide to operate
					HealthCare and provide the HealthCare service to you. In
					addition, HealthCare may also use certain personal information,
					including your email address, to provide related
					communications to you as well as to provide certain information and
					surveys, including patient satisfaction surveys relating to your
					use of services provided by Partners and certain Partners
					affiliates.</p>
				<h5><b>Data Security</b></h5>
				<p>HealthCare seeks to prevent unauthorized access to your
					personal information by maintaining a secure firewall and use of
					security technologies to protect the integrity and privacy of any
					personal information you provide. As an additional security
					measure, your personal information is also encrypted during
					transmission by Secure Socket Layer 128-bit encryption software.
					(Encryption is a common method used to transmit sensitive data
					across the Internet. Encryption temporarily makes the text
					unreadable during the time it is being transmitted over the
					Internet.) This is an industry standard. Although we endeavor to
					protect your personal information, HealthCare cannot and does not
					warrant the security of any information you transmit to us through
					online applications, and you do so at your own risk. Depending on
					the nature of the inquiry, your communication could be discarded or
					archived. If you wish, you can contact us instead by telephone at
					the numbers provided throughout our site.</p>

				<h5><b>Cookies</b></h5>
				<p>The HealthCare website uses "cookies" to determine the
					number of times a page on the website has been accessed. Cookies
					are small computer files that a website can transfer to your
					computer. Examples of information we collect include how often
					someone visits our site and their activities while on our site. We
					use this information in the aggregate to understand how our
					visitors as a group use different resources. These reports do not
					contain any personally identifiable information. Most Internet
					browsers automatically accept cookies, but you can set your browser
					to refuse them or to alert you when they are being sent.</p>
				<h5><b>Login/Passwords</b></h5>
				<p>Some sections of the HealthCare website require login
					identifiers and/or passwords. You are responsible for taking
					reasonable steps to ensure that no unauthorized person has access
					to your password or account login information. It is your sole
					responsibility to control the use of login information and
					passwords, to authorize, monitor and control access to and use of
					your website account and password and to inform the website
					promptly of any need to deactivate a password.
				
				<p>
				
				<h5><b>Third-Party Vendors/Content Providers</b></h5>
				<p>HealthCare occasionally will engage reputable third-party
					vendors to help us manage our website, provide content and
					information and enable us to interact better with our patients and
					visitors.
				
				<p>
				
				<h5><b>Links to External Websites</b></h5>
				<p>This Website Privacy Policy applies only to the HealthCare
					Gateway website. In order to provide HealthCare users with
					other helpful information, the HealthCare website contains
					links to other websites. However, HealthCare has no authority over
					external organizations' websites and this policy does not apply to
					external sites that are provided as links. We encourage you to read
					the privacy policies on any external websites before providing them
					with personal information.</p>
					
					<input style ="width: 25px "type ="checkbox" name = "iAgree" required="required"/> I Agree
					<br><br>
					<input type = "submit" name = "_eventId_prev" value = "prev" class="btn btn-primary"/>
					
					<input type ="submit" name = "_eventId_finish" value = "finish" class="btn btn-primary"/>
					

			</form>

		</section>
	
		
  
		

		
		<div class="navbar navbar-default ">
			<div class="navbar-header">
				<a class="navbar-brand" href="#"></a>
			</div>
			
		</div>
	</div>
</body>
</html>
