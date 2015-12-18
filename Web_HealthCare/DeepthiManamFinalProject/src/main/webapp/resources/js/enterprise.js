$(function() {
    $('#entType').change(function() {
        $.ajax({
            url: '/care/enterprise.htm',
            dataType: 'json',
            type: 'GET',
            // This is query string i.e. country_id=123
            data: {enterpriseType : $('#entType').val()},
            success: function(data) {
            	
                $('#ent').empty(); // clear the current elements in select box
                for (row in data) {
                    $('#ent').append("<option value="+data[row].id +">"+data[row].name+"</option>");

                }
            },
            error: function(jqXHR, textStatus, errorThrown) {
                alert(errorThrown);
            }
        });
    });
 $("#addEmployee").submit(function( event ) {
	 
    	
    	$("#error").html(" ");
    	var alphaExp = /^[a-zA-Z]+$/;
    	var phoneExp = /^[(]{0,1}[0-9]{3}[)]{0,1}[-\s]{0,1}[0-9]{3}[-\s]{0,1}[0-9]{4}$/;
        var designationExp=/^[A-Za-z\d\s]+$/;
        var ssnExp=/^\d{9}$/;
        var usernameExp=/^[a-z0-9_-]+$/;
        var isValid=true; 

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
        if (!$("#designation").val().match(designationExp)) {
       	 $("#error").append("<p>Please enter valid designation</p>");
       	 isValid=false;
        }
        if (!$("#ssn").val().match(ssnExp)) {
          	 $("#error").append("<p>Please enter valid SSN</p>");
          	 isValid=false;
           }
        if (!$("#username").val().match(usernameExp)) {
         	 $("#error").append("<p>Please enter valid username</p>");
         	 isValid=false;
          }
        
    	return isValid;
  	});
});




