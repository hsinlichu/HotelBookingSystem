package hotel.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hotel.booking.container.Account;
import hotel.booking.database.Database;

@Controller
public class HomePageController {
	@RequestMapping(value={"", "/", "index.html"})
    public String getIssues(Model model) {
    	System.out.println("Home Page");
        return "index";
    }
	
	
	public Boolean register(String name, String email, String password) {
		Boolean result;
		if (password.length() <= 8) {
			result = false;
		}
		if (result) {
			System.out.println(name + " has registered successfully.");
		}
		return result;
	}
	
	public Boolean login(String account, String password) {
		Boolean result;
		result = db.verifyAccount(account, password);
		if (result) {
			System.out.println(account + " logged in");
		}
		return result;
	}
	
	
}
