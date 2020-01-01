package hotel.booking.container;

import org.springframework.context.annotation.Bean;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.context.annotation.Configuration;


@Configuration
public class LoginInfo {
	public boolean islogin = false;
	public String name;
	public String email;
	
	@Bean
	@SessionScope
	public LoginInfo loginInfoSession() {
	    return new LoginInfo();
	}
	
	public Boolean getLoginStatus() {
	    return this.islogin;
	}
	public Boolean setLoginStatus(Boolean newStatus) {
	    this.islogin = newStatus;
	    return this.getLoginStatus();
	}

}

