package hotel.booking.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import hotel.booking.container.Hotel;

@Controller
public class HomePageController {
	@RequestMapping(value={"", "/", "index.html"})
    public String getIssues(Model model) {
    	System.out.println("Home Page");
        return "index";
    }
	
}
