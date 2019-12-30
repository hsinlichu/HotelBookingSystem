package hotel.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyHotelController {               //賣方管理自己Hotel的主頁(MyHotelUI)
	@RequestMapping(value={"", "/", ".html"})  //換成指定html     
    public String getIssues(Model model) {
    	System.out.println("Resultpage");
        return "  ";                        //換成指定html
    }

}
