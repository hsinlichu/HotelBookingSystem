package hotel.booking.controller;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hotel.booking.container.Hotel;
import hotel.booking.container.Room;
import hotel.booking.database.Database;

@Controller
public class HomePageController {
	@RequestMapping(value={"", "/", "index.html"})
    public String getIssues(Model model) {
    	System.out.println("Home Page");
        return "index";
    }
	public List<Hotel> FilteredHotel(List<Hotel> search,int Downfloor,int Upfloor,int SinNum,int DouNum,int QuaNum){
		for(Hotel totalprice:search) {
			db.getRoomsOfHotel(totalprice.id);
		}
				for(int i=0;i<;i++) {
				if(a<=price2.get(i)&&price2.get(i)<=b) {
						price3.add(price2.get(i));
				}
				}
		
	}
}
