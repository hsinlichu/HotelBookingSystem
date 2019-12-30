package hotel.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HotelDetailController {           //指定Hotel的細節結果頁面(HotelDetailUI)
	@RequestMapping(value={"", "/", ".html"})  //換成指定html     
    public String getIssues(Model model) {
    	System.out.println("Resultpage");
        return "  ";                        //換成指定html
    }

}
