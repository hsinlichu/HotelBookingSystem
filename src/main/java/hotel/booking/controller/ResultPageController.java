package hotel.booking.controller;

import java.util.*;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hotel.booking.container.*;

@Controller
public class ResultPageController {  
	private String checkin_date;
	private String checkout_date;
	private String location;
	private String person;
	private int star = 0;
	private int price_from = -1;
	private int price_to = -1;
	
	@RequestMapping(value="/result", method=RequestMethod.POST)
    public String getIssues(@RequestParam String checkin_date, @RequestParam String checkout_date, @RequestParam String location, @RequestParam int person, Model model) {
    	System.out.println("Resultpage");
    	System.out.println(checkin_date+"\n"+checkout_date+"\n"+location+"\n"+person);
    	
    	this.checkin_date = null;
    	this.checkout_date = null;
    	this.location = null;
    	this.person = null;
    	
        return "result";                       
	}
	@RequestMapping(value="/result", method=RequestMethod.GET)
    public String getfilter(@RequestParam int star, @RequestParam int pricefrom, @RequestParam int priceto, Model model) {
    	System.out.println("Resultpage");
    	System.out.println(star+"\n"+pricefrom+"\n"+priceto+"\n");
    	
    	this.star = star;
    	this.price_from = pricefrom;
    	this.price_to = priceto;
    	
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
	
	@RequestMapping(path = "/GetAllHotel", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<ResultHotel> GetAllHotel() {
        return null;
    }

}
