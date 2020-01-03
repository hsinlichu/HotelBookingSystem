package hotel.booking.controller;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hotel.booking.Global;
import hotel.booking.container.Account;
import hotel.booking.container.Hotel;
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
    

}
