package hotel.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import hotel.booking.database.Database;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("Init");
		
		System.out.println("Working Directory = " + System.getProperty("user.dir"));
		gobal.db = new Database("database/hotel.db", "resource/HotelList.json");
		gobal.db.test();
	}

}
