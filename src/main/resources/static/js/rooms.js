(function($) {
    'use strict';
    
    var modify = function(){
    	if($("#singleprice").text() == -1)
    		$("#singlecol").hide();//.css('visibility', 'hidden');
		if($("#doubleprice").text() == -1)
    		$("#singlecol").hide();//.css('visibility', 'hidden');
		if($("#quadprice").text() == -1)
    		$("#singlecol").hide();//.css('visibility', 'hidden');
    }
    modify();
    $("#reservebutton").attr("disabled", true); //default
    var onceChange = function(){
    	var total =  $("#numofSingle").val() * $("#singleprice").text() + $("#numofDouble").val() * $("#doubleprice").text() + $("#numofQuad").val() * $("#quadprice").text(); 
    	$("#totalprice").attr("value", total);

        var bookroom = parseInt($("#numofSingle").val()) +  parseInt($("#numofDouble").val()) + parseInt($("#numofQuad").val()); 
        //console.log(bookroom);
        if(bookroom <= 0)
            $("#reservebutton").attr("disabled", true);
        else
            $("#reservebutton").attr("disabled", false);
        return;
    };

    $("#numofSingle").change(onceChange);
    $("#numofDouble").change(onceChange);
    $("#numofQuad").change(onceChange);

    
})(jQuery);



