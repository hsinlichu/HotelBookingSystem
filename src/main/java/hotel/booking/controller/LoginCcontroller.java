package hotel.booking.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public class LoginCcontroller {
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String getLogin(@RequestParam String username, @RequestParam String password, Model model) {
    	System.out.println("Login");
        return "about";
    }
}
