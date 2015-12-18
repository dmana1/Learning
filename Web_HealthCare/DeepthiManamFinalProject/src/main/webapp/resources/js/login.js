$(function() {
   
 $("#login").submit(function( event ) {
	 
    	
    	$("#error").html(" ");
    	var alphaExp = /^[a-zA-Z]+$/;
    
        var usernameExp=/^[a-z0-9_-]+$/;
        var isValid=true; 

        if (!$("#userName").val().match(usernameExp)) {
            $("#error").append("<p>Please enter valid username</p>");
            isValid=false;
        }
        if (!$("#password").val().match(usernameExp)) {
        	 $("#error").append("<p>Please enter valid password</p>");
        	 isValid=false;
         }
      
        
    	return isValid;
  	});
});




