package hotel.booking.controller;

import java.util.List;

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
    	Order order = null;
    	boolean available = true;
    	List<Room> roomlist = Global.db.getRoomsOfHotel(hotel);
    	if (Global.db.roomLeft(roomlist.get(0), dateIn, dateOut) < numofSingle) {   //not finished yet
    		available = false;
    	}
    	if (Global.db.roomLeft(roomlist.get(1), dateIn, dateOut) < numofDouble) {
    		available = false;
    	}
    	if (Global.db.roomLeft(roomlist.get(2), dateIn, dateOut) < numofQuad) {
    		available = false;
    	}
    	if(available = true) {
    		List<Room> orderRoomlist = null;
    		Room single = new Room(roomlist.get(0).id, roomlist.get(0).type, roomlist.get(0).price, numofSingle);
    		Room Double = new Room(roomlist.get(1).id, roomlist.get(1).type, roomlist.get(1).price, numofDouble);
    		Room quad = new Room(roomlist.get(2).id, roomlist.get(2).type, roomlist.get(2).price, numofQuad);
    		orderRoomlist.add(single);
    		orderRoomlist.add(Double);
    		orderRoomlist.add(quad);
    		order.dateIn = dateIn;
    		order.dateOut = dateOut;
    		order.selected_rooms = orderRoomlist;
    	}
    	return order;
    }
    
    public boolean complete(Account account, Order order) {
    	boolean execute = Global.db.addCustomerOrder(account, order);      	
    	return execute;
    }

}
