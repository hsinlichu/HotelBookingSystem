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
	

	public List<Hotel> FilteredHotel(List<Hotel> search,int downfloor,int upfloor,int sinnum,int dounum,int quanum){//create new list to store totalprice within downfloor price and upfloor price

		List<Hotel> filteredtotal=new ArrayList<>();
		for(int i=0;i<search.size();i++) {
			if(sinnum*search.get(i).rooms.get(0).price+dounum*search.get(i).rooms.get(1).price+quanum*search.get(i).rooms.get(2).price>=downfloor&&sinnum*search.get(i).rooms.get(0).price+dounum*search.get(i).rooms.get(1).price+quanum*search.get(i).rooms.get(2).price<=upfloor)
			filteredtotal.add(search.get(i));
		}
				
		return filteredtotal;
	}
	public static List<Hotel> sort_star_LtoH(List<Hotel> search) {
		List<Hotel> tmp = search;
		Hotel swap =new Hotel();
		boolean check = true;
		while (check) {
			check = false;
			for (int i = 0; i < tmp.size()-1; i++) {
				if (tmp.get(i).star > tmp.get(i+1).star) {
					swap = tmp.get(i);
					tmp.set(i, tmp.get(i+1));
					tmp.set(i+1, swap);
					check = true;
				}
			}
		}
		return tmp;
		
	}
	public static List<Hotel> sort_star_HtoL(List<Hotel> search) {
		List<Hotel> tmp = search;
		Hotel swap =new Hotel();
		boolean check = true;
		while (check) {
			check = false;
			for (int i = 0; i < tmp.size()-1; i++) {
				if (tmp.get(i).star < tmp.get(i+1).star) {
					swap = tmp.get(i);
					tmp.set(i, tmp.get(i+1));
					tmp.set(i+1, swap);
					check = true;
				}
			}
		}
		return tmp;
		
	}
	
	@RequestMapping(path = "/GetAllHotel", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<ResultHotel> GetAllHotel() {
        return null;
    }

}
