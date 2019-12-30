package hotel.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HotelDetailController {           //���wHotel���Ӹ`���G����(HotelDetailUI)
	  //�������whtml     
    public String getIssues(Model model) {
    	System.out.println("Resultpage");
        return "  ";                        //�������whtml
    }

}
