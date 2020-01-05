package hotel.booking.controller;

import java.util.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hotel.booking.Global;
import hotel.booking.container.Account;
import hotel.booking.container.AjaxResponseBody;
import hotel.booking.container.Hotel;
import hotel.booking.container.LoginInfo;
import hotel.booking.container.Order;
import hotel.booking.container.Room;

@Controller
public class MyHotelController {               
	       
    public String getIssues(Model model) {
    	System.out.println("Resultpage");
        return "  ";                        
    }
    public List<Hotel> getMyHotel(Account account){
    	List<Hotel> Hotellist=Global.db.getHotelsOfOwner(account);
    	return Hotellist;
    }
    public boolean addHotel(Account account,Hotel hotel) {
    	return Global.db.addHotel(account, hotel);
    }
    public boolean modifyHotel(Hotel hotel) {
    	return Global.db.modifyHotel(hotel);
    }
    public boolean modifyRoom(Room room) {
    	return Global.db.modifyRoom(room);
    }
    
    @Resource(name = "loginInfoSession")
	LoginInfo loginInfo;
	
	@RequestMapping(value={"hotelmanagement", "hotelmanagement.html"})
    public String gethotelManagementPage(Model model) {
    	System.out.println("gethotelManagementPage");
    	model.addAttribute("loginInfo", loginInfo);
        return "hotelmanagement";                        
    }
	
	@RequestMapping(path = "/getMyhotel", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<Hotel> getMyhotel(){
		System.out.println("getMyhotel");
		List<Hotel> Hotellist=Global.db.getHotelsOfOwner(loginInfo.account);
    	System.out.println(Hotellist);
    	return Hotellist;
    }
    
	@RequestMapping(value="/editMyhotel", method=RequestMethod.POST)
    public ResponseEntity<?> getSearchResultViaAjax(
    		@Valid @RequestBody @RequestParam(required = true) int id, @Valid @RequestBody @RequestParam(required = false) String star, 
    		@Valid @RequestBody @RequestParam(required = false) String locality, @Valid @RequestBody @RequestParam(required = false) String street,
    		@Valid @RequestBody @RequestParam(required = false) String action) {
		System.out.println("editMyhotel");
        AjaxResponseBody result = new AjaxResponseBody();
        System.out.println(id+star+locality+street+action);

        //If error, just return a 400 bad request, along with the error message
        //return ResponseEntity.badRequest().body(result);
        return ResponseEntity.ok(result);
	}
    

}
