package hotel.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import hotel.booking.container.LoginInfo;

@Controller
public class LoginController {
	@Resource(name = "loginInfoSession")
	LoginInfo loginInfo;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String getLogin(@RequestParam String email, @RequestParam String passwd, Model model) {

		System.out.println("Current Status: "+loginInfo.islogin);
		loginInfo.islogin = true;
    	System.out.println(email + passwd);
    	System.out.println("login");
    	model.addAttribute("islogin", true);
    	System.out.println(model);
        return "index";
    }
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String getLogin(@RequestParam String name, @RequestParam String email, @RequestParam String passwd, Model model) {
    	System.out.println(name+email+passwd);
    	System.out.println("signup");
        return "index";
    }
}
