package hotel.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hotel.booking.Global;
import hotel.booking.container.Account;


@Controller
public class HomePageController {
	@RequestMapping(value={"", "/", "index.html"})
    public String getHomePage(Model model) {
    	System.out.println("Home Page");
        return "index";
    }
	
	
	public Boolean register(String firstname, String lastname, String email, String password) {
		Boolean result = true;
		String name = lastname + firstname;
		if (password.length() == 8) {     //the condition of password(can be canceled or changed)
			result = false;
		}
		if (result) {                     //register success
			System.out.println(name + " has registered successfully.");
			Global.db.addAccount(name, email, password);
		}
		return result;
	}
	
	public Account login(String account, String password) {
		Account result;
		result = Global.db.verifyAccount(account, password);
		if (result != null) {
			System.out.println(account + " logged in");
		}
		return result;                     //if login failed, return null
	}
	
}
