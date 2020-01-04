package hotel.booking.container;
import hotel.booking.container.Room;
import hotel.booking.container.Hotel;
import java.util.List;

public class Order {
	public int id;
	public String dateIn;
	public String dateOut;
	public Room room;

	public Order(){
		//Default constructor
		this.id = -1;
		this.dateIn = "";
		this.dateOut = "";
	}
	

	public Order(String dateIn, String dateOut, Room room){
		// Parameter constructor
		this.id = -1;
		this.dateIn = dateIn;
		this.dateOut = dateOut;
		this.room = room;
	}

	public Order(int id, String dateIn, String dateOut, Room room){
		// Parameter constructor
		this.id = id;
		this.dateIn = dateIn;
		this.dateOut = dateOut;
		this.room = room;
	}

	@Override 
	public String toString() {
		// return String representation of the class
        return "-----Order-----\n" + 
        	   "id: " + this.id + "\n" + 
        	   "dateIn: " + this.dateIn + "\n" + 
        	   "dateOut: " +  this.dateOut + "\n" + 
        	   this.room;
    }
}
