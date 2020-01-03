package hotel.booking.controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hotel.booking.Global;
import hotel.booking.container.Account;
import hotel.booking.container.Hotel;
import hotel.booking.container.Order;
import hotel.booking.container.Room;

@Controller
public class InfoCheckController {            
	      
    public String getIssues(Model model) {
    	System.out.println("Resultpage");
        return "  ";                        
    }
    
    public Order bookCheck(Hotel hotel, String dateIn, String dateOut, int numofSingle, int numofDouble, int numofQuad) {
    	// Given a hotel and dateIn~dateOut, and the number of room the user want to book, 
        // this function will check if the desired room are available, and create an order for you.
        // (If not all rooms are available, it will return null.)
        boolean available = true;
    	List<Room> roomlist = Global.db.getRoomsOfHotel(hotel);
    	if (Global.db.roomLeft(roomlist.get(0), dateIn, dateOut) >= numofSingle) {   //not finished yet
    		available = false;
    	}
    	if (Global.db.roomLeft(roomlist.get(1), dateIn, dateOut) >= numofDouble) {
    		available = false;
    	}
    	if (Global.db.roomLeft(roomlist.get(2), dateIn, dateOut) >= numofQuad) {
    		available = false;
    	}
    	if(available = true) {
    		List<Room> orderRoomlist = new ArrayList<>();
    		Room single_room = new Room(roomlist.get(0).id, roomlist.get(0).type, roomlist.get(0).price, numofSingle);
    		Room double_room = new Room(roomlist.get(1).id, roomlist.get(1).type, roomlist.get(1).price, numofDouble);
    		Room quad_room = new Room(roomlist.get(2).id, roomlist.get(2).type, roomlist.get(2).price, numofQuad);
    		orderRoomlist.add(single_room);
    		orderRoomlist.add(double_room);
    		orderRoomlist.add(quad_room);
            Order order = new Order(dateIn, dateOut, orderRoomlist);
            return order;
    	}else{
            return null;
        }
    }
    
    public boolean bookComplete(Account account, Order order) {
        // Place an order. Return true if success, false if failed. 
    	return Global.db.addCustomerOrder(account, order); 
    }

}
