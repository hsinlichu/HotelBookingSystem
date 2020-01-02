(function($) {

    'use strict';

    $.getJSON('GetAllHotel', function (data) {

        $("ul#output > li").remove();
        var template = `
        <div class="media media-custom d-block mb-4 h-100">
            <a href="#" class="mb-4 d-block">
                <div class="row py-2">
                    <div class="col-lg-4 col-12 align-self-center">
                        <img src="images/img_1.jpg" width="100%" alt="Image placeholder">
                    </div>
                    <div class="col-lg-5 col-12 align-self-center">
                        <div class="media-body">
                            <span class="meta-post"> 5 <span class="fa fa-star text-primary"></span></span>
                            <h2 class="mt-0 mb-3">台北 民生東路一段28號</h2>
                            <span>Single Room Price: $(Rooms[0]) (300 remained)</span></br>
                            <span>Double Room Price: 500 (300 remained)</span></br>
                            <span>Quad Room Price: 500 (300 remained)</span></br>
                            <span>TWD: 1500 (average per person)</span>
                        </div>
                    </div>
                </div>
            </a>
        </div>
        `
        $.each(data, function (key, value) {

            $("#output").append('<li>' + value['name'] + " " + value['population'] + '</li>');
        });
    });

})(jQuery);





