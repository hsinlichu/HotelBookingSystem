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
		List<Hotel> hotels = Global.db.getAllHotel("2019/10/23", "2019/10/24", "台北", 4);

		for(Hotel hotel: hotels){
			System.out.println(hotel);
			// Get the Room of a hotel
			//System.out.println(Global.db.getRoomsOfHotel(hotel));
		} 
		// Add new account 
		System.out.println("Add new account");
		System.out.println(Global.db.addAccount("owner1", "owner1@gmail.com", "password1"));
		System.out.println(Global.db.addAccount("owner2", "owner2@gmail.com", "password2"));
		System.out.println(Global.db.addAccount("owner3", "owner3@gmail.com", "password3"));
		System.out.println(Global.db.addAccount("user1", "user1@gmail.com", "password1"));
		System.out.println(Global.db.addAccount("user2", "user2@gmail.com", "password2"));
		System.out.println(Global.db.addAccount("user3", "user3@gmail.com", "password3"));
		System.out.println(Global.db.addAccount("user4", "user4@gmail.com", "password4"));
		System.out.println(Global.db.addAccount("user5", "user5@gmail.com", "password5"));
		System.out.println(Global.db.addAccount("user6", "user6@gmail.com", "password6"));
		System.out.println(Global.db.addAccount("user7", "user7@gmail.com", "password7"));
		System.out.println(Global.db.addAccount("test", "test@gmail.com", "password"));

		
		// Login with account  
		System.out.println("Login with account");
		Account account1 = Global.db.verifyAccount("owner1@gmail.com", "password1");
		Account account2 = Global.db.verifyAccount("owner2@gmail.com", "password2");
		Account account3 = Global.db.verifyAccount("owner3@gmail.com", "password3");

		
		// Set hotel owner
		System.out.println("Set hotel owner");
		System.out.println(Global.db.setHotelOwner(hotels.get(0), account1));
		System.out.println(Global.db.setHotelOwner(hotels.get(1), account1));
		System.out.println(Global.db.setHotelOwner(hotels.get(2), account1));
		System.out.println(Global.db.setHotelOwner(hotels.get(3), account2));
		System.out.println(Global.db.setHotelOwner(hotels.get(4), account2));
		System.out.println(Global.db.setHotelOwner(hotels.get(5), account3));
		System.out.println(Global.db.setHotelOwner(hotels.get(6), account3));

		
		
		
		System.out.println(Global.db.getAccount(1));
		System.out.println(Global.db.getRoomsOfHotel(1));
		System.out.println(Global.db.getHotelOwner(1));
		
		System.out.println(Global.db.getRoomsOfHotel(1).get(0));

		
			  
		System.out.println(Global.db.addAccount("test", "test@gmail.com", "password"));
		Account account = Global.db.verifyAccount("test@gmail.com", "password");
		Hotel hotel = Global.db.getHotel(1);
		List<Room> selected_rooms = Global.db.getRoomsOfHotel(1);
		selected_rooms.get(0).quantity = 5;
		selected_rooms.get(1).quantity = 5;
		selected_rooms.get(2).quantity = 5;
		Order order = new Order(hotel, "2019/10/24", "2019/10/25", selected_rooms);
		System.out.println(Global.db.addCustomerOrder(account, order)); 
		System.out.println(Global.db.getHotelOwner(1)); 
		System.out.println(account); 
		Account new_account = Global.db.updateAccount(account, "abc", "test123@gmail.com", "password");
		System.out.println(new_account);
	}

}
