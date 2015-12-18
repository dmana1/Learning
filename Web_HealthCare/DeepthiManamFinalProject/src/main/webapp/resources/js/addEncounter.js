$(function() {   
 $("#addEncounter").submit(function( event ) {
	 	
    	$("#error").html(" ");
    	var decimalExp = /^[1-9]\d*(\.\d+)?$/;
        var designationExp=/^[A-Za-z\d\s]+$/;
        var problemExp=/^[A-Za-z\d\s.,]+$/;
       
        var isValid=true; 

        if (!$("#respiratoryRate").val().match(decimalExp)) {
            $("#error").append("<p>Please enter valid Respiratory rate</p>");
            isValid=false;
        }
        if (!$("#heartRate").val().match(decimalExp)) {
        	 $("#error").append("<p>Please enter valid heart rate</p>");
        	 isValid=false;
         }
        if (!$("#weight").val().match(decimalExp)) {
        	 $("#error").append("<p>Please enter valid weight</p>");
        	 isValid=false;
         }
        if (!$("#bloodPressure").val().match(decimalExp)) {
       	 $("#error").append("<p>Please enter valid blood pressure</p>");
       	 isValid=false;
        }
        if (!$("#problem").val().match(problemExp)) {
          	 $("#error").append("<p>Please enter valid problem</p>");
          	 isValid=false;
           }
        if (!$("#description").val().match(problemExp)) {
         	 $("#error").append("<p>Please enter valid advice</p>");
         	 isValid=false;
          }
        
    	return isValid;
  	});
});




