package hotel.booking.controller;

import java.util.*;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hotel.booking.Global;
import hotel.booking.container.Account;
import hotel.booking.container.Order;
@Controller
public class CustomerOrderController {         //�U�ȭq��޲z�קﭶ��(CustomerOrderUI)
	 //�������whtml     
    public String getIssues(Model model) {
    	System.out.println("Resultpage");
        return "  ";                        //�������whtml
    }
    public List<Order> getCustomerOrder(Account account){
    	List<Order> Orderlist=Global.db.getCustomerOrder(account.id);
    	return Orderlist;
    }
    public boolean deleteCustomerOrder(Order deleteOrder){
    	Order order=deleteOrder;
    	Global.db.cancelOrder(order);
    	return true;
    }

}
