package hotel.booking.controller;

import java.util.*;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hotel.booking.container.Hotel;

@Controller
public class ResultPageController {    
	@RequestMapping(value="/result", method=RequestMethod.POST)
    public String getIssues(@RequestParam String checkin_date, @RequestParam String checkout_date, @RequestParam String location, @RequestParam int person, Model model) {
    	System.out.println("Resultpage");
    	System.out.println(checkin_date+"\n"+checkout_date+"\n"+location+"\n"+person);
    	
        return "result";                       
    
	}
	public List<Hotel> FilteredHotel(List<Hotel> search,int downfloor,int upfloor,int sinnum,int dounum,int quanum){//create new list to store totalprice within downfloor price and upfloor price
		List<Hotel> filteredtotal=new ArrayList<>();
		for(int i=0;i<search.size();i++) {
			if(sinnum*search.get(i).rooms.get(0).price+dounum*search.get(i).rooms.get(1).price+quanum*search.get(i).rooms.get(2).price>=downfloor&&sinnum*search.get(i).rooms.get(0).price+dounum*search.get(i).rooms.get(1).price+quanum*search.get(i).rooms.get(2).price<=upfloor)
			filteredtotal.add(search.get(i));
		}
				
		return filteredtotal;
	}

}
