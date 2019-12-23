package hotel.booking.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hotel.booking.container.Hotel;

@Controller
public class HomePageController {
	@RequestMapping(value={"", "/", "index.html"})
    public String getIssues(Model model) {
    	System.out.println("Home Page");
        return "index";
    }
	public List<Hotel> FilteredHotel(List<Hotel> search,int Downfloor,int Upfloor){
		List<Integer> price=new ArrayList<>();
		for(int i=Downfloor;i<=Upfloor;i++) {
			price.add(i);
		}
		List<Hotel> filterprice = Hotel.stream().filter(user->ages.contains(user.getAge())).collect(Collectors.toList());
		filterAges.stream().forEach(user -> {
		    System.out.println(user.getName()+"======"+user.getEmail());
		});
	}
}
