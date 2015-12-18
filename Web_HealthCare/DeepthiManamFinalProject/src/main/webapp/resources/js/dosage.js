$(function() {
    $('#addDosage').click(function() {
        $.ajax({
            url: '/care/dosage.htm',
            dataType: 'json',
            type: 'GET',
            // This is query string i.e. country_id=123
            data: {drugId : $('#selectedDrug').val(), dosage: $('#dosage').val()},
            success: function(data) {
            	
            	$("#medication td").remove();
                for (row in data) {
                    $('#medication').append("<tr><td>" + data[row].drugId  +"</td><td>" +data[row].name + "</td><td>" +data[row].usageDirections +
                    		"</td><td>" +data[row].dose +  "</td></tr>");
                }
            },
            error: function(jqXHR, textStatus, errorThrown) {
                alert(errorThrown);
            }
        });
    });
});