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
		gobal.db = new Database("database/hotel.db", "resource/HotelList.json");
		gobal.db.test();

		// Get hotel list, this will return a breif list of Hotel
		List<Hotel> hotels = gobal.db.getAllHotel("2019/10/23", "2019/10/24", "台北", 4);
		for(Hotel hotel: hotels){
			System.out.println(hotel);
			// Get the Room of a hotel
			//System.out.println(gobal.db.getRoomsOfHotel(hotel));
		} 
		// Add new account 
		System.out.println("Add new account");
		System.out.println(gobal.db.addAccount("owner1", "owner1@gmail.com", "password1"));
		System.out.println(gobal.db.addAccount("owner2", "owner2@gmail.com", "password2"));
		System.out.println(gobal.db.addAccount("owner3", "owner3@gmail.com", "password3"));
		System.out.println(gobal.db.addAccount("user1", "user1@gmail.com", "password1"));
		System.out.println(gobal.db.addAccount("user2", "user2@gmail.com", "password2"));
		System.out.println(gobal.db.addAccount("user3", "user3@gmail.com", "password3"));
		System.out.println(gobal.db.addAccount("user4", "user4@gmail.com", "password4"));
		System.out.println(gobal.db.addAccount("user5", "user5@gmail.com", "password5"));
		System.out.println(gobal.db.addAccount("user6", "user6@gmail.com", "password6"));
		System.out.println(gobal.db.addAccount("user7", "user7@gmail.com", "password7"));
		System.out.println(gobal.db.addAccount("test", "test@gmail.com", "password"));
		
		// Login with account  
		System.out.println("Login with account");
		Account account1 = gobal.db.verifyAccount("owner1@gmail.com", "password1");
		Account account2 = gobal.db.verifyAccount("owner2@gmail.com", "password2");
		Account account3 = gobal.db.verifyAccount("owner3@gmail.com", "password3");
		
		
		// Set hotel owner
		System.out.println("Set hotel owner");
		System.out.println(gobal.db.setHotelOwner(hotels.get(0), account1));
		System.out.println(gobal.db.setHotelOwner(hotels.get(1), account1));
		System.out.println(gobal.db.setHotelOwner(hotels.get(2), account1));
		System.out.println(gobal.db.setHotelOwner(hotels.get(3), account2));
		System.out.println(gobal.db.setHotelOwner(hotels.get(4), account2));
		System.out.println(gobal.db.setHotelOwner(hotels.get(5), account3));
		System.out.println(gobal.db.setHotelOwner(hotels.get(6), account3));
		
		

		System.out.println(gobal.db.getAccount(1));
		System.out.println(gobal.db.getRoomsOfHotel(1));
		System.out.println(gobal.db.getHotelOwner(1));
		
		
		
		System.out.println(gobal.db.addAccount("test", "test@gmail.com", "password"));
		Account account = gobal.db.verifyAccount("test@gmail.com", "password");
		Hotel hotel = gobal.db.getHotel(1);
		List<Room> selected_rooms = gobal.db.getRoomsOfHotel(1);
		Order order = new Order(hotel, "2019/10/23", "2019/10/24", selected_rooms);
		System.out.println(gobal.db.addCustomerOrder(account, order)); 
		System.out.println(gobal.db.getHotelOwner(1)); 
//		System.out.println(gobal.db.getAllHotel("2019/10/23", "2019/10/24", "台北", 4).get(0));
//		System.out.println(gobal.db.getAllHotel("2019/10/23", "2019/10/24", "台北", 4).get(0).rooms); 
	}

}
