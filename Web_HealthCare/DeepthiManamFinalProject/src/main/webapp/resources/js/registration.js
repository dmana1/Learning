$(function() {   
 $('#add').click(function(  ) {
	 	alert("adsfasdf");
    	$("#error").html(" ");
    	var mrnExp=/^\d+$/;
    	var alphaExp = /^[a-zA-Z]+$/;
    	var phoneExp = /^[(]{0,1}[0-9]{3}[)]{0,1}[-\s]{0,1}[0-9]{3}[-\s]{0,1}[0-9]{4}$/;
        var designationExp=/^[A-Za-z\d\s]+$/;
        var ssnExp=/^\d{9}$/;
        var usernameExp=/^[a-z0-9_-]+$/;
        var isValid=true; 

        if (!$("#mrn").val().match(mrnExp)) {
            $("#error").append("<p>Please enter valid mrn</p>");
            isValid=false;
        }
        if (!$("#userName").val().match(usernameExp)) {
        	 $("#error").append("<p>Please enter valid user name</p>");
        	 isValid=false;
         }
        
        
    	return isValid;
  	});
});




