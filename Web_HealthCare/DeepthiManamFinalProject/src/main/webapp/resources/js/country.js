$(function() {
    $('#country').change(function() {
        $.ajax({
            url: '/care/state.htm',
            dataType: 'json',
            type: 'GET',
            // This is query string i.e. country_id=123
           // data: {enterpriseType : $('#country').val()},
            success: function(data) {
            	alert(data);
                $('#state').empty(); // clear the current elements in select box
                for (row in data) {
                    $('#state').append("<option>"+data[row].name+"</option>");

                }
            },
            error: function(jqXHR, textStatus, errorThrown) {
                alert(errorThrown);
            }
        });
    });
});