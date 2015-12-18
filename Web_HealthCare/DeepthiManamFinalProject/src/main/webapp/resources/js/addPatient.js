$(function() {   
 $("#addPatient" ).submit(function( event ) {
	 	
    	$("#error").html(" ");
    	var alphaExp = /^[a-zA-Z]+$/;
    	var phoneExp = /^[(]{0,1}[0-9]{3}[)]{0,1}[-\s]{0,1}[0-9]{3}[-\s]{0,1}[0-9]{4}$/;
        var designationExp=/^[A-Za-z\d\s]+$/;
        var ssnExp=/^\d{9}$/;
        var usernameExp=/^[a-z0-9_-]+$/;
        var isValid=true; 
        var addressExp=/^[A-Za-z\d\s\-\,\:]+$/;

        if (!$("#firstName").val().match(alphaExp)) {
            $("#error").append("<p>Please enter valid first name</p>");
            isValid=false;
        }
        if (!$("#lastName").val().match(alphaExp)) {
        	 $("#error").append("<p>Please enter valid last name</p>");
        	 isValid=false;
         }
        if (!$("#phoneNumber").val().match(phoneExp)) {
        	 $("#error").append("<p>Please enter valid phone number</p>");
        	 isValid=false;
         }
       
        if (!$("#ssn").val().match(ssnExp)) {
          	 $("#error").append("<p>Please enter valid SSN</p>");
          	 isValid=false;
           }
        
        if (!$("#address").val().match(addressExp)) {
         	 $("#error").append("<p>Please enter valid address</p>");
         	 isValid=false;
          }
      
    	return isValid;
  	});
});




