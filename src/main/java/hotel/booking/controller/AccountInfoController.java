package hotel.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hotel.booking.Global;
import hotel.booking.container.Account;

@Controller
public class AccountInfoController {               
     
    public String getIssues(Model model) {
    	System.out.println("Resultpage");
        return "  ";                        
    }
    
    public Account modifyAccount(Account account, String name, String email, String password) {   //input new email or address
    	Account modified;
    	modified = Global.db.updateAccount(account, name, email, password);    	
    	return modified;
    }
    
    
	

}
