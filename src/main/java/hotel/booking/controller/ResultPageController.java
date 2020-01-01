package hotel.booking.controller;

import java.util.ArrayList;
import java.util.List;

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
	public List<Hotel> FilteredHotel(List<Hotel> search,int Downfloor,int Upfloor,int SinNum,int DouNum,int QuaNum){//create new list to store totalprice within downfloor price and upfloor price
		List<Hotel> filteredtotal=new ArrayList<>();
		for(int i=0;i<search.size();i++) {
			if(SinNum*search.get(i).rooms.get(0).price+DouNum*search.get(i).rooms.get(1).price+QuaNum*search.get(i).rooms.get(2).price>=Downfloor&&SinNum*search.get(i).rooms.get(0).price+DouNum*search.get(i).rooms.get(1).price+QuaNum*search.get(i).rooms.get(2).price<=Upfloor)
			filteredtotal.add(search.get(i));
		}
				
		return filteredtotal;
	}

}
