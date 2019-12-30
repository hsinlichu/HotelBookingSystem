package hotel.booking.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String getLogin(@RequestParam String location, Model model) {
    	System.out.println(location);
    	System.out.println("login");
        return "about";
    }
}
