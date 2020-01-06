(function($) {

    'use strict';

    $.getJSON('/getOwnerOrder', function (data) {
        //console.log(data);
        $("#ordertable tr").remove();
        var template = `
        <tr data-id="%(id)s">
            <td scope="row">%(id)s</td>
            <td>%(dateIn)s</td>
            <td>%(dateOut)s</td>
            <td>%(room.type)s</td>
            <td>%(quantity)s</td>
            <td>%(room.price)s</td>
        </tr>
        `;
        var i;
        for(i = 0;i < data.length; ++i){
            var tmp = sprintf(template, data[i]);
            //console.log(tmp);
            $("#ordertable").append(tmp);
        }
        
        $("#wholeordertable").Tabledit({
            url: '/editOwnerOrder',
            deleteButton: true,
            editButton: false,
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
                }
                
            },
            
            columns: {
            	
              identifier: [0, "id"],
              editable: [
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
                alert(errorThrown);
                console.log(textStatus);
                console.log(errorThrown);
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




