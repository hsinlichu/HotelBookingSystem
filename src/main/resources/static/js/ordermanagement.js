(function($) {

    'use strict';

    $.getJSON('/GetAllOrder', function (data) {
        //console.log(data);
        $("#ordertable tr").remove();
        var template = `
        <tr data-id="%(id)s">
            <td scope="row">%(id)s</td>
            <td>%(quantity)s</td>
            <td>%(dateIn)s</td>
            <td>%(dateOut)s</td>
            <td>%(room.type)s</td>
            <td>%(room.price)s</td>
            <td>%(room.quantity)s</td>
        </tr>
        `;
        var i;
        for(i = 0;i < data.length; ++i){
            var tmp = sprintf(template, data[i]);
            //console.log(tmp);
            $("#ordertable").append(tmp);
        }
        
        $("#wholeordertable").Tabledit({
            url: '/editorder',
            deleteButton: true,
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
            	  [1, 'quantity'], [2, 'dateIn'], [3, 'dateOut'], [6, 'room_quntity']
              ]
            },
           onSuccess: function(data, textStatus, jqXHR) {
                console.log('onSuccess(data, textStatus, jqXHR)');
                console.log(data);
                console.log(textStatus);
                console.log(jqXHR);
            },
            onFail: function(jqXHR, textStatus, errorThrown) {
                console.log('onFail(jqXHR, textStatus, errorThrown)');
                console.log(jqXHR);
                console.log(textStatus);
                console.log(errorThrown);
                alert("Room Unavilable! Page reloaging..");
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




