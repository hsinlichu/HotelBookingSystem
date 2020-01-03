package hotel.booking.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hotel.booking.Global;
import hotel.booking.container.Hotel;

@Controller
public class HotelDetailController {           
	@RequestMapping(value={"rooms.html", "rooms"}, method=RequestMethod.GET, params = {"id"})
    public String getDetailHotel(@RequestParam int id, Model model) {
    	System.out.println("id: " + id);
    	
    	Hotel result = Global.db.getHotel(id);    	
    	System.out.println("get hotel " + id );
        return "rooms";                        
    }
}
