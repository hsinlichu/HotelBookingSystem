package hotel.booking.controller;

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
	public static List<Hotel> sort_star_LtoH(List<Hotel> search) {
		List<Hotel> tmp = search;
		Hotel swap =new Hotel();
		boolean check = true;
		while (check) {
			check = false;
			for (int i = 0; i < tmp.size(); i++) {
				if (tmp.get(i).getHotelStar() > tmp.get(i+1).getHotelStar()) {
					swap = tmp.get(i);
					tmp.set(i, tmp.get(i+1));
					tmp.set(i+1, swap);
					check = true;
				}
			}
		}
		return tmp;
		
	}
}
