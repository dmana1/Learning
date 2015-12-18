$(function() {
    $("#addEnterprise").submit(function( event ) {
	 
    	
    	$("#error").html(" ");
    	var entExp = /^[A-Za-z\s]+$/
    	
        var isValid=true; 

        if (!$("#enterpriseName").val().match(entExp)) {
            $("#error").append("<p>Please enter valid enterprise name</p>");
            isValid=false;
        }
        
    	return isValid;
  	});
});




