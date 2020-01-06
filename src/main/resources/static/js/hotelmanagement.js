(function($) {

    'use strict';

    $.getJSON('/getMyhotel', function (data) {
        console.log(data);
        $("#ordertable tr").remove();
        var template = `
        <tr data-id="%(id)s">
            <td scope="row">%(id)s</td>
            <td>%(star)s</td>
            <td>%(locality)s</td>
            <td>%(street)s</td>
        </tr>
        `;
        var i;
        for(i = 0;i < data.length; ++i){
            var tmp = sprintf(template, data[i]);
            //console.log(tmp);
            $("#ordertable").append(tmp);
        }
        
        $("#wholeordertable").Tabledit({
            url: '/editMyhotel',
            deleteButton: false,
            editButton: true,
            restoreButton: false,
            buttons: {
                delete: {
                    class: 'btn btn-sm btn-danger',
                    html: 'DELETE',
                    action: 'delete'
                },
                confirm: {
                    class: 'btn btn-sm btn-default',
                    html: 'Are you sure?'
                },
                edit: {
                    class: 'btn btn-sm btn-success',
                    html: 'EDIT',
                    action: 'edit'
                },
            },
            
            columns: {
            	
              identifier: [0, "id"],
              editable: [
            	  [1, 'star'], [2, 'locality'], [3, 'street'],
              ]
            },
           onSuccess: function(data, textStatus, jqXHR) {
                console.log('onSuccess(data, textStatus, jqXHR)');
                console.log(data);
                alert(data["msg"]);
                console.log(textStatus);
                console.log(jqXHR);
                location.reload();
            },
            onFail: function(jqXHR, textStatus, errorThrown) {
                console.log('onFail(jqXHR, textStatus, errorThrown)');
                console.log(jqXHR);
                console.log(textStatus);
                console.log(errorThrown);
                alert(errorThrown);
                //alert("Edit Error! Page reloading..");
                location.reload();
            },
            onAlways: function() {
                console.log('onAlways()');
            },
            onAjax: function(action, serialize) {
                console.log('onAjax(action, serialize)');
                console.log(action);
                console.log(serialize);
            }
          });
    });
    

    $(function() {
      
    });

})(jQuery);




