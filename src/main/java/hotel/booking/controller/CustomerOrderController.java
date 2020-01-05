package hotel.booking.controller;

import java.util.*;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hotel.booking.Global;
import hotel.booking.container.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import javax.validation.Valid;


@Controller
public class CustomerOrderController {         
	@Resource(name = "loginInfoSession")
	LoginInfo loginInfo;
	
	@RequestMapping(value={"ordermanagement", "ordermanagement.html"})
    public String getCustomerOrderPage(Model model) {
    	System.out.println("CustomerOrderPage");
    	model.addAttribute("loginInfo", loginInfo);
        return "ordermanagement";                        
    }
	
	@RequestMapping(path = "/GetAllOrder", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<Order> getCustomerOrder(){
		System.out.println("GetAllOrder");
    	List<Order> Orderlist=Global.db.getCustomerOrder(loginInfo.account.id);
    	System.out.println(Orderlist);
    	
    	
    	
    	return Orderlist;
    }
    
	
	@RequestMapping(value="/editorder", method=RequestMethod.POST)
    public ResponseEntity<?> getSearchResultViaAjax(
    		@Valid @RequestBody @RequestParam(required = true) int id, @Valid @RequestBody @RequestParam(required = false) String quantity, 
    		@Valid @RequestBody @RequestParam(required = false) String dateIn, @Valid @RequestBody @RequestParam(required = false) String dateOut,
    		@Valid @RequestBody @RequestParam(required = false) String action) {
		System.out.println("editorder");
        AjaxResponseBody result = new AjaxResponseBody();
        System.out.println(id+quantity+dateIn+dateOut+action);
        Order modifyOrder = Global.db.getOrder(id);
        boolean execute = false;
        
        if(action.equals("edit")) {
        	execute = modifyCustomerOrder(modifyOrder, quantity, dateIn, dateOut);
        }
        else if(action.equals("delete")) {
        	execute = deleteCustomerOrder(modifyOrder);
        }
        
        if(execute = false) {
        	result.setMsg("edit failed!");
        }
        else {
        	result.setMsg("edit successfully!");
        }

        //If error, just return a 400 bad request, along with the error message
        //return ResponseEntity.badRequest().body(result);
        return ResponseEntity.ok(result);
	}

    public boolean deleteCustomerOrder(Order deleteOrder){
    	return Global.db.cancelOrder(deleteOrder);
    }
    public boolean modifyCustomerOrder(Order modifyOrder,String Quantity, String datein, String dateout) {   //modify -> re getCustomer
    	if(Quantity != null) {
    		modifyOrder.quantity = Integer.valueOf(Quantity);
    		System.out.println("change quantity");
    	}
    	if(datein != null) {
    		modifyOrder.dateIn = datein;
    		System.out.println("change datein");
    	}
    	if(dateout != null) {
    		modifyOrder.dateOut = dateout;
    		System.out.println("change dateout");
    	}
    	else {
    		System.out.println("change failed");
    	}
    	return Global.db.modifyOrder(modifyOrder);
    }

}
