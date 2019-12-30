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
		List<Hotel> filtered=new ArrayList<>();
			
		
				for(int i=0;i<search.size();i++) {
				if(Downfloor<=search.get(i).rooms.&&search.get<=Upfloor) {
						filtered.add(search.get(i));
				}
				}
		
	}
}
