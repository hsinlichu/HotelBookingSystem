package hotel.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomePageController {
	@GetMapping("/")
    public String getIssues(Model model) {
    	System.out.println("result");
        return "index";
    }
}
