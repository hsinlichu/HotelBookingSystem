package hotel.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hotel.booking.container.Hotel;

@Controller
public class InfoCheckController {            
	      
    public String getIssues(Model model) {
    	System.out.println("Resultpage");
        return "  ";                        
    }
    
    public boolean book(Hotel hotel, String daein, String dateout, int numofSingle, int numofDouble, int numifQuad) {
    	boolean available = true;
    	
    	return available;
    }

}
