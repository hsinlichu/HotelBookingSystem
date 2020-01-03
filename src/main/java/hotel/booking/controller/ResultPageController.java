package hotel.booking.controller;

import java.util.*;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hotel.booking.Global;
import hotel.booking.container.*;

@Controller
public class ResultPageController {  
	public String checkin_date;
	public String checkout_date;
	public String location;
	public int person;
	private int star = 0;
	private int price_from = -1;
	private int price_to = -1;
	
	@RequestMapping(value="/result", method=RequestMethod.POST)
    public String getIssues(@RequestParam String checkin_date, @RequestParam String checkout_date, @RequestParam String location, @RequestParam int person, Model model) {
    	System.out.println("Resultpage");
    	System.out.println(checkin_date+"\n"+checkout_date+"\n"+location+"\n"+person);
    	 	
    	this.checkin_date = dateChangeType(checkin_date);
    	this.checkout_date = dateChangeType(checkout_date);
    	this.location = location;
    	this.person = person;
    	
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
		int numofSingle = this.person % 4 % 2;
		int numofDouble = this.person % 4 / 2;
		int numofQuad = this.person / 4;
		List<Hotel> hotel = Global.db.getAllHotel(this.checkin_date, this.checkout_date, this.location, this.person);
		
		List<ResultHotel> resultHotel = new ArrayList<>();
		
		for (int i = 0; i < hotel.size(); i++) {
			int hotelId = hotel.get(i).id;
			int priceofSingle = hotel.get(i).rooms.get((hotelId * 3) - 3).price;
			int priceofDouble = hotel.get(i).rooms.get((hotelId * 3) - 2).price;
			ResultHotel addHotel = new ResultHotel();
			int priceofQuad = hotel.get(i).rooms.get(hotelId * 3 - 1).price;
			addHotel.id = hotelId;
			addHotel.locality = hotel.get(i).locality;
			addHotel.star = hotel.get(i).star;
			addHotel.street = hotel.get(i).street;
			addHotel.singleRoomNum = hotel.get(i).rooms.get((hotelId * 3) - 3).quantity;
			addHotel.singleRoomPrice = priceofSingle;
			addHotel.doubleRoomNum = hotel.get(i).rooms.get((hotelId * 3) - 2).quantity;
			addHotel.doubleRoomPrice = priceofDouble;
			addHotel.quadRoomNum = hotel.get(i).rooms.get(hotelId * 1).quantity;
			addHotel.quadRoomPrice = priceofQuad;
			addHotel.avgprice = numofSingle * priceofSingle + numofDouble * priceofDouble + numofQuad * priceofQuad;
			resultHotel.add(addHotel);
			System.out.println(priceofDouble);
			System.out.println(priceofSingle);
			System.out.println(hotelId);
			System.out.println(hotelId * 3 - 1);
			System.out.println(addHotel.avgprice);
			System.out.println(addHotel.quadRoomNum);
			System.out.println(resultHotel.get(0).avgprice +"success");
		}	
		System.out.println(resultHotel.get(0).avgprice );
		System.out.println("success" );
		
        return resultHotel;
    }
    
	
	public static String dateChangeType(String checkin_date) {
		String datein[] = checkin_date.split(" ");
		String[] month1 = datein[1].split(",");
		String year = datein[2];
		String month = null;
		String day = null;
		switch (month1[0]) {
		case "January":
			month = "01";
			break;
		case "Fabruary":
			month = "02";
			break;
		case "March":
			month = "03";
			break;
		case "April":
			month = "04";
			break;
		case "May":
			month = "05";
			break;
		case "June":
			month = "06";
			break;
		case "July":
			month = "07";
			break;
		case "August":
			month = "08";
			break;
		case "September":
			month = "09";
			break;
		case "October":
			month = "10";
			break;
		case "November":
			month = "11";
			break;
		case "December":
			month = "12";	
			break;
		default :
			break;
	    }
		
		switch (datein[0]) {
		case "1":
			day = "01";
			break;
		case "2":
			day = "02";
			break;
		case "3":
			day = "03";
			break;
		case "4":
			day = "04";
			break;
		case "5":
			day = "05";
			break;
		case "6":
			day = "06";
			break;
		case "7":
			day = "07";
			break;
		case "8":
			day = "08";
			break;
		case "9":
			day = "09";
			break;
		default :
			day = datein[0];
			break;
	    }
		checkin_date = (year + "/" + month + "/" + day);
		return checkin_date;
	}

}
