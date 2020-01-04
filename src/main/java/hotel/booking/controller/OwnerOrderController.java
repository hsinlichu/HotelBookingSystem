package hotel.booking.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hotel.booking.Global;
import hotel.booking.container.Account;
import hotel.booking.container.Order;

@Controller
public class OwnerOrderController {         
   
    public String getIssues(Model model) {
    	System.out.println("Resultpage");
        return "  ";                  
    }
    public List<Order> getOwnerOrder(Account account){
    	List<Order> Orderlist=Global.db.getOwnerOrder(account.id);
    	return Orderlist;
    }
    public boolean deleteOwnerOrder(Order deleteOrder){
    	return Global.db.cancelOrder(deleteOrder);
    }

}
