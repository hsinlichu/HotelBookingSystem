package hotel.booking.controller;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hotel.booking.container.Account;
import hotel.booking.container.Hotel;

@Controller
public class MyHotelController {               
	       
    public String getIssues(Model model) {
    	System.out.println("Resultpage");
        return "  ";                        
    }
//    public List<Hotel> getMyHotel(Account account){
//    	
//    }

}
