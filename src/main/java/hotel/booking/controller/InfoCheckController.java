package hotel.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InfoCheckController {             //定單確認介面(ConfirmInfoUI)
	@RequestMapping(value={"", "/", ".html"})  //換成指定html     
    public String getIssues(Model model) {
    	System.out.println("Resultpage");
        return "  ";                        //換成指定html
    }

}
