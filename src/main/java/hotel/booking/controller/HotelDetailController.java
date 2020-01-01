package hotel.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hotel.booking.Global;
import hotel.booking.container.Hotel;

@Controller
public class HotelDetailController {           
	  
    public String getIssues(Model model) {
    	System.out.println("Resultpage");
        return "  ";                        
    }
    
    public Hotel getHotel(int id) {
    	Hotel result;
    	result = Global.db.getHotel(id);    	
    	System.out.println("get hotel " + id );
    	return result;                         //if failed, return null
    }

}
