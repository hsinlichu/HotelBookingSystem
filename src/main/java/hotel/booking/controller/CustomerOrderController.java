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
    public List<Order> modifyCustomerOrder(List<Order> Orderlist,Order selectOrder){//not done
    	List<Order> Order=Orderlist;
    	Order select=selectOrder;
    	for(int i=0;i<Order.size();i++) {
    		if(Order.get(i).equals(select)) {
    			Order.remove(select);
    		}
    	}
    	return Order;
    }

}
