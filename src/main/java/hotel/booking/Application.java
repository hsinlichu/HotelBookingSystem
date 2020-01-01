package hotel.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import hotel.booking.database.Database;
import hotel.booking.container.Hotel;
import hotel.booking.container.*;

import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("Init");
		
		System.out.println("Working Directory = " + System.getProperty("user.dir"));
		Global.db = new Database("database/hotel.db", "resource/HotelList.json");
		Global.db.test();

		// Get hotel list, this will return a breif list of Hotel
		List<Hotel> hotels = Global.db.getAllHotel();
		for(Hotel hotel: hotels){
			System.out.println(hotel);
			// Get the Room of a hotel
			//System.out.println(gobal.db.getRoomsOfHotel(hotel));
		}

		// Add new account
		System.out.println("Add new account");
		System.out.println(Global.db.addAccount("user1", "user1@gmail.com", "password1"));
		System.out.println(Global.db.addAccount("user2", "user2@gmail.com", "password2"));
		System.out.println(Global.db.addAccount("user3", "user3@gmail.com", "password3"));
		System.out.println(Global.db.addAccount("user4", "user4@gmail.com", "password4"));
		System.out.println(Global.db.addAccount("user5", "user5@gmail.com", "password5"));
		System.out.println(Global.db.addAccount("user6", "user6@gmail.com", "password6"));
		System.out.println(Global.db.addAccount("user7", "user7@gmail.com", "password7"));
		System.out.println(Global.db.addAccount("test", "test@gmail.com", "password"));
		System.out.println(Global.db.addAccount("test", "test@gmail.com", "password"));
		
		
		// Login with account
		System.out.println("Login with account");
		System.out.println(Global.db.verifyAccount("user1@gmail.com", "password1"));
		System.out.println(Global.db.verifyAccount("user1@gmail.com", "password2"));
		
		// Set hotel owner
		System.out.println("Set hotel owner");
		System.out.println(Global.db.setHotelOwner(1, 1));
		System.out.println(Global.db.setHotelOwner(2, 2));
		System.out.println(Global.db.setHotelOwner(3, 3));
		System.out.println(Global.db.setHotelOwner(4, 4));
		System.out.println(Global.db.setHotelOwner(5, 5));
		System.out.println(Global.db.setHotelOwner(6, 6));
		System.out.println(Global.db.setHotelOwner(7, 7));
		
		
		
		System.out.println(Global.db.getAccount(1));
		System.out.println(Global.db.getRoomsOfHotel(1));
		System.out.println(Global.db.getHotelOwner(1));
		
		System.out.println(Global.db.getRoomsOfHotel(1).get(0));

		
			
		System.out.println(Global.db.addAccount("test", "test@gmail.com", "password"));
		Account account = Global.db.verifyAccount("test@gmail.com", "password");
		Hotel hotel = Global.db.getHotel(1);
		List<Room> selected_rooms = Global.db.getRoomsOfHotel(1);
		Order order = new Order(hotel, "2019/10/23", "2019/10/24", selected_rooms);
		System.out.println(Global.db.addCustomerOrder(account, order));

	}

}
